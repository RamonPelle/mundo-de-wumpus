package entities;

import java.util.List;

public class Jogo {
    private Tabuleiro jogo;
    List<Entidade> entities;
    public Jogo(){
        this.jogo = new Tabuleiro();
        this.entities = jogo.getEntidades();
        vezJogador(); //teste
        this.jogo.printTabuleiro(this.jogo.getTabuleiro());
    }

    //teste do Andar()
    private void vezJogador(){
        if (entities.get(4) instanceof Agente) {
            Agente agente = (Agente) entities.get(4);
            agente.andar(0);
        }
    }


}
