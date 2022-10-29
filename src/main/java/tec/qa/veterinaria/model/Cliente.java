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
    @Column(name="password")
    private String password;
    @OneToMany
    @JoinTable(name = "cliente_mascota",joinColumns = @JoinColumn(name = "cedula"),inverseJoinColumns = @JoinColumn(name = "id_mascota"))
    private List<Mascota> mascotas;

    public Cliente() {
    }

    public Cliente(int cedula, String nombre, int telefono, String email, String password, List<Mascota> mascotas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.mascotas = mascotas;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
