package manyongCrush;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Meteor extends JLabel {
	private Random random = new Random();

	Player player;
	Ground groundContext;
	
	private int x;
	private int y;
	private int power = 20;
	
	

	private final int LAVA_METEOR_WIDTH = 57;
	private final int LAVA_METEOR_HEIGHT = 123;

	private boolean lavaMeteorFalling;// true : 떨어짐
	private boolean hited; // 플레이어가 맞았을때

	private int lavaMeteors;

	private ImageIcon lavaMeteorImage;
	private ImageIcon lavaBoomMeteorImage;
	private ChoiceLevel choiceLevel;

	public Meteor(Ground groundConText) {
		this.groundContext = groundConText;
		this.player = groundConText.player;
		
		initData();
		setInitLayout();
	}

	private void initData() {
		lavaMeteorImage = new ImageIcon("images/meteor.png");
		lavaBoomMeteorImage = new ImageIcon("images/boomMeteor2.png");
		lavaMeteors = random.nextInt(700) + 200; // x좌표값 랜덤설정 x좌표 200부터시작
	}

	private void setInitLayout() {
		x = lavaMeteors; // x값 랜덤으로 받아옴
		y = -500; // 프레임 밖에서 떨어짐
		setLocation(x, y);
		setIcon(lavaMeteorImage);
		setSize(LAVA_METEOR_WIDTH, LAVA_METEOR_HEIGHT);
	}

	public void down(int mode) {
		System.out.println("다운");

		System.out.println(groundContext.player.isBeAttacked());
		new Thread(() -> {
			int downSpeed = 2;
			while (true) {
				if (!lavaMeteorFalling || x >= -300) {
					setIcon(lavaMeteorImage);
					if (mode == 1 || mode == 2) {
						downSpeed = 2;
					} else {
						downSpeed = 4;
					}
					y += downSpeed;
					setLocation(x, y);
						attack(); 
						
				}
				try {
					Thread.sleep(random.nextInt(8) + 5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (y >= 800) {
					x = random.nextInt(700) + 30;
					y = -200;
					setLocation(x, y);
					setIcon(lavaMeteorImage);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}


	public void attack() {
		
		if (!player.isBeAttacked()) { // 안맞았을때
			if ((Math.abs(x - player.getX()) - 20 < 70 // 플레이어 좌표 감지
					&& Math.abs(y - player.getY() + 60) < 40)) {
				try {
					setSize(148, 125); 
					setIcon(lavaBoomMeteorImage);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				y = -200;
				setLocation(x, y);
				player.setHp(player.getHp() - power);
				System.out.println(player.getHp());
				player.beAttacked();
			
			}
		}

	}
}

