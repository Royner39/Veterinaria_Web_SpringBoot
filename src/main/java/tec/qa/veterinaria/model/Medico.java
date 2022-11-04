package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Entity
@Table(name="medico")
public class Medico {

    /*
    Atributos de la clase Medico
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    //Relación con la clase Consulta
    @OneToMany
    @JoinTable(name = "medico_consulta",joinColumns = @JoinColumn(name = "id_medico", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false))
    private List<Consulta> consultas;

    public Medico() {
    }

    /*
    Parametros: Id del medico, nombre del medico, email del medico, password del medico
    Retorno: N/A
    Descripción: Constructor de medico
    */
    public Medico(int id, String nombre, String email, String password, List<Consulta> consultas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.consultas = consultas;
    }

    /*
    Parametros: N/A
    Retorno: Id del medico
    Descripción: Retorna el id del medico
     */
    public int getId() {
        return id;
    }

    /*
    Parametros: Id del medico
    Retorno: N/A
    Descripción: Asigna el id del medico
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
    Parametros: N/A
    Retorno: Nombre del medico
    Descripción: Retorna el nombre del medico
     */
    public String getNombre() {
        return nombre;
    }

    /*
    Parametros: Nombre del medico
    Retorno: N/A
    Descripción: Asigna el nombre del medico
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    Parametros: N/A
    Retorno: Email del medico
    Descripción: Retorna el email del medico
     */
    public String getEmail() {
        return email;
    }

    /*
    Parametros: Email del medico
    Retorno: N/A
    Descripción: Asigna el email del medico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
    Parametros: N/A
    Retorno: Password del medico
    Descripción: Retorna el password del medico
     */
    public String getPassword() {
        return password;
    }

    /*
    Parametros: Password del medico
    Retorno: N/A
    Descripción: Asigna el password del medico
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
    Parametros: N/A
    Retorno: Consultas del medico
    Descripción: Retorna las consultas del medico
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /*
    Parametros: Consultas del medico
    Retorno: N/A
    Descripción: Asigna las consultas del medico
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
