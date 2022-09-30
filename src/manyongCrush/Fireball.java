package manyongCrush;

import javax.swing.ImageIcon;

public class Fireball extends SkillImpact {

	public Fireball(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		initData();
		setInitLayout();
	}

	public void initData() {

		skillImageR[0] = new ImageIcon("images/fireBallR.png");
	}
}