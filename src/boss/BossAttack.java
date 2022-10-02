package boss;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import player.Player;

public class BossAttack extends JLabel {

	Random random = new Random();

	ImageIcon wrath;
	ImageIcon wrathBoom;

	Boss boss;
	Player player;

	private int x;
	private int y;

	private int meteors;
	private int time;

	private final int WRATH_WIDTH = 89;
	private final int WRATH_HEIGHT = 80;

	private boolean wrathFlying;

	public BossAttack(Boss boss) {
		this.boss = boss;

		initData();
		setInitLayout();

	}

	private void initData() {
		y = random.nextInt(500);
		time = random.nextInt(10000);

		wrath = new ImageIcon("Images/bossAttack.png");
		wrathBoom = new ImageIcon("images/boomMeteor.png");
	}

	private void setInitLayout() {
		setSize(WRATH_WIDTH, WRATH_HEIGHT);
		setLocation(x, y);
	}

	public void fly() {

		new Thread(() -> {

			while (true) {

				setIcon(wrath);
				x--;
				setLocation(x, y);

			}

		}).start();
	}

	public void checkPlayer() {

	}

}
