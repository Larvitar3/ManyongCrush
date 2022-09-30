package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillImpact extends JLabel {

	protected Ground groundContext;
	protected Player player;

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

	protected int bossWidt;
	protected int bossHeight;

	protected ImageIcon skillImpactImgL;
	protected ImageIcon skillImpactImgR;

	protected ImageIcon skillImageL;
	protected ImageIcon skillImageR;

	public SkillImpact(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		this.x = x;
		this.y = y;
		this.power = power;
		this.skillPower = skillPower;
		this.skillWidth = skillWidth;
		this.skillHeight = skillHeight;
		this.player = player;
		this.groundContext = groundContext;

		bossX = groundContext.boss.getX();
		bossY = groundContext.boss.getY();

		bossWidt = groundContext.boss.getWidth();
		bossHeight = groundContext.boss.getHeight();

		groundContext.add(this);
	}

	public void setInitLayout() {
		setSize(skillWidth, skillHeight);
		setLocation(x, y);
	}

	public void skillsLeftFly() {

		new Thread(() -> {

			// 만약 플레이어가 왼쪽을 보고 있다면?
			while (true) {
				try {
					setIcon(skillImageL);
					x--;
					setLocation(x, y);
					checkBoss();
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void skillsRightFly() {
		new Thread(() -> {

			while (true) {

				try {
					setIcon(skillImageR);
					x++;
					setLocation(x, y);
					checkBoss();
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void checkBoss() {

		new Thread(() -> {

			if (Math.abs((x + skillWidth) - bossX) < 1
					&& Math.abs(((y + skillHeight) / 2) - (bossY + bossHeight) / 2) < 295) {
				groundContext.boss.beAttacked(power);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}