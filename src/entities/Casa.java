package entities;


import java.util.ArrayList;
import java.util.List;

public class Casa {
    private List<Entidade> entidades = new ArrayList<>();
    private Integer fedor = 0;
    private Integer brisa = 0;
    private Integer ouro;
    private Integer madeira;
    public Casa(Integer ouro, Integer madeira){
        this.ouro = ouro;
        this.madeira = madeira;

    }
//    public Entidade compararEntidade(Entidade entidade){ //ver agente e poco/wumpus/wagner
//        for(Entidade e : getEntidades()){
//            if(e == entidade)
//                return e;
//        }
//        return null;
//    }
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

    @Override
    public String toString() {
        return "Casa{" +
                "entidades=" + entidades +
                ", fedor=" + fedor +
                ", brisa=" + brisa +
                ", ouro=" + ouro +
                ", madeira=" + madeira +
                '}';
    }
}
