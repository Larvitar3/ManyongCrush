package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Wizard extends Player {


	public Wizard(String name, int hp, int power, int x, int y, int playerWidth, int playerHeight) {
		super(name, hp, power, x, y, playerWidth, playerHeight );

	}


	@Override
	public void fireballAttack() {

		new Fireball(NEXT, ERROR, ALLBITS, ABORT, WIDTH, HEIGHT, getPlayerDieMotionImg(), getPlayerDieMotionImg());

		super.fireballAttack();
	}

	@Override
	public void chainFireballAttack() {
		super.chainFireballAttack();
	}

}
