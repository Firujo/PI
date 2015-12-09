package pt.iscte.lei.pi.firujo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.iscte.lei.pi.firujo.cronometro.Cronometro;
import pt.iscte.lei.pi.firujo.game.Board;
import pt.iscte.lei.pi.firujo.game.GameThread;
import pt.iscte.lei.pi.firujo.game.MouseGameListener;
import pt.iscte.lei.pi.firujo.gui.boardGUI;
import pt.iscte.lei.pi.firujo.scores.HighScoreManager;
import pt.iscte.lei.pi.firujo.scores.Score;

public class gameGUI extends JComponent {
	// para desenhar a janela geral.
	private boardGUI board;
	private MouseGameListener msl;
	
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	public static JPanel boardPanel = new JPanel();
	private JPanel informationPanel = new JPanel();
	private JPanel myInfoPanel = new JPanel();
	private JPanel hpPanel = new JPanel();
	public static HpBar hpBar = new HpBar();
	private JPanel topScoresPanel = new JPanel();
	public static Cronometro cronometro;
//	private JPanel cronoPanel = new JPanel();
	private JLabel cronoLabel;
	private static int points = 0;
	public static JLabel JLpoints = new JLabel();
	
	
	private JFrame frame = new JFrame("Pest Control");

	public gameGUI(boardGUI b) {
		super();
		this.board = b;
		gui();

		gameThreadStarter();

		msl = new MouseGameListener();
		msl.addObserver(board);
		b.addMouseListener(msl);

	}

	private void gameThreadStarter() {
		GameThread gameThread = new GameThread();
		gameThread.addObserver(board);
		Thread thread = new Thread(gameThread);
		thread.start();
	}
	
	public void init() {
		frame.setVisible(true);
		for (int i = 0; i < 9; i++) {

		}

	}
	
	public static void addPoints(int n){
		points = points + n;
		JLpoints.setText("Points:  " + points);
		JLpoints.repaint();
	}

	public void gui() {
		frame.setLayout(new BorderLayout());// layout geral
		frame.setSize(800, 600);
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);
		frame.requestFocusInWindow();
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(false);

		frame.add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new BorderLayout());

		boardPanel.add(board);
		frame.add(informationPanel, BorderLayout.SOUTH);

		boardPanel.setBackground(Color.WHITE);
		informationPanel.setBackground(Color.GRAY);

		informationPanel.setLayout(new GridLayout(1, 2));
		informationPanel.add(myInfoPanel);
		informationPanel.add(topScoresPanel);
		
		myInfoPanel.setLayout(new GridLayout(3, 1));
		
		//myInfoPanel.add(new JButton("Teste: Health Points"));
		hpPanel.setLayout(new BorderLayout());
		hpPanel.add(hpBar, BorderLayout.CENTER);
		hpPanel.add(new JLabel("HP: "), BorderLayout.WEST);
		myInfoPanel.add(hpPanel);
		
		//myInfoPanel.add(new JButton("Teste: Points"));
		JLpoints.setText("Points:  " + points);
		myInfoPanel.add(JLpoints);
		
//		myInfoPanel.add(new JButton("Teste: time"));
		
		cronoLabel= new JLabel("00:00");
		myInfoPanel.add(cronoLabel);
		cronometro=new Cronometro(cronoLabel);
		cronometro.run();

		// Inserir no topScoresPanel as cenas do top scores.
		HighScoreManager highsm = new HighScoreManager();
		topScoresPanel.setLayout(new BorderLayout());

		JPanel centeredPanel = new JPanel();
		topScoresPanel.add(new JLabel("                                      "), BorderLayout.WEST);
		topScoresPanel.add(centeredPanel, BorderLayout.CENTER);

		centeredPanel.setLayout(new GridLayout(4, 1));
		JLabel hsmTitleLabel = new JLabel(" Top High Scores");
		ArrayList<Score> aux = highsm.getScores();
		JLabel firstPlace = new JLabel("A - 3");
		JLabel secondPlace = new JLabel("B - 2");
		JLabel thirdPlace = new JLabel("C - 1");
		/*
		 * JLabel firstPlace = new JLabel(aux.get(0).toString()); JLabel
		 * secondPlace=new JLabel(aux.get(1).toString()); JLabel thirdPlace=new
		 * JLabel(aux.get(2).toString());
		 */

		centeredPanel.add(hsmTitleLabel);
		centeredPanel.add(firstPlace);
		centeredPanel.add(secondPlace);
		centeredPanel.add(thirdPlace);


	}

}
