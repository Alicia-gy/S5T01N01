package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;
    private static List<String> paisos = Arrays.asList("austria", "belgica",
            "bulgaria", "croacia", "chipre", "republica Checa", "dinamarca", "estonia",
            "finlandia", "francia", "alemania", "grecia", "hungria", "irlanda", "italia",
            "letonia", "lituania", "luxemburgo", "malta", "paises bajos", "polonia",
            "portugal", "rumania", "eslovaquia", "eslovenia", "españa", "suecia"); //Lista para tipusSucursal

    public SucursalDTO() {
    }


    // Getters y Setters
    public int getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(int pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = paisos.contains(this.paisSucursal.toLowerCase()) ? "UE" : "Fora UE";
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    public static List<String> getPaisos() {
        return paisos;
    }
}
