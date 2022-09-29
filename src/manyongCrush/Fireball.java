package manyongCrush;

import javax.swing.ImageIcon;

public class Fireball extends SkillImpact {

	public Fireball(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		System.out.println("fire");
		initData();
		setInitLayout();
	}

	public void initData() {

		try {
			super.skillImageL = new ImageIcon("images/fireBallL.png");
			super.skillImageR = new ImageIcon("images/fireBallR.png");
			System.err.println("흠흠");
		} catch (Exception e) {
		}

	}
}