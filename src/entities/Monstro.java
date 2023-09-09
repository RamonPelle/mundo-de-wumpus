package entities;

public abstract class Monstro extends Entidade implements Infectar{
    public Monstro() {
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
                tabuleiro[adjX][adjY].setFedor(1);
            }
        }
    }
    public static void limpaAdj(Casa[][] tabuleiro, Integer posX, Integer posY){
        Casa atual = tabuleiro[posX][posY];
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
                tabuleiro[adjX][adjY].setFedor(0);
            }
        }
    }
}
