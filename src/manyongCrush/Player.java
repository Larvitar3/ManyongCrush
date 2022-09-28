package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends JLabel implements Attack, Moveable {

	private MainFrame mContext;
	
	
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

	private ImageIcon[] playerLeftAttackMotionImg = new ImageIcon[2];
	private ImageIcon[] playerRightAttackMotionImg = new ImageIcon[2];

	private ImageIcon[] playerLeftSkillMotionImg = new ImageIcon[2];
	private ImageIcon[] playerRightSkillMotionImg = new ImageIcon[2];

	private ImageIcon playerDieMotionImg;


	public Player(String name, int hp, int power, int x, int y, int playerWidth, int playerHeight) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.x = x;
		this.y = y;

		setInitLayout();
	}

	protected void setInitLayout() {
		setIcon(playerLeftAttackMotionImg[1]);
		setSize(playerWidth, playerHeight); // 위자드 이미지 사이즈
		setLocation(x, y);
		System.out.println("케릭터 생성");
	}

	@Override
	public void fireballAttack() {
		
	}

	@Override
	public void chainFireballAttack() {
		
	}

	@Override
	public void slashAttack() {
		
	}

	@Override
	public void megaSlashAttack() {
		
	}
	@Override
	public void right() {
		this.setPWay(PlayerWay.RIGHT); // 오른쪽으로 보고있을때
		setRight(true);
		new Thread(new Runnable() {

			@Override
			public void run() {

				while (isRight() && getState() == 0) {
					setIcon(playerRightAttackMotionImg[1]);
					int position = getX() + getSPEED();
					setX(position);
					setLocation(getX(), getY());
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
		this.setPWay(PlayerWay.LEFT);

		setLeft(true);
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (isLeft() && getState() == 0) {
					setIcon(playerLeftAttackMotionImg[1]);
					int position = getX() - getSPEED();
					setX(position);
					setLocation(getX(), getY());
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
				if (state == 0) {
					for (int i = 0; i < 130 / JUMPSPEED; i++) {
						y -= JUMPSPEED;
						setLocation(x, y);
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
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
	}

	@Override
	public void beAttacked() {
		new Thread(() -> {

			beAttacked = true;
			if (hp <= 0) {
				hp = 0;
				setIcon(playerDieMotionImg); // 죽는모션으로 변경
				die();
			}
//			context.unitHpInfo();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			beAttacked = false;
		}).start();
	}



}
