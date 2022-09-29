package manyongCrush;

import javax.swing.ImageIcon;

public class Slash extends SkillImpact {

	public Slash(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		initData();

	}

	public void initData() {

		super.setSkillImageL(new ImageIcon("images/swordSwingL.png"));
		super.setSkillImageR(new ImageIcon("images/swordSwingL.png"));

	}

}