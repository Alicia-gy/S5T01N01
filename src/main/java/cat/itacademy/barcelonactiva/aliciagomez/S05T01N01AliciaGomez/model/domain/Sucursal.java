package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk_SucursalID;

    @Column(name = "nom")
    private String nomSucursal;

    @Column(name = "pais")
    private String paisSucursal;

    public Sucursal() {

    }

    public Sucursal(String nomSucursal, String paisSucursal) {

        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }


    public int getId() {
        return pk_SucursalID;
    }

    public String getNom() {
        return nomSucursal;
    }

    public void setNom(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPais() {
        return paisSucursal;
    }

    public void setPais(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

}
