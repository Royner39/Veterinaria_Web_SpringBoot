package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="expediente")
public class Expediente {

    @Id
    @Column(name="id")
    private int id;
    @OneToOne
    @JoinTable(name = "mascota_expediente",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Mascota mascota;
    @OneToMany
    @JoinTable(name = "consulta_expediente",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Consulta> consultas;

    public Expediente() {
    }

    public Expediente(int id, Mascota mascota, List<Consulta> consultas) {
        this.id = id;
        this.mascota = mascota;
        this.consultas = consultas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
