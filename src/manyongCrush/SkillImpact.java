package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SkillImpact extends JLabel {

	private int x;
	private int y;
	private int power;
	private int skillPower;
	private int skillCount;

	private int skillWidth;
	private int skillHeight;

	private int state;

	private int bossX;
	private int bossY;

	private ImageIcon skillImpactImgL;
	private ImageIcon skillImpactImgR;

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
