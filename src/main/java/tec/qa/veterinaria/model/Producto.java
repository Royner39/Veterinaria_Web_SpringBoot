package tec.qa.veterinaria.model;

import javax.persistence.*;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Entity
@Table(name="producto")
public class Producto {

    /*
    Atributos de la clase Producto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private double precio;
    @Column(name = "stock")
    private int stock;

    //Relación con la clase Factura
    @ManyToOne
    @JoinTable(name = "facturacion_producto",joinColumns = @JoinColumn(name = "id_producto", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_factura", insertable =  false, updatable = false))
    private Facturacion factura;

    public Producto() {
    }

    /*
    Parametros: Id del producto, descripcion del producto, precio del producto, stock del producto
    Retorno: N/A
    Descripción: Constructor de producto
    */
    public Producto(int id, String descripcion, double precio, int stock, Consulta consulta, Facturacion factura) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.factura = factura;
    }

    /*
    Parametros: N/A
    Retorno: Id del producto
    Descripción: Retorna el id del producto
     */
    public int getId() {
        return id;
    }

    /*
    Parametros: Id del producto
    Retorno: N/A
    Descripción: Asigna el id del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
    Parametros: N/A
    Retorno: Descripcion del producto
    Descripción: Retorna la descripcion del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /*
    Parametros: Descripcion del producto
    Retorno: N/A
    Descripción: Asigna la descripcion del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
    Parametros: N/A
    Retorno: Precio del producto
    Descripción: Retorna el precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /*
    Parametros: Precio del producto
    Retorno: N/A
    Descripción: Asigna el precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*
    Parametros: N/A
    Retorno: Stock del producto
    Descripción: Retorna el stock del producto
     */
   public int getStock() {
        return stock;
    }

    /*
    Parametros: Stock del producto
    Retorno: N/A
    Descripción: Asigna el stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /*
    Parametros: N/A
    Retorno: Factura del producto
    Descripción: Retorna la factura del producto
     */
    public Facturacion getFactura() {
        return factura;
    }

    /*
    Parametros: Factura del producto
    Retorno: N/A
    Descripción: Asigna la factura del producto
     */
    public void setFactura(Facturacion factura) {
        this.factura = factura;
    }
}