package bottomFire;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frames.Ground;
import player.Player;

public class BottomFire extends JLabel {

	private Player player;
	private Ground groundContext;

	private int x;
	private int y;

	private int playerX;
	private int playerY;

	private int playerWidth;
	private int playerHeight;

	private final int DAMAGE = 20;
	private final int WIDTH = 500;
	private final int HEIGHT = 200;

	private ImageIcon[] bottomFires = new ImageIcon[10];
	private String[] bottomFireImages = { "images/bottomFire1.png", "images/bottomFire2.png", "images/bottomFire3.png",
			"images/bottomFire4.png", "images/bottomFire5.png", "images/bottomFire6.png", "images/bottomFire7.png",
			"images/bottomFire8.png", "images/bottomFire9.png", "images/bottomFire10.png" };

	public BottomFire(Ground groundContext) {
		this.groundContext = groundContext;
		this.player = groundContext.getPlayer();

		initData();
		setInitLayout();
		burning();
	}

	private void initData() {
		x = 495;
		y = 530;

		playerX = groundContext.getPlayer().getX();
		playerY = groundContext.getPlayer().getY();

		playerWidth = groundContext.getPlayer().getWidth();
		playerHeight = groundContext.getPlayer().getHeight();

		for (int i = 0; i < bottomFires.length; i++) {
			bottomFires[i] = new ImageIcon(bottomFireImages[i]);
		}
	}

	private void setInitLayout() {
		setIcon(bottomFires[0]);
		setLocation(x, y);
		setSize(WIDTH, HEIGHT);
	}

	public void burning() {

		new Thread(() -> {

			while (true) {
				for (int i = 0; i < bottomFireImages.length; i++) {
					try {
						checkPlayer();
						setIcon(bottomFires[i]);
						Thread.sleep(50);
					} catch (Exception e) {
					}
				}
			}
		}).start();
	}

	public void checkPlayer() {

		new Thread(() -> {

			if (!player.isBeAttacked()) { // 안맞았을때
				if ((Math.abs(x + (WIDTH / 2) - (playerX + (playerWidth / 2))) < 100 // 플레이어 좌표 감지
						&& Math.abs(y + (HEIGHT / 2) - (playerY + (playerHeight / 2))) < 50)) {
					try {
						System.out.println("응?");
						player.beAttacked(DAMAGE);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
