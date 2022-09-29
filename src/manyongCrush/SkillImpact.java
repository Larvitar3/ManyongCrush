package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillImpact extends JLabel {

	Ground groundContext;

	private Player player;

	private int x;
	private int y;

	private int bossX;
	private int bossY;

	private int power;
	private int skillPower;

	private int skillWidth;
	private int skillHeight;

	private int bossWidt;
	private int bossHeight;

	private int skillCount;

	private int state;

	protected ImageIcon skillImageL;
	protected ImageIcon skillImageR;

	public SkillImpact(Ground groundContext, Player player, int x, int y, int power, int skillPower, int skillWidth,
			int skillHeight) {
		this.groundContext = groundContext;
		this.x = x;
		this.y = y;
		this.power = power;
		this.skillPower = skillPower;
		this.skillWidth = skillWidth;
		this.skillHeight = skillHeight;
		this.player = player;

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
//				System.out.println("asdfiojlk");
				try {
					setIcon(skillImageL);
					x--;
					setLocation(x, y);
					checkBoss();
					Thread.sleep(1);
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
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void checkBoss() {

		if (Math.abs((x + skillWidth) - bossX) < 30
				&& Math.abs((y + (skillHeight / 2)) - bossY + (bossHeight / 2)) < 295) {
			System.out.println("감지 되었어요 ~~");
		}
	}

}