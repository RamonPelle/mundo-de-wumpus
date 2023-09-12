package entities.IG;

import entities.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class GUI implements ActionListener
{
    private JFrame frame;
    private JPanel gamepanel;
    private JPanel[][] blocks;
    private Casa[][] tabuleiro;

    public GUI(Casa[][] tabuleiro)
    {
        this.tabuleiro = tabuleiro;
        createWindow();
    }



    private void createWindow()
    {
        frame = new JFrame("Wumpus World");
        frame.setSize(600, 600);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        gamepanel = new JPanel();
        gamepanel.setPreferredSize(new Dimension(300,300));
        gamepanel.setLayout(new GridLayout(Tabuleiro.TAMANHO + 1,Tabuleiro.TAMANHO + 1));

        //Add blocks
        blocks = new JPanel[Tabuleiro.getTamanho()][Tabuleiro.getTamanho()];
        for (int i = 0; i < Tabuleiro.getTamanho(); i++)
        {
            for (int j = 0; j < Tabuleiro.getTamanho(); j++)
           {
                blocks[i][j] = new JPanel();
                blocks[i][j].setLayout(new GridLayout(1,1));
                blocks[i][j].add(verificaEntidade(i,j));
                blocks[i][j].setBackground(Color.white);
                blocks[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                gamepanel.add(blocks[i][j]);
            }
        }

        JPanel botaoPanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("src/img/mochila.jpg");
        Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        botaoPanel.add(imageLabel);
        botaoPanel.setPreferredSize(new Dimension(60, 60));
        botaoPanel.setBackground(Color.white);


        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String dados = "";

                for(int i = 0; i < Tabuleiro.TAMANHO; i++){
                    for(int j = 0; j < Tabuleiro.TAMANHO; j++) {
                        for (Entidade entidade : tabuleiro[i][j].getEntidades()) {
                            if(entidade instanceof Agente){
                                dados = ((Agente) entidade).dadosAgente();
                            }
                        }
                    }
                }

                JOptionPane.showMessageDialog(frame, dados);
            }
        });

        frame.getContentPane().add(gamepanel);
        frame.getContentPane().add(botaoPanel);


        //Show window
        frame.setVisible(true);
    }

    private JLabel verificaEntidade(Integer i, Integer j){
        JLabel imageLabel = new JLabel(new ImageIcon(""));
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Agente)){
            ImageIcon imageIcon = new ImageIcon("src/img/agent.png");
            Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Poco)){
            ImageIcon imageIcon = new ImageIcon("src/img/poco.png");
            Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Wumpus)){
            ImageIcon imageIcon = new ImageIcon("src/img/wumpus.png");
            Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Wagner)){
            ImageIcon imageIcon = new ImageIcon("src/img/wagner.png");
            Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getOuro() == 1){
            ImageIcon imageIcon = new ImageIcon("src/img/ouro.png");
            Image image = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getMadeira() == 1){
            ImageIcon imageIcon = new ImageIcon("src/img/wood.png");
            Image image = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);;
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getBrisa() == 1){
            ImageIcon imageIcon = new ImageIcon("src/img/brisa.jpg");
            Image image = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);;
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getFedor() == 1){
            ImageIcon imageIcon = new ImageIcon("src/img/fedor.jpg");
            Image image = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);;
            imageLabel = new JLabel(new ImageIcon(image));
        }
        return imageLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }



}