
import entities.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        Tabuleiro jogo = null;
        while(true){
            System.out.println("Bem vindo!! Escolha uma opção:");
            System.out.println("1: Jogar");
            System.out.println("2: Sair");
            Integer opcaoMenu = sc.nextInt();
            Integer opcaoMenu2;
            Integer opcaoAndar;
            switch(opcaoMenu){
                case 1:
                    System.out.println("Quer debugar? [1: Sim | 2: Não]");
                    opcaoMenu = sc.nextInt();
                    System.out.println("O jogo vai começar!");
                    jogo = new Tabuleiro();
                    Agente agente = (Agente) jogo.getEntidades().get(4);
                    Wagner wg = (Wagner) jogo.getEntidades().get(0);
                    Wumpus wum = (Wumpus) jogo.getEntidades().get(1);
                    do {
                        System.out.println("1: Andar\n2: Lanterna\n3: Mochila");
                        opcaoMenu2 = sc.nextInt();

                        switch (opcaoMenu2) {
                            case 1:

                                if (opcaoMenu == 1) {
                                    jogo.printDebug();
                                } else {
                                    jogo.printVisaoAgente();
                                }
                                System.out.println("Qual direção você quer Andar? [0-3]\n0: Baixo\n1: Cima\n2: Direita\n3: Esquerda");
                                opcaoAndar = sc.nextInt();
                                if (opcaoAndar < 4 && opcaoAndar >= 0) {
                                    wum.andar(random.nextInt(4));
                                    wg.andar(random.nextInt(8));
                                    agente.andar(opcaoAndar);
                                }
                                break;
                            case 2:
                                if (opcaoMenu == 1) {
                                    jogo.printDebug();
                                } else {
                                    jogo.printVisaoAgente();
                                }
                                agente.usarLanterna();
                                break;
                            case 3:
                                agente.printDadosAgente();
                                break;
                        }
                    }
                    while(!jogo.verificaMorte((Agente)jogo.getEntidades().get(4))
                            && !jogo.verificaVitoria((Agente) jogo.getEntidades().get(4)));
                    jogo.fim((Agente) jogo.getEntidades().get(4));
                    break;
                case 2:
                    System.out.println("Encerrando...");
                    System.exit(0);
                default:
                    System.out.println("Opção inexistente, tente novamente.");
                    break;
            }
        }




    }
}

