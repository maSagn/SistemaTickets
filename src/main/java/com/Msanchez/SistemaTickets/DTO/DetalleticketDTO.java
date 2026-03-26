package com.Msanchez.SistemaTickets.DTO;

public class DetalleticketDTO {
    private int cantidad;
    private double precioUnitario;
    private double totalLinea;
    private ProductoDTO productoDTO;

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public double getTotalLinea() {
        return totalLinea;
    }
    public void setTotalLinea(double totalLinea) {
        this.totalLinea = totalLinea;
    }
    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }
    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }
}
