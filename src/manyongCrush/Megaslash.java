package manyongCrush;

import javax.swing.ImageIcon;

public class MegaSlash extends SkillImpact {

	public MegaSlash(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		initData();

	}

	public void initData() {

		setSkillImageL(new ImageIcon("images/swordSkillSwingL.png"));
		setSkillImageR(new ImageIcon("images/swordSkillSwingR.png"));

	}

}