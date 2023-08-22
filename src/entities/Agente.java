package entities;
public class Agente extends Entidade{
    public Agente() {
        this.setPosX(0);
        this.setPosY(0);
        Tabuleiro.setCasa(this.getPosX(),this.getPosY(),this);
    }

}

