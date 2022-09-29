package manyongCrush;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BackgroundService.BackgroundService;
import BackgroundService.BackgroundServiceNormal;

public class Ground extends JFrame implements ActionListener {


	Ground groundContext = this;
	// todoTestCode
	Boss boss;
	
	JLabel backgroundHellImage;
	JLabel backgroundNormalImage;

	BackgroundService backgroundService;

	List<Meteor> meteorList;
	int modeCount;
	int charcterNumber;
	Player player;
	boolean flag;

	public Ground(int modeCount, int charcterNumber) {
		this.modeCount = modeCount;
		this.charcterNumber = charcterNumber;

		if (charcterNumber == 1 && modeCount == 1) {

			player = new Wizard(groundContext,"vjhgjm", 200, 30, 116, 92, 116, 92);

			initData();
			setInitLayout();
			addEventListener();
		}
//		else {
//			player = new Wizard(getName(), modeCount, modeCount,
//					modeCount, modeCount, modeCount, modeCount);
//		}

	}

	private void initData() {

		setSize(1000, 700);
		setTitle("ManyongCrush");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (modeCount == 1 || modeCount == 2) {
//			
			System.out.println("스타트 전");
			new Thread(backgroundService = new BackgroundServiceNormal(player)).start();
			System.out.println("스타트 후");
			meteorList = new ArrayList<Meteor>();
			for (int i = 0; i < 5; i++) {
				meteorList.add(new Meteor());
			}
			meteorStart(modeCount);
		} else {
			meteorList = new ArrayList<Meteor>();
			for (int i = 0; i < 10; i++) {
				meteorList.add(new Meteor());
			}
			meteorStart(modeCount);
			System.out.println("슈ㅠㅠ");
		}

		if (modeCount == 1) {
			// 마법사 / 노말
			backgroundNormalImage = new JLabel(new ImageIcon("images/bossBackgroundMap.jpg"));
			setContentPane(backgroundNormalImage);
			System.out.println("마법사 / 노말");
			add(player);
		} else if (modeCount == 2) {
			// 전사 / 노말
			backgroundNormalImage = new JLabel(new ImageIcon("images/bossBackgroundMap.jpg"));
			setContentPane(backgroundNormalImage);
			System.out.println("전사 / 노말");

		} else if (modeCount == 3) {
			// 마법사 / 헬
			backgroundHellImage = new JLabel(new ImageIcon("images/bossBackgroundMapHell.jpg"));
			setContentPane(backgroundHellImage);
			System.out.println("마법사 / 헬");

		} else if (modeCount == 4) {
			// 전사 / 헬
			backgroundHellImage = new JLabel(new ImageIcon("images/bossBackgroundMapHell.jpg"));
			setContentPane(backgroundHellImage);
			System.out.println("전사 / 헬");

		} else {
			System.out.println("테스트용 메인 카운트값 확인 바람");
		}

		System.out.println("?");

	}

	private void meteorStart(int mode) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < meteorList.size(); i++) {
					meteorList.get(i).down(mode);
					try {
						Thread.sleep(500);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		meteorList.forEach((m) -> {
			System.out.println("메테오 추가");
			add(m);
		});

	}

	protected void addEventListener() {
		if (player.getState() == 0) {

			this.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					int keyCode = e.getKeyCode();
					if (!player.isCrashWallL() && !player.isLeft() && keyCode == KeyEvent.VK_LEFT) {
						player.left();
					} else if (!player.isCrashWallR() && !player.isRight() && keyCode == KeyEvent.VK_RIGHT) {
						player.right();
					} else if (!player.isDown() && !player.isJump() && keyCode == KeyEvent.VK_UP) {
						player.jump();
					} else if (keyCode == KeyEvent.VK_Q) {
						player.attack();
					} else if (keyCode == KeyEvent.VK_W) {
						player.skill();
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					int keyCode = e.getKeyCode();
					if (keyCode == KeyEvent.VK_LEFT) {
						player.setLeft(false);
					} else if (keyCode == KeyEvent.VK_RIGHT) {
						player.setRight(false);
					}
				}
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		// 테스트용 메인창
		new Ground(1, 1);

	}

}
