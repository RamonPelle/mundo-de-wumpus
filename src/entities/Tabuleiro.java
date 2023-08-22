package entities;

public class Tabuleiro {
    private static Casa tabuleiro[][];

    public Tabuleiro(){
        this.tabuleiro = geraTabuleiro();

        Wumpus wumpus = new Wumpus();
        Poco poco = new Poco();
        Agente agente = new Agente();
        printTabuleiro(this.tabuleiro);
    }

    private static Casa[][] geraTabuleiro(){
        Casa t[][] = new Casa[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                t[i][j] = new Casa(0,0);
            }
        }
        return t;
    }

    public static void printTabuleiro(Casa[][] t){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Casa[][] getTabuleiro() {
        return tabuleiro;
    }

    public static void setCasa(Integer x, Integer y, Entidade e){
        tabuleiro[x][y].getEntidades().add(e);
    }


}
