package entities;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Casa extends JPanel {
    private List<Entidade> entidades = new ArrayList<>();
    private Integer fedor = 0;
    private Integer brisa = 0;
    private Integer ouro;
    private Integer madeira;
    private Boolean visto = false;
    public Casa(Integer ouro, Integer madeira){
        this.ouro = ouro;
        this.madeira = madeira;

    }
    public Boolean estaOcupada(){
    return this.getEntidades().size() != 0;
}

    public Integer getFedor() {
        return fedor;
    }

    public void setFedor(Integer fedor) {
        this.fedor = fedor;
    }

    public Integer getBrisa() {
        return brisa;
    }

    public void setBrisa(Integer brisa) {
        this.brisa = brisa;
    }

    public Integer getOuro() {
        return ouro;
    }

    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }

    public Integer getMadeira() {
        return madeira;
    }

    public void setMadeira(Integer madeira) {
        this.madeira = madeira;
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }
    public void removeEntidade(Entidade entidade) {
        this.entidades.remove(entidade);
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entidade entidade : entidades) {
            stringBuilder.append(entidade.toString()).append(" ");
        }

        if (!entidades.isEmpty()) {
            stringBuilder.append("");
        }

        if(this.getFedor()==1){
            stringBuilder.append("Fedor:").append(fedor).append(" ");
        }


        if(this.getBrisa()==1){
            stringBuilder.append("brisa=").append(brisa).append(" ");
        }

        if(this.getOuro()==1){
            stringBuilder.append("Ouro=").append(ouro).append(" ");
        }
        if(this.getMadeira()==1){
            stringBuilder.append("madeira=").append(madeira).append(" ");
        }
        stringBuilder.append(" | ");
        return stringBuilder.toString();
    }
}
