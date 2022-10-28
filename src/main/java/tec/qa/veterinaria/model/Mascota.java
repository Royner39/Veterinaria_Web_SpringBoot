package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="mascota")
public class Mascota {

    @Id
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "especie")
    private String especie;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
    @OneToOne
    @JoinTable(name = "mascota_expediente",joinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_expediente", insertable =  false, updatable = false))
    private Expediente expediente;
    @ManyToOne()
    @JoinTable(name = "cliente_mascota",joinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "cedula", insertable =  false, updatable = false))
    private Cliente cliente;
    @OneToMany
    @JoinTable(name = "mascota_consulta",joinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false))
    private List<Consulta> consultas;

    public Mascota() {
    }

    public Mascota(int id, String especie, String nombre, Date fechaNacimiento, String sexo, Expediente expediente, Cliente cliente, List<Consulta> consultas) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.expediente = expediente;
        this.cliente = cliente;
        this.consultas = consultas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
