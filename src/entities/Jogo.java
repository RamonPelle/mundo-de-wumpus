//package entities;
//
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Jogo {
//    Scanner sc = new Scanner(System.in);
//    Random r = new Random();
//    private Tabuleiro jogo;
//    List<Entidade> entities;
//    List<Entidade> entitiesOnGame;
//
//    public Jogo(){
//        this.jogo = new Tabuleiro();
//        this.entities = jogo.getEntidades();
//        adicionaPersonagens();
//
//    }
//    private void adicionaPersonagens(){
//        List<Entidade> entities = jogo.getEntidades();
//        Wagner wagner = (Wagner) entities.get(0);
//        Wumpus wumpus = (Wumpus) entities.get(1);
//        Agente agente = (Agente) entities.get(4);
//        this.entitiesOnGame.add(wagner);
//        this.entitiesOnGame.add(wumpus);
//        this.entitiesOnGame.add(agente);
//    }
//    //teste do Andar()
//    public void vezJogador(){
//        System.out.println("Qual direcao voce quer andar? [0-3]");
//        Entidade ag = this.entitiesOnGame.get(2);
//        if (ag instanceof Agente) {
//            ((Agente) ag).andar(sc.nextInt(3));
//        } else {
//            System.out.println("A entidade não é um Agente.");
//        }
//    }
//    public void vezMonstros(){
//        Entidade wg = this.entitiesOnGame.get(0);
//        Entidade wum = this.entitiesOnGame.get(1);
//        if (wg instanceof Wagner) {
//            ((Wagner) wg).andar(sc.nextInt(4));
//        } else {
//            System.out.println("A entidade não é um Wagner.");
//        }
//        if (wum instanceof Wumpus) {
//            ((Wumpus) wg).andar(sc.nextInt(8));
//        } else {
//            System.out.println("A entidade não é um Wagner.");
//        }
////        wagner.andar(r.nextInt(8));
////        wumpus.andar(r.nextInt(4));
//    }
//
//    public static void fim(String msg){
//        System.out.println("Voce morreu por conta de: " + msg);
//        System.exit(0);
//    }
//
//    public Boolean verificaVitoria(Agente agente){
//        return agente.getOuro() == 1 && (agente.getPosX() == 0 && agente.getPosY() == 0);
//    }
//
//    public Boolean verificaFim(){
//        List<Entidade> entidades = Tabuleiro.getCasa(entitiesOnGame.get(2)).getEntidades();
//        if(entidades.contains(entitiesOnGame.get(0)) ||entidades.contains(entitiesOnGame.get(1))){
//            return true;
//        }
//        return false;
//    }
//
//    public void visaoAgente(){
//        this.jogo.printVisaoAgente(this.jogo.getTabuleiro());
//    }
//
//    public void visaoDebug(){
//        this.jogo.printDebug(this.jogo.getTabuleiro());
//    }
//    public Entidade getEntidade(Integer pos) {
//        return this.entitiesOnGame.get(pos);
//    }
//}
