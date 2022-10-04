package boss;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frames.GameState;
import frames.Ground;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss extends JLabel {

	Ground groundContext;

	protected ImageIcon[] boss = new ImageIcon[4];

	protected ImageIcon[] bossAttack = new ImageIcon[19];

	protected ImageIcon[] bossDie = new ImageIcon[10];

	private final int BOSS_WIDTH = 293;
	private final int BOSS_HEIGHT = 590;

	private final int X = 650;
	private final int Y = 40;

	private int hp = 600;
	private int power;

	private int state;

	private int count;

	private boolean waiting;
	private boolean attacking;
	private boolean beAttacked;

	private boolean attack;
	private boolean wait;

	private int damage;

	public Boss(Ground groundContext, int hp, int power) {
		this.groundContext = groundContext;
		this.hp = hp;
		this.power = power;

		setInitLayout();
	}

	public void setInitLayout() {
		setSize(BOSS_WIDTH, BOSS_HEIGHT);
		setLocation(X, Y);

	}

	public void waiting() {
		new Thread(() -> {

			waiting = true;
			wait = true;

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
					attacking = true;
					attack();
				}
			}
		}).start();
	}

	public void attack() {

		new Thread(() -> {

			for (int i = 0; i < bossAttack.length && attacking && state == 0; i++) {
				try {
					setIcon(bossAttack[i]);
					Thread.sleep(130);
				} catch (InterruptedException e) {
					System.err.println("보스 어택에서 에러");
				}
			}
			attacking = false;
			waiting = true;
			waiting();
		}).start();
	}

	public void beAttacked(int damage) {

		new Thread(() -> {

			if (state == 0 && hp > 0) {
				try {
					hp -= damage;
					groundContext.bossInfo();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println("보스 비 어택드 에러");
				}
			} else {
				hp = 0;
				die();
			}
		}).start();
	}

	public void die() {
		state = 1;
		for (int i = 0; i < bossDie.length; i++) {
			setIcon(bossDie[i]);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		new GameState(state);
		groundContext.setVisible(false);
	}
}
