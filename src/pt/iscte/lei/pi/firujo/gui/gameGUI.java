package pt.iscte.lei.pi.firujo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;



import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pt.iscte.lei.pi.firujo.gui.boardGUI;


public class gameGUI extends JComponent{
	//para desenhar a janela geral.
	private boardGUI board;
	
	private JPanel painelDoTabuleiro = new JPanel();
	private JPanel painelDasInformacoes = new JPanel();
	private JPanel painelDoTimer = new JPanel();
	private JPanel painelDosPontos = new JPanel();
	private JPanel painelDaVida = new JPanel();
	
	private JFrame frame= new JFrame("The Hunter");

	public gameGUI( boardGUI b) {
		super();
		this.board = b;
		gui();
		
//		frame.getContentPane().add(board); //com isto desenha, so com o panelTabul.add(board) nao
	}
	
	public void init(){
		frame.setVisible(true);
	}
	
	public void gui(){
		frame.setLayout(new BorderLayout());//layout geral
		frame.setSize(500, 550);
		frame.setLocation(200, 100);
		frame.requestFocusInWindow();
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(false);
		
		
		frame.add(painelDoTabuleiro, BorderLayout.CENTER);
		painelDoTabuleiro.setLayout(new BorderLayout()); //Se nao metesse isto, ele nao ia desenhar
		painelDoTabuleiro.add(board);
		frame.add(painelDasInformacoes, BorderLayout.SOUTH);
		
//		painelDoTabuleiro.setBackground(Color.green);
//		painelDasInformacoes.setBackground(Color.GRAY);
		
		painelDasInformacoes.setLayout(new GridLayout(1,3));
		painelDasInformacoes.add(painelDoTimer);
		painelDasInformacoes.add(painelDosPontos);
		painelDasInformacoes.add(painelDaVida);
		
		//teste - adicionei estes buttons so para testar se tava no sitio certo
		//dps tiram-se estes butoes e mete-se as info certas.
		// - TAL como se fez a boardGUI, podera ser necessario criar uma classe para 
		//trabalhar estas partes de baixo, ou entao como sao menos relevantes faz-se directamente aqui
		//discutir este ponto.-
		
		painelDoTimer.add(new JButton("Sou o tempo"));
		painelDosPontos.add(new JButton ("Sou pontos"));
		painelDaVida.add(new JButton ("Sou a vida"));
	
	}

}
