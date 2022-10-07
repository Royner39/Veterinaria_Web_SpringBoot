package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="consulta")
public class Consulta {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinTable(name = "medico_consulta",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Medico medico;
    @OneToMany
    @JoinTable(name = "producto_consulta",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Producto> receta;

    @ManyToOne
    @JoinTable(name = "consulta_expediente",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Expediente expediente;
    @ManyToOne
    @JoinTable(name = "mascota_consulta",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Mascota mascota;
    @OneToMany
    @JoinTable(name = "facturacion_consulta",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Facturacion> facturas;

    public Consulta() {
    }

    public Consulta(int id, String descripcion, Date fecha, Medico medico, List<Producto> receta, Expediente expediente, Mascota mascota, List<Facturacion> facturas) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.medico = medico;
        this.receta = receta;
        this.expediente = expediente;
        this.mascota = mascota;
        this.facturas = facturas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Producto> getReceta() {
        return receta;
    }

    public void setReceta(List<Producto> receta) {
        this.receta = receta;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<Facturacion> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Facturacion> facturas) {
        this.facturas = facturas;
    }
}