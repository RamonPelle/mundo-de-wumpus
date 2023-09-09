package entities;

import java.util.Random;

public class Poco extends Entidade implements Infectar{

    private Boolean temMadeira = false;
    public Poco() {
        geraPosicoes(Tabuleiro.getTabuleiro());
        infectaAdj(Tabuleiro.getTabuleiro());
    }


    public void infectaAdj(Casa[][] tabuleiro) {
        Integer posX = getPosX();
        Integer posY = getPosY();

        Integer[][] adjPositions = {
                {posX + 1, posY},
                {posX - 1, posY},
                {posX, posY + 1},
                {posX, posY - 1}
        };
        for (Integer[] adjPos : adjPositions) {
            Integer adjX = adjPos[0];
            Integer adjY = adjPos[1];

            if ((adjX >= 0 && adjX <= Tabuleiro.getTamanho() - 1) && (adjY >= 0 && adjY <= Tabuleiro.getTamanho() - 1)) {
                if (!tabuleiro[adjX][adjY].estaOcupada()) {
                    tabuleiro[adjX][adjY].setBrisa(1);
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
