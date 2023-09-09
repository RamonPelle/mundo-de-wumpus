package entities;

abstract class Monstro extends Entidade implements Infectar{
    public Monstro() {
        geraPosicoes(Tabuleiro.getTabuleiro());
        infectaAdj(Tabuleiro.getTabuleiro());
    }


    public void infectaAdj(Casa[][] tabuleiro) {
        limpaAdj(tabuleiro);
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
    private void limpaAdj(Casa[][] tabuleiro){
        for (int i = 0; i < Tabuleiro.TAMANHO; i++) {
            for (int j = 0; j < Tabuleiro.TAMANHO; j++) {
                tabuleiro[i][j].setFedor(0);
            }
        }
    }
}
