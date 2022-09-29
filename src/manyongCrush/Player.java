package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Attack, Moveable {

	private String name;
	private int hp;
	private int power;
	private int x;
	private int y;
	private int playerWidth;
	private int playerHeight;
	private int state = 0;
	private int skillCount;

	private boolean left;
	private boolean right;
	private boolean jump;
	private boolean down;

	private boolean crashWallL;
	private boolean crashWallR;

	private boolean beAttacked;

	private final int SPEED = 4;
	private final int JUMPSPEED = 2;
	private final int DOWNSPEED = 4;

	private PlayerWay pWay;

	protected ImageIcon[] playerLeftAttackMotionImg = new ImageIcon[2];
	protected ImageIcon[] playerRightAttackMotionImg = new ImageIcon[2];

	protected ImageIcon[] playerLeftSkillMotionImg = new ImageIcon[2];
	protected ImageIcon[] playerRightSkillMotionImg = new ImageIcon[2];

	protected ImageIcon playerDieMotionImg;

	public Player(String name, int hp, int power, int x, int y, int playerWidth, int playerHeight) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.x = x;
		this.y = y;
		this.playerWidth = playerWidth;
		this.playerHeight = playerHeight;

		down = false;
//		new Thread(new BackgroundService(this)).start();
	}

	protected void setInitLayout() {
		setIcon(playerLeftAttackMotionImg[1]);
		setSize(playerWidth, playerHeight);
		setLocation(x, y);
		System.out.println("케릭터 생성");
	}

	@Override
	public void attack() {
	}

	@Override
	public void skill() {
	}

	@Override
	public void right() {
		pWay = (PlayerWay.RIGHT); // 오른쪽으로 보고있을때
		right = true;
		new Thread(new Runnable() {

			@Override
			public void run() {

				while (right) {
					setIcon(playerRightAttackMotionImg[1]);
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	@Override
	public void left() {
		pWay = PlayerWay.LEFT;

		left = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					setIcon(playerLeftAttackMotionImg[1]);
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void down() {
		down = true;

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					y += DOWNSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();
	}

	@Override
	public void jump() {
		jump = true;

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y -= JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				jump = false;
				down();
			}
		}).start();

	}

	@Override
	public void die() {
		state = 1;
		setIcon(playerDieMotionImg); // 죽는모션으로 변경
	}

	@Override
	public void beAttacked() {
		new Thread(() -> {

			beAttacked = true;
			if (hp <= 0) {
				hp = 0;
				die();
			}
			try {
				setIcon(playerDieMotionImg); // 깜빡깜빡으로 바꿔야함
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			beAttacked = false;
		}).start();
	}

}