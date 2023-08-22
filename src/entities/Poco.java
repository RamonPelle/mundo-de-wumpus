package entities;

import java.util.Random;

public class Poco extends Entidade implements Infectar{
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

            if((adjX >= 0 && adjX <= 4) && (adjY >= 0 && adjY <= 4)){
                if (!estaOcupada(tabuleiro[adjX][adjY])) {
                    tabuleiro[adjX][adjY].setBrisa(1);
                }
            }
        }
    }

}
