package pt.iscte.lei.pi.firujo.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import pt.iscte.lei.pi.firujo.bughierarchy.Rat;

public class MouseGameListener extends Observable implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint());

		checkIfHitAndRemove(e);

	}

	private void checkIfHitAndRemove(MouseEvent e) {

		/*
		 * precisa de MUITA optimizacao aqui + limpar codigo
		 * 
		 * o ideal eh pensar no raio (circulo) do bixo e aplicar o pitagoras
		 * entre o click e o centro do circulo.
		 * 
		 * se essa hipotenusa < raio do bixo : sucesso else fail
		 * 
		 * 
		 */
		for (Rat rat : Board.getInstance().getMyRats()) {
			if (e.getX() - rat.getSpawnPoint().getX()-25 < 25 && e.getY() - rat.getSpawnPoint().getY()-25 < 25
					&& e.getX() - rat.getSpawnPoint().getX()-25 > -25 && e.getY() - rat.getSpawnPoint().getY()-25 > -25) {
				Board.getInstance().getMyRats().remove(rat);
				setChanged();
				notifyObservers();
				break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
