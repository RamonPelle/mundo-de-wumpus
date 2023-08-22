package entities;

import java.util.Random;

abstract class Entidade {
    private Integer posX;
    private Integer posY;
    private Random random = new Random();

    public Entidade() {

    }

    void geraPosicoes(Casa[][] tabuleiro) {

        Random random = new Random();
        Integer novaPosX;
        Integer novaPosY;
        do {
            novaPosX = random.nextInt(5);
            novaPosY = random.nextInt(5);
        } while (estaOcupada(tabuleiro[novaPosX][novaPosY]) && (novaPosX + novaPosY) == 0); //[0,0] É o agente

        Tabuleiro.setCasa(novaPosX,novaPosY,this);
        setPosX(novaPosX);
        setPosY(novaPosY);


    }

    public Boolean estaOcupada(Casa casa){
        return casa.getEntidades().size() != 0;
            }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

}