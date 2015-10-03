package pt.iscte.lei.pi.firujo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pt.iscte.lei.pi.firujo.gui.boardGUI;


public class gameGUI extends JComponent{
	//para desenhar a janela geral.
	private boardGUI board;
	
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
				//este e melhor que o clicked
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
		frame.setSize(500, 550);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2,
				dimension.height / 2 - frame.getHeight() / 2);
		frame.setLocation(200, 100);
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
		
	
	}

}
