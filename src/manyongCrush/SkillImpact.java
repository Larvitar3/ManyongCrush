package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillImpact extends JLabel {

	private Boss boss;
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

	private ImageIcon skillImageL;
	private ImageIcon skillImageR;

	public SkillImpact(Player player, int x, int y, int power, int skillPower, int skillWidth, int skillHeight) {
		this.x = x;
		this.y = y;
		this.power = power;
		this.skillPower = skillPower;
		this.skillWidth = skillWidth;
		this.skillHeight = skillHeight;
		this.player = player;

		bossX = boss.getX();
		bossY = boss.getY();

		bossWidt = boss.getWidth();
		bossHeight = boss.getHeight();
	}

	public void skillsFly() {

		new Thread(() -> {

			// 만약 플레이어가 왼쪽을 보고 있다면?
			if (player.isLeft()) {
				setIcon(skillImageL);
				x--;
				setLocation(x, y);
				checkBoss();
			} else if (player.isRight()) {
				// 만약 플레이어가 오른쪽을 보고 있다면?
				setIcon(skillImageR);
				x++;
				setLocation(x, y);
				checkBoss();
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