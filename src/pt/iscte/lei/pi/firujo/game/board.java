package pt.iscte.lei.pi.firujo.game;

import pt.iscte.lei.pi.firujo.gui.boardGUI;

public class board {
	//aqui tera as informacoes todas de um tabuleiro... conjunto de celulas,etc
	public int linhas;
	public int colunas;
	public cell tabuleiro[][];
	
	public board(int linhas, int colunas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		tabuleiro=new cell[linhas][colunas];
		for(int i=0;i<linhas;i++){
			for(int j=0;j<colunas;j++){
					cell c=new cell(i*boardGUI.cell_width,j*boardGUI.cell_height);
					tabuleiro[i][j]=c;
			}
		}
	}
	
	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
}
