package entities;

public interface Andar {
    void andar(Integer direcao);
    Boolean estaNoLimite(Integer posX, Integer posY);
}
