package entities;

import java.util.Random;

    public class Wumpus extends Monstro {
        public static Boolean morto = false;

        public void andar(Integer direcao) {

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
                    limpaAdj(Tabuleiro.getTabuleiro(), getPosX(), getPosY());
                    Casa atual = Tabuleiro.getCasa(this);
                    atual.removeEntidade(this);
                    this.setPosX(newX);
                    this.setPosY(newY);
                    Tabuleiro.setCasa(newX, newY, this);
                    infectaAdj(Tabuleiro.getTabuleiro());
                }
            }
        }

        public static void setMorto(Boolean morto) {
            Wumpus.morto = morto;
        }

        @Override
        public String toString() {
            return this.getClass().getName();
        }
    }
