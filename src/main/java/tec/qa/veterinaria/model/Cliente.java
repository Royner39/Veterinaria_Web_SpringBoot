package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;

/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */

@Entity
@Table(name="cliente")
public class Cliente {

    /*
    Atributos de la clase Cliente
     */
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

    /*
    Creación de la relación entre Cliente y Mascota
     */
    @OneToMany
    @JoinTable(name = "cliente_mascota" ,joinColumns = @JoinColumn(name = "cedula"),inverseJoinColumns = @JoinColumn(name = "id_mascota"))
    private List<Mascota> mascotas;

    public Cliente() {
    }

    /*
    Parametros: Cedula del cliente, nombre del cliente, telefono del cliente, email del cliente, password del cliente, lista de mascotas del cliente
    Retorno: N/A
    Descripción: Constructor de cliente
    */
    public Cliente(int cedula, String nombre, int telefono, String email, String password, List<Mascota> mascotas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.mascotas = mascotas;
    }

    /*
    Parametros: N/A
    Retorno: Cedula del cliente
    Descripción: Obtiene la cedula del cliente
    */
    public int getCedula() {
        return cedula;
    }

        /*
    Parametros:  Cedula del cliente
    Retorno: N/A
    Descripción: Asigna la cedula del cliente
    */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /*
    Parametros: N/A
    Retorno: Nombre del cliente
    Descripción: Obtiene el nombre del cliente
    */
    public String getNombre() {
        return nombre;
    }

    /*
    Parametros:  Nombre del cliente
    Retorno: N/A
    Descripción: Asigna el nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    Parametros: N/A
    Retorno: Telefono del cliente
    Descripción: Obtiene el telefono del cliente
     */
    public int getTelefono() {
        return telefono;
    }

    /*
    Parametros:  Telefono del cliente
    Retorno: N/A
    Descripción: Asigna el telefono del cliente
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /*
    Parametros: N/A
    Retorno: Email del cliente
    Descripción: Obtiene el email del cliente
     */
    public String getEmail() {
        return email;
    }

    /*
    Parametros:  Email del cliente
    Retorno: N/A
    Descripción: Asigna el email del cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
    Parametros: N/A
    Retorno: Password del cliente
    Descripción: Obtiene el password del cliente
     */
    public String getPassword() {
        return password;
    }

    /*
    Parametros:  Password del cliente
    Retorno: N/A
    Descripción: Asigna el password del cliente
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
    Parametros: N/A
    Retorno: Lista de mascotas del cliente
    Descripción: Obtiene la lista de mascotas del cliente
     */
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    /*
    Parametros:  Lista de mascotas del cliente
    Retorno: N/A
    Descripción: Asigna la lista de mascotas del cliente
     */
    public void setMascotas(Mascota mascota) {
        this.mascotas.add(mascota);
    }
}
