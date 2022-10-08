package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="medico")
public class Medico {

    @Id
    @PrimaryKeyJoinColumn(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinTable(name = "medico_consulta",joinColumns = @JoinColumn(name = "id", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id", insertable =  false, updatable = false))
    private List<Consulta> consultas;

    public Medico() {
    }

    public Medico(int id, String nombre, String email, List<Consulta> consultas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.consultas = consultas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
