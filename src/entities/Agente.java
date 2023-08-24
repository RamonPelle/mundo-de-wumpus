package entities;
public class Agente extends Entidade{

    private Integer madeira = 0;
    private Integer arco = 0;
    private Integer flecha = 0;
    private Integer lanterna = 100;
    private Integer ouro = 0;
    private Integer[] mochila = {madeira, arco, flecha, lanterna, ouro};

    public Agente() {
        this.setPosX(0);
        this.setPosY(0);
        Tabuleiro.setCasa(this.getPosX(),this.getPosY(),this);
    }

    private void colocaMadeira(){
        if(madeira > 0){
            setMadeira(getMadeira() - 1);
        }else{
            Tabuleiro.fim("Caiu no poço");
        }
    }

    public Integer getMadeira() {
        return madeira;
    }

    public void setMadeira(Integer madeira) {
        this.madeira = madeira;
    }

    public Integer getArco() {
        return arco;
    }

    public void setArco(Integer arco) {
        this.arco = arco;
    }

    public Integer getFlecha() {
        return flecha;
    }

    public void setFlecha(Integer flecha) {
        this.flecha = flecha;
    }

    public Integer getLanterna() {
        return lanterna;
    }

    public void setLanterna(Integer lanterna) {
        this.lanterna = lanterna;
    }

    public Integer getOuro() {
        return ouro;
    }

    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }

    public Integer[] getMochila() {
        return mochila;
    }

}

