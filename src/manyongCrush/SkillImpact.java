package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SkillImpact extends JLabel {

	protected int x;
	protected int y;
	protected int power;
	protected int skillPower;
	protected int skillCount;

	protected int skillWidth;
	protected int skillHeight;

	protected int state;

	protected int bossX;
	protected int bossY;

	protected ImageIcon skillImpactImgL;
	protected ImageIcon skillImpactImgR;

	public SkillImpact(int x, int y, int power, int skillPower, int skillWidth, int skillHeight,
			ImageIcon skillImpactImgL, ImageIcon skillImpactImgR) {
		this.x = x;
		this.y = y;
		this.power = power;
		this.skillPower = skillPower;
		this.skillWidth = skillWidth;
		this.skillHeight = skillHeight;
		this.skillImpactImgL = skillImpactImgL;
		this.skillImpactImgR = skillImpactImgR;

	}

	public void bossBeAttacked() {
		// 보스 좌표 가져 옴
	}

}
