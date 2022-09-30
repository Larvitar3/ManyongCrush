package manyongCrush;

import javax.swing.ImageIcon;

public class MegaSlash extends SkillImpact {

	private String[] skillLImage = new String[10];
	private String[] skillRImage = new String[10];

	public MegaSlash(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		super(groundContext, player, x, y, power, skillPower, skillWidth, skillHeight);

		initData();

	}

	public void initData() {

		for (int i = 0; i < skillImageL.length; i++) {
			skillImageL[i] = new ImageIcon(skillLImage[i]);
			skillImageR[i] = new ImageIcon(skillRImage[i]);
		}
	}

}