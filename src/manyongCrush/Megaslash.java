package manyongCrush;

import javax.swing.ImageIcon;

public class Megaslash extends SkillImpact {

	public Megaslash(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		initData();

	}

	public void initData() {

		setSkillImageL(new ImageIcon("images/swordSkillSwingL.png"));
		setSkillImageR(new ImageIcon("images/swordSkillSwingR.png"));

	}

}