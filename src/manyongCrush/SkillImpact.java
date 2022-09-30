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

	protected int leftX;
	protected int rightX;

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

	private boolean checkBoss;

	protected ImageIcon[] skillImpactImgL;
	protected ImageIcon[] skillImpactImgR;

	protected ImageIcon[] skillImageL = new ImageIcon[16];
	protected ImageIcon[] skillImageR = new ImageIcon[16];

	public SkillImpact(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		this.leftX = x - 150;
		this.rightX = x + 150;
		this.y += y - 50;
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
	}

	public void skillsLeftFly() {

		new Thread(() -> {

			for (int i = 0; i < 10; i++) {
				try {
					setIcon(skillImageL[i]);
					setLocation(leftX, y);
					checkBoss();
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (true) {
				while (!checkBoss) {
					int changeMotion = 9;
					for (changeMotion = 9; changeMotion > 4; changeMotion--) {
						try {
							setIcon(skillImageL[changeMotion]);
							leftX--;
							setLocation(leftX, y);
							checkBoss();
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (changeMotion = 5; changeMotion < 10; changeMotion++) {
						try {
							setIcon(skillImageL[changeMotion]);
							leftX--;
							setLocation(leftX, y);
							checkBoss();
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				for (int i = 9; i < 17; i++) {
					setIcon(skillImageL[i]);
				}
			}
		}).start();
	}

	public void skillsRightFly() {

		new Thread(() -> {

			for (int i = 0; i < 10; i++) {
				try {
					setIcon(skillImageR[i]);
					setLocation(rightX, y);
					checkBoss();
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (true) {
				while (!checkBoss) {
					int changeMotion = 9;
					for (changeMotion = 9; changeMotion > 4; changeMotion--) {
						try {
							setIcon(skillImageR[changeMotion]);
							rightX++;
							setLocation(rightX, y);
							checkBoss();
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (changeMotion = 5; changeMotion < 10; changeMotion++) {
						try {
							setIcon(skillImageR[changeMotion]);
							rightX++;
							setLocation(rightX, y);
							checkBoss();
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				for (int i = 9; i < 17; i++) {
					setIcon(skillImageR[i]);
				}
				setLocation(2000, 0);
			}
		}).start();
	}

	public void checkBoss() {

		new Thread(() -> {

			if (Math.abs((rightX + skillWidth + 30) - bossX) < 1
					&& Math.abs(((y + skillHeight) / 2) - (bossY + bossHeight) / 2) < 295) {
				checkBoss = true;
				System.out.println("여기 가동 되나");
				groundContext.boss.beAttacked(power);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			checkBoss = false;
		}).start();
	}
}