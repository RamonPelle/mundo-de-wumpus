package entities;

public class Wagner extends Monstro{
    public void andar(Integer direcao){
        Integer posX = getPosX();
        Integer posY = getPosY();

        Integer[][] adjPositions = {
                {posX + 2, posY + 1},
                {posX + 2, posY - 1},
                {posX - 2, posY + 1},
                {posX - 2, posY - 1},
                {posX + 1, posY + 2},
                {posX - 1, posY - 2},
                {posX + 1, posY + 2},
                {posX - 1, posY - 2}
        };
        if (direcao >= 0 && direcao <= 7) {
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
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
