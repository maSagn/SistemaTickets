package com.Msanchez.SistemaTickets.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.DTO.ProductoDTO;
import com.Msanchez.SistemaTickets.JPA.Producto;
import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.Repository.IRepositoryDetalleticket;
import com.Msanchez.SistemaTickets.Repository.IRepositoryProducto;

@Service
public class ServiceProducto {

    @Autowired
    private IRepositoryProducto iRepositoryProducto;

    @Autowired
    private IRepositoryDetalleticket iRepositoryDetalleticket;

    public Result GetAll() {
        Result result = new Result();

        try {
            List<Producto> productos = iRepositoryProducto.findAll();

            List<ProductoDTO> listaDTO = new ArrayList<>();

            for (Producto p : productos) {
                ProductoDTO dto = new ProductoDTO();
                dto.setIdProducto(p.getIdProducto());
                dto.setNombre(p.getNombre());
                dto.setPrecioUnitario(p.getPrecioUnitario());
                dto.setDescripcion(p.getDescripcion());
                dto.setImagen(p.getImagen());

                listaDTO.add(dto);
            }

            result.object = listaDTO;
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result GetById(int IdProducto) {
        Result result = new Result();

        try {

            Optional<Producto> producto = iRepositoryProducto.findById(IdProducto);

            if (producto.isPresent()) {
                Producto p = producto.get();

                // Mapear DTO
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setNombre(p.getNombre());
                productoDTO.setPrecioUnitario(p.getPrecioUnitario());
                productoDTO.setDescripcion(p.getDescripcion());
                productoDTO.setImagen(p.getImagen());

                result.object = productoDTO;
                result.correct = true;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Add(Producto producto) {
        Result result = new Result();

        try {
            Producto savedProducto = iRepositoryProducto.save(producto);

            // Mapear DTO
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setPrecioUnitario(producto.getPrecioUnitario());
            productoDTO.setDescripcion(producto.getDescripcion());

            result.object = productoDTO;
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Update(Producto producto, int IdProducto) {
        Result result = new Result();

        try {
            Optional<Producto> productoFind = iRepositoryProducto.findById(IdProducto);

            if (productoFind.isPresent()) {
                Producto productoExistente = productoFind.get();

                productoExistente.setNombre(producto.getNombre());
                productoExistente.setPrecioUnitario(producto.getPrecioUnitario());
                productoExistente.setDescripcion(producto.getDescripcion());

                if (producto.getImagen() != null) {
                    productoExistente.setImagen(producto.getImagen());
                }

                Producto updatedProducto = iRepositoryProducto.save(productoExistente);

                // Mapear DTO
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setNombre(producto.getNombre());
                productoDTO.setPrecioUnitario(producto.getPrecioUnitario());
                productoDTO.setDescripcion(producto.getDescripcion());

                result.object = productoDTO;
                result.correct = true;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Delete(int IdProducto) {
        Result result = new Result();

        try {
            Optional<Producto> productoFind = iRepositoryProducto.findById(IdProducto);

            if (productoFind.isPresent()) {
                int numeroProductoByDetalle = iRepositoryDetalleticket.countByProductoId(IdProducto);

                if (numeroProductoByDetalle == 0) {
                    iRepositoryProducto.deleteById(IdProducto);
                    result.correct = true;
                } else {
                    result.correct = false;
                    result.errorMessage = "No se puede eliminar el producto porque está asignado en algun ticket.";
                }
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }
}
