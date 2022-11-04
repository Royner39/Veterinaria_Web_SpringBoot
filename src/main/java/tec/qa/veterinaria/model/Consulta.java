package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Entity
@Table(name="consulta")
public class Consulta {

    /*
    Atributos de la clase Consulta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha;
    //Relación con la clase consulta
    @ManyToOne
    @JoinTable(name = "medico_consulta",joinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_medico", insertable =  false, updatable = false))
    private Medico medico;
    //Relación con la clase Expediente
    @ManyToOne
    @JoinTable(name = "consulta_expediente",joinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_expediente", insertable =  false, updatable = false))
    private Expediente expediente;
    //Relación con la clase Mascota
    @ManyToOne
    @JoinTable(name = "mascota_consulta",joinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false))
    private Mascota mascota;
    //Relación con la clase Factura
    @OneToMany
    @JoinTable(name = "facturacion_consulta",joinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_factura", insertable =  false, updatable = false))
    private List<Facturacion> facturas;

    public Consulta() {
    }

    /*
    Parametros: Id asociado a la consulta, descripcion de la consulta, fecha de la consulta, medico que atendio la consulta, expediente de la consulta, mascota de la consulta, facturas de la consulta
    Retorno: N/A
    Descripción: Constructor de consulta
    */
    public Consulta(int id, String descripcion, Date fecha, Medico medico, List<Producto> receta, Expediente expediente, Mascota mascota, List<Facturacion> facturas) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.medico = medico;
        this.expediente = expediente;
        this.mascota = mascota;
        this.facturas = facturas;
    }

    /*
    Parametros: N/A
    Retorno: Id asociado a la consulta
    Descripción: Retorna el id de la consulta
     */
    public int getId() {
        return id;
    }

    /*
    Parametros: Id asociado a la consulta
    Retorno: N/A
    Descripción: Asigna el id de la consulta
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
    Parametros: N/A
    Retorno: Descripcion de la consulta
    Descripción: Retorna la descripcion de la consulta
     */
    public String getDescripcion() {
        return descripcion;
    }

    /*
    Parametros: Descripcion de la consulta
    Retorno: N/A
    Descripción: Asigna la descripcion de la consulta
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
    Parametros: N/A
    Retorno: Fecha de la consulta
    Descripción: Retorna la fecha de la consulta
     */
    public Date getFecha() {
        return fecha;
    }
    /*
    Parametros: Fecha de la consulta
    Retorno: N/A
    Descripción: Asigna la fecha de la consulta
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /*
    Parametros: N/A
    Retorno: Medico que atendio la consulta
    Descripción: Retorna el medico que atendio la consulta
     */
    public Medico getMedico() {
        return medico;
    }

    /*
    Parametros: Medico que atendio la consulta
    Retorno: N/A
    Descripción: Asigna el medico que atendio la consulta
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /*
    Parametros: N/A
    Retorno: Expediente de la consulta
    Descripción: Retorna el expediente de la consulta
     */
    public Expediente getExpediente() {
        return expediente;
    }

    /*
    Parametros: Expediente de la consulta
    Retorno: N/A
    Descripción: Asigna el expediente de la consulta
     */
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    /*
    Parametros: N/A
    Retorno: Mascota de la consulta
    Descripción: Retorna la mascota de la consulta
     */
    public Mascota getMascota() {
        return mascota;
    }

    /*
    Parametros: Mascota de la consulta
    Retorno: N/A
    Descripción: Asigna la mascota de la consulta
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /*
    Parametros: N/A
    Retorno: Facturas de la consulta
    Descripción: Retorna las facturas de la consulta
     */
    public List<Facturacion> getFacturas() {
        return facturas;
    }

    /*
    Parametros: Facturas de la consulta
    Retorno: N/A
    Descripción: Asigna las facturas de la consulta
     */
    public void setFacturas(List<Facturacion> facturas) {
        this.facturas = facturas;
    }
}