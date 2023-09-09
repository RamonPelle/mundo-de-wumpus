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
            novaPosX = random.nextInt(Tabuleiro.getTamanho());
            novaPosY = random.nextInt(Tabuleiro.getTamanho());
        } while (tabuleiro[novaPosX][novaPosY].estaOcupada() || (novaPosX + novaPosY) == 0); //[0,0] É o agente

        Tabuleiro.setCasa(novaPosX,novaPosY,this);
        setPosX(novaPosX);
        setPosY(novaPosY);
    }
<<<<<<< HEAD

=======
>>>>>>> c4facee (update: jogo funcional, problema de heranca no infectaAdj Wagner)
    public Boolean estaNoLimite(Integer posX, Integer posY){
        Integer tamanhoTabuleiro = Tabuleiro.getTamanho();
        return posX >= 0 && posX < tamanhoTabuleiro && posY >= 0 && posY < tamanhoTabuleiro;
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
