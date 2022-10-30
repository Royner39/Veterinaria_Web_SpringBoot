package tec.qa.veterinaria.model;

import javax.persistence.*;

@Entity
@Table(name="producto")
public class Producto {

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

    @ManyToOne
    @JoinTable(name = "facturacion_producto",joinColumns = @JoinColumn(name = "id_producto", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_factura", insertable =  false, updatable = false))
    private Facturacion factura;

    public Producto() {
    }

    public Producto(int id, String descripcion, double precio, int stock, Consulta consulta, Facturacion factura) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.factura = factura;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Facturacion getFactura() {
        return factura;
    }

    public void setFactura(Facturacion factura) {
        this.factura = factura;
    }
}