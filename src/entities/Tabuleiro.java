package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabuleiro {
    private static Casa tabuleiro[][];

    private final static Integer TAMANHO = 5;
    private static Integer madeira = 10;

    private List<Entidade> entidades = new ArrayList();
    public Tabuleiro(){
        this.tabuleiro = geraTabuleiro();
        geraEntidades();
        geraItens();
        //printTabuleiro(this.tabuleiro);
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
    private void geraEntidades(){
        Wagner wagner = new Wagner();
        Wumpus wumpus = new Wumpus();
        Poco poco1 = new Poco();
        Poco poco2 = new Poco();
        Agente agente = new Agente();

        this.entidades.add(wagner);
        this.entidades.add(wumpus);
        this.entidades.add(poco1);
        this.entidades.add(poco2);
        this.entidades.add(agente);
    }

    private void geraItens(){
        Random random = new Random();
        Integer posX;
        Integer posY;
        Boolean temPoco;


        //Randomiza as madeiras
        for(Integer i = 0; i < madeira; i++){
            do {
                posX = random.nextInt(Tabuleiro.getTamanho());
                posY = random.nextInt(Tabuleiro.getTamanho());
                temPoco = tabuleiro[posX][posY].getEntidades().stream().anyMatch(e -> e instanceof Poco);
            } while (!temPoco && tabuleiro[posX][posY].getMadeira() >= 1);

            tabuleiro[posX][posY].setMadeira(1);
        }


        posX = random.nextInt(Tabuleiro.getTamanho());
        posY = random.nextInt(Tabuleiro.getTamanho());

        //Gera o ouro
        while (tabuleiro[posX][posY].estaOcupada()){
            posX = random.nextInt(Tabuleiro.getTamanho());
            posY = random.nextInt(Tabuleiro.getTamanho());
        }
        tabuleiro[posX][posY].setOuro(1);
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
    } //PROV NAO VAI FICAR NESSA CLASSE

    public static Boolean verificaFim(Agente agente){
        return agente.getOuro() == 1 && (agente.getPosX() == 0 && agente.getPosY() == 0);
    } //PROV NAO VAI FICAR NESSA CLASSE
    public static Casa[][] getTabuleiro() {
        return tabuleiro;
    }

    public static Integer getMadeira() {
        return madeira;
    }

    public static void setMadeira(Integer madeira) {
        Tabuleiro.madeira = madeira;
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

    public List<Entidade> getEntidades() {
        return entidades;
    }



}
