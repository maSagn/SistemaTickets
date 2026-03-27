package com.Msanchez.SistemaTickets.DTO;

public class UsuarioDTO {
    private int IdUsuario;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Email;
    private String Password;

    private RolDTO Rol;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public RolDTO getRol() {
        return Rol;
    }

    public void setRol(RolDTO rol) {
        Rol = rol;
    }
}
