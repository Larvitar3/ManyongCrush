package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss extends JLabel {

	Wrath wrath;

	protected ImageIcon[] boss = new ImageIcon[4];

	protected ImageIcon[] bossAttack = new ImageIcon[19];

	protected ImageIcon[] bossDie = new ImageIcon[10];

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
		wrath = new Wrath(this);

		setInitLayout();
	}

	public void setInitLayout() {
		setIcon(boss[0]);
		setSize(BOSS_WIDTH, BOSS_HEIGHT);
		setLocation(X, Y);

	}

	public void waiting() {
		new Thread(() -> {
			waiting = true;
			while (waiting && state == 0) {

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
			System.out.println(hp);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void beAttacked(int damage) {
		
		System.out.println("이게 1초마다 나와야함");

		if (state == 0) {
			hp -= damage;
			System.out.println(hp);
			if (hp <= 0) {
				hp = 0;
				die();
			}
		}
	}
}
