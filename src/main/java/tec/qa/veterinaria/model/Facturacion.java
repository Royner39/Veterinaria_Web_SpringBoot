package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="facturacion")
public class Facturacion {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "total")
    private double total;

    @OneToMany
    @JoinTable(name = "facturacion_producto",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Producto> productos;
    @ManyToOne
    @JoinTable(name = "facturacion_consulta",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Consulta consulta;

    public Facturacion() {
    }

    public Facturacion(int id, double total, List<Producto> productos, Consulta consulta) {
        this.id = id;
        this.total = total;
        this.productos = productos;
        this.consulta = consulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
