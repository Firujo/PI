package pt.iscte.lei.pi.firujo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.iscte.lei.pi.firujo.gui.boardGUI;
import pt.iscte.lei.pi.firujo.scores.HighScoreManager;
import pt.iscte.lei.pi.firujo.scores.Score;


public class gameGUI extends JComponent{
	//para desenhar a janela geral.
	private boardGUI board;
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JPanel boardPanel = new JPanel();
	private JPanel informationPanel = new JPanel();
	private JPanel myInfoPanel = new JPanel();
	private JPanel topScoresPanel = new JPanel();
	
	private JFrame frame= new JFrame("Pest Control");

	public gameGUI( boardGUI b) {
		super();
		this.board = b;
		gui();
		b.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//TODO
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});
		
	}
	
	public void init(){
		frame.setVisible(true);
	}
	
	public void gui(){
		frame.setLayout(new BorderLayout());//layout geral
		frame.setSize(800, 600);
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2,
				dimension.height / 2 - frame.getHeight() / 2);
		frame.requestFocusInWindow();
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(false);
		
		
		frame.add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new BorderLayout()); //Se nao metesse isto, ele nao ia desenhar nada
		//pq por definicao tem um flow que reduz o tamanho e nao mostraria nada
		
		boardPanel.add(board);
		frame.add(informationPanel, BorderLayout.SOUTH);
		
		boardPanel.setBackground(Color.BLACK);
		informationPanel.setBackground(Color.GRAY);
		
		informationPanel.setLayout(new GridLayout(1,2));
		informationPanel.add(myInfoPanel);
		informationPanel.add(topScoresPanel);

		// - TAL como se fez a boardGUI, podera ser necessario criar uma classe para 
		//trabalhar estas partes de baixo, ou entao como sao menos relevantes faz-se directamente aqui
		//discutir este ponto.-
		
		myInfoPanel.setLayout(new GridLayout(3,1));
		myInfoPanel.add(new JButton("Teste: Health Points"));
		myInfoPanel.add(new JButton("Teste: Points"));
		myInfoPanel.add(new JButton("Teste: time"));
		
		//Inserir no topScoresPanel as cenas do top scores.
		HighScoreManager highsm = new HighScoreManager();
		topScoresPanel.setLayout(new BorderLayout());
		
		JPanel centeredPanel=new JPanel();
		topScoresPanel.add(new JLabel("                                      "), BorderLayout.WEST);
		topScoresPanel.add(centeredPanel, BorderLayout.CENTER);
		
		centeredPanel.setLayout(new GridLayout(4,1));
		JLabel hsmTitleLabel= new JLabel(" Top High Scores");
		ArrayList<Score> aux= highsm.getScores();
		JLabel firstPlace = new JLabel(aux.get(0).toString());
		JLabel secondPlace=new JLabel(aux.get(1).toString());
		JLabel thirdPlace=new JLabel(aux.get(2).toString());
		
		centeredPanel.add(hsmTitleLabel);
		centeredPanel.add(firstPlace);
		centeredPanel.add(secondPlace);
		centeredPanel.add(thirdPlace);
		
		//explicacao a apagar: Tive de usar o centerPanel pq se usasse so o topscoresPanel em grid
		//ficava tudo mt a esquerda, assim e com a aldrabice da Label so com espaço no west ele ja estica.
		//isto foi aldrabado, mas se nao metesse essa label a esquerda, o center esticava e ocupava td

		
	}

}
