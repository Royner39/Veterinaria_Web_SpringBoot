package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @Column(name="cedula")
    private int cedula;
    @Column(name="nombre")
    private String nombre;
    @Column(name="telefono")
    private int telefono;
    @Column(name="email")
    private String email;
    @OneToMany
    @JoinTable(name = "cliente_mascota",joinColumns = @JoinColumn(name = "cedula"),inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Mascota> mascotas;

    public Cliente(int cedula, String nombre, int telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
