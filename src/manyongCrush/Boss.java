package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss extends JLabel {

	private ImageIcon[] boss = new ImageIcon[4];

	private ImageIcon[] bossAttack = new ImageIcon[19];

	private ImageIcon[] bossDie = new ImageIcon[9];

	private final int BOSS_WIDTH = 293;
	private final int BOSS_HEIGHT = 590;

	private final int X = 650;
	private final int Y = 55;

	private int hp;
	private int power;

	private int state;

	private int count;

	private boolean waiting;
	private boolean attacking;
	private boolean beAttacked;

	public Boss(int hp, int power) {
		this.hp = hp;
		this.power = power;
	}
	
	public void initData() {
		setIcon(boss[0]);
	}

	public void waiting() {
		new Thread(() -> {

			while (waiting) {

				for (int i = 0; i < boss.length; i++) {
					try {
						setIcon(boss[i]);
						Thread.sleep(130);
					} catch (InterruptedException e) {
						System.err.println("보스에서 웨이팅에서 에러남");
					}
				}
				count++;
				if (count % 10 == 0) {
					waiting = false;
					attack();
				}
			}
		}).start();
	}

	public void attack() {
		new Thread(() -> {

			if (!waiting && state == 0) {

				for (int i = 0; i < bossAttack.length; i++) {
					try {
						setIcon(bossAttack[i]);
						Thread.sleep(150);
					} catch (InterruptedException e) {
						System.err.println("보스 어택에서 에러");
					}
					if (bossAttack[i] == bossAttack[13]) {
						attacking = true;
					}
				}
				attacking = false;
				waiting = true;
				waiting();
			}
		}).start();
	}

	public void die() {
		state = 1;
		for (int i = 0; i < bossDie.length; i++) {
			setIcon(bossDie[i]);
		}
	}

	public void beAttacked(int damage) {
		new Thread(() -> {

			hp -= damage;
			
			beAttacked = true;
			if (hp <= 0) {
				die();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("보스 비어택드");
			}
			beAttacked = false;
		}).start();
	}

//	public void beAttacked() {
//		// 보스 좌표 가져 옴//
//
//		if (Math.abs((x + skillWidth) - bossX) < 30
//				&& Math.abs((y + (skillHeight / 2)) - bossY + (bossHeight / 2)) < 295) {
//			boss.setHp(boss.getHp() - power);
//		}
//
//	}
}
