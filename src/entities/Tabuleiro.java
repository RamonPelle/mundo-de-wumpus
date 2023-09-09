package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    Random random = new Random();
    private static Casa tabuleiro[][];

    public final static Integer TAMANHO = 5;
    private static Integer madeira = 10;
    Scanner sc = new Scanner(System.in);
    private List<Entidade> entidades = new ArrayList(); //0: Wagner, 1: Wumpus, 2,3: Poco, 4: Agente
    public Tabuleiro(){
        this.tabuleiro = geraTabuleiro();
        geraEntidades();
        geraItens();
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
    public void printVisaoAgente(){
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                if(tabuleiro[i][j].getVisto()){
                    System.out.print(tabuleiro[i][j] + " ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void printDebug(){
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void vezMonstros(){
        Entidade wg = this.entidades.get(0);
        Entidade wum = this.entidades.get(1);
        if (wg instanceof Wagner) {
            ((Wagner) wg).andar(random.nextInt(8));
        } else {
            System.out.println("A entidade não é um Wagner.");
        }
        if (wum instanceof Wumpus) {
            ((Wumpus) wum).andar(random.nextInt(4));
        } else {
            System.out.println("A entidade não é um Wagner.");
        }

    }

    public static void iluminarCasas(Integer posX, Integer posY, Integer direcao){
        if (direcao == 1) {
            for (int i = posX; i >= 0; i--) {
                tabuleiro[i][posY].setVisto(true);
            }
        } else if (direcao == 0) {
            for (int i = posX; i < TAMANHO; i++) {
                tabuleiro[i][posY].setVisto(true);
            }
        } else if (direcao==3) {
            for (int j = posY; j >= 0; j--) {
                tabuleiro[posX][j].setVisto(true);
            }
        } else if (direcao==2) {
            for (int j = posY; j < TAMANHO; j++) {
                tabuleiro[posX][j].setVisto(true);
            }
        } else {
            System.out.println("Direção inválida. Use [0-3]");
        }
    }
    public void fim(Agente ag){
        if(getCasa(ag).getEntidades().contains(entidades.get(0)) || getCasa(ag).getEntidades().contains(entidades.get(1))){
            System.out.println("O monstro te pegou! :C");
        }else if(ag.getOuro() == 0){
            System.out.println("Caio no poço! :C");
        }else{
            System.out.println("Parabéns, voce ganhou!");
        }

    }

    public Boolean verificaVitoria(Agente agente){
        return agente.getOuro() == 1 && (agente.getPosX() == 0 && agente.getPosY() == 0);
    }

    public Boolean verificaMorte(Agente ag){
        Boolean ripWagner = getCasa(ag).getEntidades().contains(entidades.get(0));
        Boolean ripWumpus = getCasa(ag).getEntidades().contains(entidades.get(1));
        Boolean ripPoco = getCasa(ag).getEntidades().contains(entidades.get(2)) || getCasa(ag).getEntidades().contains(entidades.get(3));
        if(ripWagner && ag.getVida() == 1){
            ag.setVida(ag.getVida() - 1);
            return false;
        }else if(ripWagner && ag.getVida() != 1){
            return true;
        }

        if(ripPoco && ag.getMadeira() <= 0){
            return true;
        }else if(ripPoco){
            ag.setMadeira(getMadeira() - 1);
            return false;
        }
        return ripWumpus;
    }


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
