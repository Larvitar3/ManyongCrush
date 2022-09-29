package manyongCrush;

import javax.swing.ImageIcon;

public class ChainFireball extends SkillImpact {

	public ChainFireball(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		initData();

	}

	public void initData() {

		super.setSkillImageL(new ImageIcon("images/fireBallL.png"));
		super.setSkillImageR(new ImageIcon("images/fireBallR.png"));

	}

}