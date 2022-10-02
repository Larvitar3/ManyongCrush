package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Attack, Moveable {

	protected String name;
	protected int hp;
	protected int power;
	protected int x;
	protected int y;
	protected int playerWidth;
	protected int playerHeight;
	protected int state = 0;
	protected int skillCount;

	protected boolean left;
	protected boolean right;
	protected boolean jump;
	protected boolean down;

	protected boolean crashWallL;
	protected boolean crashWallR;
	protected boolean crashBoss;

	protected boolean beAttacked;
	protected boolean attacking;

	protected boolean attackCoolTime;
	protected boolean skillCoolTime;

	protected final int SPEED = 4;
	protected final int JUMPSPEED = 2;
	protected final int DOWNSPEED = 4;

	private int bossX;
	private int bossY;

	private int bossWidth;
	private int bossHeight;

	private final int BOSSCRASHDAMAGE = 10;

	protected PlayerWay pWay;

	protected SkillImpact skillImpact;

	protected ImageIcon[] playerLeftAttackMotionImg = new ImageIcon[2];
	protected ImageIcon[] playerRightAttackMotionImg = new ImageIcon[2];

	protected ImageIcon[] playerLeftSkillMotionImg = new ImageIcon[2];
	protected ImageIcon[] playerRightSkillMotionImg = new ImageIcon[2];

	protected ImageIcon[] playerLeftBeAttacked = new ImageIcon[7];
	protected ImageIcon[] playerRightBeAttacked = new ImageIcon[7];

	protected ImageIcon playerDieMotionImg;

	protected Ground groundContext;

	public Player(Ground groundContext, String name, int hp, int x, int y, int playerWidth, int playerHeight) {
		this.name = name;
		this.hp = hp;
		this.x = x;
		this.y = y;
		this.playerWidth = playerWidth;
		this.playerHeight = playerHeight;
		this.groundContext = groundContext;

		skillCount = 5;
		down = false;
//		new Thread(new BackgroundService(this)).start();
	}

	protected void setInitLayout() {
		playerDieMotionImg = new ImageIcon("images/characterDie.png");
		setIcon(playerLeftAttackMotionImg[1]);
		setSize(playerWidth, playerHeight);
		setLocation(x, y);

		bossX = groundContext.boss.getX();
		bossY = groundContext.boss.getY();

		bossWidth = groundContext.boss.getWidth();
		bossHeight = groundContext.boss.getHeight();
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

				while (right && state == 0) {
					setIcon(playerRightAttackMotionImg[1]);
					x += SPEED;
					setLocation(x, y);
					crashBoss();
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
				while (left && state == 0) {
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
				while (down && state == 0) {
					y += DOWNSPEED;
					setLocation(x, y);
					crashBoss();
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
					crashBoss();
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
		new Thread(() -> {
			state = 1;
			setIcon(playerDieMotionImg);
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new GameState(state - 1);
			groundContext.setVisible(false);
		}).start();

	}

	@Override
	public void beAttacked(int damage) {

		new Thread(() -> {

			if (state == 0) {
				beAttacked = true;
				groundContext.unitHpInfo();
				if (hp <= 0) {
					hp = 0;
					die();
				}
				hp -= damage;
				for (int i = 0; i < playerLeftBeAttacked.length; i++) {
					try {
						if (pWay == PlayerWay.LEFT) {
							setIcon(playerLeftBeAttacked[i]);
							x += 2;
							y -= 2;
							setLocation(x, y);
						} else {
							setIcon(playerRightBeAttacked[i]);
							x -= 2;
							y -= 2;
							setLocation(x, y);
						}
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			beAttacked = false;
		}).start();
	}

	public void crashBoss() {

		if ((Math.abs((x + (WIDTH / 2)) - (bossX + (bossWidth / 2))) < 200
				&& Math.abs((y + (HEIGHT / 2)) - ((bossY + bossHeight) / 2)) < 250)) {
			crashBoss = true;
			try {
				beAttacked(BOSSCRASHDAMAGE);
				Thread.sleep(500);
				System.out.println("먹나요");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		crashBoss = false;
	}
}