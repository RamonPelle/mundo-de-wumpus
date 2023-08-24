package entities;

public class Tabuleiro {
    private static Casa tabuleiro[][];
    private final static Integer TAMANHO = 5;

    public Tabuleiro(){
        this.tabuleiro = geraTabuleiro();
        Wagner wagner = new Wagner();
        Wumpus wumpus = new Wumpus();
        Poco poco = new Poco();
        Agente agente = new Agente();
        printTabuleiro(this.tabuleiro);
    }

    private static Casa[][] geraTabuleiro(){
        Casa t[][] = new Casa[TAMANHO][TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                t[i][j] = new Casa(0,0);
            }
        }
        return t;
    }

    public static void printTabuleiro(Casa[][] t){
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fim(String msg){
        System.out.println("Voce morreu por conta de: " + msg);
        System.exit(0);
    }
    public static Casa[][] getTabuleiro() {
        return tabuleiro;
    }

    public static void setCasa(Integer x, Integer y, Entidade e){
        tabuleiro[x][y].getEntidades().add(e);
    }
    public static Casa getCasa(Entidade e){
        return tabuleiro[e.getPosX()][e.getPosY()];
    }

    public static Integer getTamanho(){
        return TAMANHO;
    }

}
