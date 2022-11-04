package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Entity
@Table(name="facturacion")
public class Facturacion {

    /*
    Atributos de la clase Facturacion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "total")
    private double total;

    //Relación con la clase Producto
    @OneToMany
    @JoinTable(name = "facturacion_producto",joinColumns = @JoinColumn(name = "id_factura", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_producto", insertable =  false, updatable = false))
    private List<Producto> productos;
    //Relación con la clase Consulta
    @ManyToOne
    @JoinTable(name = "facturacion_consulta",joinColumns = @JoinColumn(name = "id_factura", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_consulta" , insertable =  false, updatable = false))
    private Consulta consulta;

    public Facturacion() {
    }


    /*
    Parametros: Id de la factura, total de la factura, lista de productos, consulta
    Retorno: N/A
    Descripción: Constructor de facturacion
    */
    public Facturacion(int id, double total, List<Producto> productos, Consulta consulta) {
        this.id = id;
        this.total = total;
        this.productos = productos;
        this.consulta = consulta;
    }

    /*
    Parametros: N/A
    Retorno: Id de la factura
    Descripción: Retorna el id de la factura
     */
    public int getId() {
        return id;
    }

    /*
    Parametros: Id de la factura
    Retorno: N/A
    Descripción: Asigna el id de la factura
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
    Parametros: N/A
    Retorno: Total de la factura
    Descripción: Retorna el total de la factura
     */
    public double getTotal() {
        return total;
    }

    /*
    Parametros: Total de la factura
    Retorno: N/A
    Descripción: Asigna el total de la factura
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /*
    Parametros: N/A
    Retorno: Lista de productos
    Descripción: Retorna la lista de productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /*
    Parametros: Lista de productos
    Retorno: N/A
    Descripción: Asigna la lista de productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /*
    Parametros: N/A
    Retorno: Consulta
    Descripción: Retorna la consulta
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /*
    Parametros: Consulta
    Retorno: N/A
    Descripción: Asigna la consulta
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
