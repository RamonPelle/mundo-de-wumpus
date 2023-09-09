package entities;

import java.util.Scanner;

public class Agente extends Entidade implements Andar{
    Scanner sc = new Scanner(System.in);
    private Integer madeira = 2;
    private Integer arco = 1;
    private Integer flecha = 0;
    private Integer lanterna = 1;
    private Integer vida = 1;
    private Integer ouro = 0;

    public Agente() {
        this.setPosX(0);
        this.setPosY(0);
        Tabuleiro.setCasa(this.getPosX(),this.getPosY(),this);
        Tabuleiro.getCasa(this).setVisto(true);
    }

    public void andar(Integer direcao){
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
                Casa atual = Tabuleiro.getCasa(this);
                atual.removeEntidade(this);
                this.setPosX(newX);
                this.setPosY(newY);
                Tabuleiro.setCasa(newX, newY, this);
            }
        }
        Tabuleiro.getCasa(this).setVisto(true);
        temOuro();
        temFedor();
    }

    public void usarLanterna(){
        if(lanterna >= 0 ){
            System.out.println("Qual direção você deseja iluminar? [0-3]\n0: Baixo\n1: Cima\n2: Direita\n3: Esquerda");
            Tabuleiro.iluminarCasas(getPosX(), getPosY(), sc.nextInt());
            setLanterna(getLanterna()-1);
        }else{
            System.out.println("Lanterna sem carga, não conte mais com esse recurso.");
        }
    }
    public void temOuro(){
        if(Tabuleiro.getCasa(this).getOuro() != 0){
            setOuro(1);
            Tabuleiro.getCasa(this).setOuro(0);
        }
    }

    public void temFedor(){
        if(getMadeira() > 0 || getFlecha() > 0){
            if(Tabuleiro.getCasa(this).getFedor() != 0){
                System.out.println("Você sente um cheiro estranho... quer usar uma flecha para atirar? [1: Sim | 2: Não]");
                Integer opcao = sc.nextInt();
                if(opcao == 1){
                    if(getFlecha() == 0){
                        setMadeira(getMadeira() - 1);
                        System.out.println("Você fabricou uma flecha, e isso lhe custou 01 madeira!");
                    }else{
                        setFlecha(getFlecha() - 1);
                    }
                }
                System.out.println("Qual direção você quer atirar? [0-3]\n0: Baixo\n1: Cima\n2: Direita\n3: Esquerda");
                Integer posX = getPosX();
                Integer posY = getPosY();
                Integer[][] adjPositions = {
                        {posX + 1, posY},
                        {posX - 1, posY},
                        {posX, posY + 1},
                        {posX, posY - 1}
                };
                opcao = sc.nextInt();

                if (opcao >= 0 && opcao <= 3) {
                    Integer newX = adjPositions[opcao][0];
                    Integer newY = adjPositions[opcao][1];

                    if (estaNoLimite(newX, newY)) {
                        this.setPosX(newX);
                        this.setPosY(newY);
                        Casa atual = Tabuleiro.getCasa(this);

                        if(Tabuleiro.getCasa(this).getEntidades().stream().anyMatch(e -> e instanceof Monstro)){
                            System.out.println("Você matou o monstro!");
                            atual.getEntidades().clear();
                        }else{
                            System.out.println("Não há monstros nessa casa.");
                        }
                        this.setPosX(posX);
                        this.setPosY(posY);
                    }
                }
            }
        }
    }

    public void printDadosAgente(){

            StringBuilder sb = new StringBuilder("Mochila do Agente:\n");

            if (madeira > 0) {
                sb.append("  - Madeira: ").append(madeira).append(" unidades\n");
            }

            if (lanterna > 0) {
                sb.append("  - Lanterna: ").append(lanterna).append(" unidades\n");
            }

            sb.append("  - Vida: ").append(vida).append("\n");
            sb.append("  - Ouro: ").append(ouro).append(" moedas\n");

            System.out.println(sb);
    }
    public Integer getMadeira() {
        return madeira;
    }

    public void setMadeira(Integer madeira) {
        this.madeira = madeira;
    }

    public Integer getArco() {
        return arco;
    }

    public void setArco(Integer arco) {
        this.arco = arco;
    }

    public Integer getFlecha() {
        return flecha;
    }

    public void setFlecha(Integer flecha) {
        this.flecha = flecha;
    }

    public Integer getLanterna() {
        return lanterna;
    }

    public void setLanterna(Integer lanterna) {
        this.lanterna = lanterna;
    }

    public Integer getOuro() {
        return ouro;
    }

    public void setOuro(Integer ouro) {
        this.ouro = ouro;
    }


    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

