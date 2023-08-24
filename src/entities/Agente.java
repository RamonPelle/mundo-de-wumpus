package entities;
public class Agente extends Entidade implements Andar{

    private Integer madeira = 0;
    private Integer arco = 1;
    private Integer flecha = 0;
    private Integer lanterna = 100;
    private Integer ouro = 0;
    private Integer[] mochila = {madeira, arco, flecha, lanterna, ouro};

    public Agente() {
        this.setPosX(0);
        this.setPosY(0);
        Tabuleiro.setCasa(this.getPosX(),this.getPosY(),this);
    }

    public void andar(Integer direcao){
        Integer posX = getPosX();
        Integer posY = getPosY();

        Integer[][] adjPositions = {
                {posX + 1, posY},
                {posX - 1, posY},
                {posX, posY + 1},
                {posX, posY - 1}
        };
        if (direcao >= 0 && direcao <= 3) {
            Integer newX = adjPositions[direcao][0];
            Integer newY = adjPositions[direcao][1];

            if (estaNoLimite(newX, newY)) {
                Casa atual = Tabuleiro.getCasa(this);
                atual.removeEntidade(this);
                this.setPosX(newX);
                this.setPosY(newY);
                Tabuleiro.setCasa(newX, newY, this);
            }
        }
    }

    private Boolean estaNoLimite(Integer posX, Integer posY){
        Integer tamanhoTabuleiro = Tabuleiro.getTamanho();
        return posX >= 0 && posX < tamanhoTabuleiro && posY >= 0 && posY < tamanhoTabuleiro;
    }
    public void colocaMadeira(){
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

