package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="mascota")
public class Mascota {

    /*
    * Atributos de la clase Mascota
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "especie")
    private String especie;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
    //Relacion con la clase Expediente
    @OneToOne
    @JoinTable(name = "mascota_expediente",joinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_expediente", insertable =  false, updatable = false))
    private Expediente expediente;
    //Relacion con la clase Cliente
    @ManyToOne()
    @JoinTable(name = "cliente_mascota",joinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "cedula", insertable =  false, updatable = false))
    private Cliente cliente;
    //Relacion con la clase Consulta
    @OneToMany
    @JoinTable(name = "mascota_consulta",joinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false))
    private List<Consulta> consultas;

    public Mascota() {
    }


    /*
    Parametros: Id de la mascota, especie, nombre, fecha de nacimiento, sexo, expediente, cliente y consultas
    Retorno: N/A
    Descripción: Constructor de mascota
    */
    public Mascota(int id, String especie, String nombre, String fechaNacimiento, String sexo, Expediente expediente, Cliente cliente, List<Consulta> consultas) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.expediente = expediente;
        this.cliente = cliente;
        this.consultas = consultas;
    }

    /*
    Parametros: N/A
    Retorno: Id de la mascota
    Descripción: Retorna el id de la mascota
     */
    public int getId() {
        return id;
    }

    /*
Parametros: Id de la mascota
Retorno: N/A
Descripción: Asigna el id de la mascota
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
Parametros: N/A
Retorno: Especie de la mascota
Descripción: Retorna la especie de la mascota
     */
    public String getEspecie() {
        return especie;
    }

    /*
Parametros: Especie de la mascota
Retorno: N/A
Descripción: Asigna la especie de la mascota
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /*
Parametros: N/A
Retorno: Nombre de la mascota
Descripción: Retorna el nombre de la mascota
     */
    public String getNombre() {
        return nombre;
    }

    /*
Parametros: Nombre de la mascota
Retorno: N/A
Descripción: Asigna el nombre de la mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
Parametros: N/A
Retorno: Fecha de nacimiento de la mascota
Descripción: Retorna la fecha de nacimiento de la mascota
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /*
Parametros: Fecha de nacimiento de la mascota
Retorno: N/A
Descripción: Asigna la fecha de nacimiento de la mascota
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /*
Parametros: N/A
Retorno: Sexo de la mascota
Descripción: Retorna el sexo de la mascota
     */
    public String getSexo() {
        return sexo;
    }

    /*
Parametros: Sexo de la mascota
Retorno: N/A
Descripción: Asigna el sexo de la mascota
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /*
Parametros: N/A
Retorno: Expediente de la mascota
Descripción: Retorna el expediente de la mascota
     */
    public Expediente getExpediente() {
        return expediente;
    }

    /*
Parametros: Expediente de la mascota
Retorno: N/A
Descripción: Asigna el expediente de la mascota
     */
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    /*
Parametros: N/A
Retorno: Cliente de la mascota
Descripción: Retorna el cliente de la mascota
     */
    public Cliente getCliente() {
        return cliente;
    }

    /*
Parametros: Cliente de la mascota
Retorno: N/A
Descripción: Asigna el cliente de la mascota
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*
Parametros: N/A
Retorno: Consultas de la mascota
Descripción: Retorna las consultas de la mascota
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /*
Parametros: Consultas de la mascota
Retorno: N/A
Descripción: Asigna las consultas de la mascota
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
