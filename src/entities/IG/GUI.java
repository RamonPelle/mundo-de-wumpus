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
        gamepanel.setBackground(Color.white);
        gamepanel.setLayout(new GridLayout(Tabuleiro.TAMANHO + 1,Tabuleiro.TAMANHO + 1));

        //Add blocks
        blocks = new JPanel[Tabuleiro.getTamanho()][Tabuleiro.getTamanho()];
        for (int i = 0; i < Tabuleiro.getTamanho(); i++)
        {
            for (int j = 0; j < Tabuleiro.getTamanho(); j++)
           {
                blocks[i][j] = new JPanel();
                blocks[i][j].add(verificaEntidade(i,j));
                blocks[i][j].setBackground(Color.white);
                blocks[i][j].setPreferredSize(new Dimension(300,300));
                blocks[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                blocks[i][j].setLayout(new GridLayout(2,2));
                gamepanel.add(blocks[i][j]);
            }
        }
        frame.getContentPane().add(gamepanel);



        //Show window
        frame.setVisible(true);
    }

    private JLabel verificaEntidade(Integer i, Integer j){
        JLabel imageLabel = new JLabel(new ImageIcon("src/img/wagner.jpg"));
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Agente)){
            ImageIcon imageIcon = new ImageIcon("src/img/smiley.png");
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Poco)){
            ImageIcon imageIcon = new ImageIcon("src/img/poco.png");
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Wumpus)){
            ImageIcon imageIcon = new ImageIcon("src/img/wumpus.png");
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getEntidades().stream().anyMatch(e -> e instanceof Wagner)){
            ImageIcon imageIcon = new ImageIcon("src/img/wumpus.png");
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getOuro() == 1){
            ImageIcon imageIcon = new ImageIcon("src/img/ouro.png");
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        if(tabuleiro[i][j].getMadeira() == 1){
            ImageIcon imageIcon = new ImageIcon("src/img/madeira.jpg");
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(image));
        }
        return imageLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }



}