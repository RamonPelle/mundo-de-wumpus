
import entities.Agente;
import entities.Tabuleiro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro jogo = null;
        while(true){
            System.out.println("Bem vindo!! Escolha uma opção:");
            System.out.println("1: Jogar");
            System.out.println("2: Sair");
            Integer op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Quer debugar? [1: Sim | 2: Não]");
                    op = sc.nextInt();
                    System.out.println("O jogo vai começar!");
                    jogo = new Tabuleiro();
                    Agente agente = (Agente) jogo.getEntidades().get(4);
                    do{
                        agente.printDadosAgente();
                        if(op == 1){
                            jogo.printDebug();
                        }else{
                            jogo.printVisaoAgente();
                        }

                        System.out.println("Qual direção você quer Andar? [0-3]\n0: Baixo\n1: Cima\n2: Direita\n3: Esquerda");
                        System.out.println("4: Lanterna");
                        Integer opcao = sc.nextInt();
                        if(opcao == 4){
                            agente.usarLanterna();
                            //lanterna
                        }else if(opcao < 4 && opcao >=0){
                            jogo.vezMonstros();
                            agente.andar(opcao);
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

