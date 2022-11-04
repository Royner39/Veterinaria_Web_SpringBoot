package tec.qa.veterinaria.model;

import javax.persistence.*;
import java.util.List;
/*
Autores: Pablo Muñoz Hidalgo, Luis Andrés Rojas, Royner Miranda Segura
Clase: Aseguramiento de la Calidad de Software
ITCR 2022
 */
@Entity
@Table(name="expediente")
public class Expediente {

    /*
    Atributos de la clase Expediente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name="id")
    private int id;
    //Relación con la clase Mascota
    @OneToOne
    @JoinTable(name = "mascota_expediente",joinColumns = @JoinColumn(name = "id_expediente", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_mascota", insertable =  false, updatable = false))
    private Mascota mascota;
    //Relación con la clase Consulta
    @OneToMany
    @JoinTable(name = "consulta_expediente",joinColumns = @JoinColumn(name = "id_expediente", insertable =  false, updatable = false),inverseJoinColumns = @JoinColumn(name = "id_consulta", insertable =  false, updatable = false))
    private List<Consulta> consultas;

    public Expediente() {
    }

    /*
    Parametros: Id asociado al expediente, mascota asociada al expediente, lista de consultas asociadas al expediente
    Retorno: N/A
    Descripción: Constructor de expediente
    */
    public Expediente(int id, Mascota mascota, List<Consulta> consultas) {
        this.id = id;
        this.mascota = mascota;
        this.consultas = consultas;
    }

    /*
    Parametros: N/A
    Retorno: Id asociado al expediente
    Descripción: Retorna el id asociado al expediente
     */
    public int getId() {
        return id;
    }

    /*
    Parametros: Id asociado al expediente
    Retorno: N/A
    Descripción: Asigna el id asociado al expediente
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
    Parametros: N/A
    Retorno: Mascota asociada al expediente
    Descripción: Retorna la mascota asociada al expediente
     */
    public Mascota getMascota() {
        return mascota;
    }

    /*
    Parametros: Mascota asociada al expediente
    Retorno: N/A
    Descripción: Asigna la mascota asociada al expediente
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /*
    Parametros: N/A
    Retorno: Lista de consultas asociadas al expediente
    Descripción: Retorna la lista de consultas asociadas al expediente
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /*
    Parametros: Lista de consultas asociadas al expediente
    Retorno: N/A
    Descripción: Asigna la lista de consultas asociadas al expediente
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
