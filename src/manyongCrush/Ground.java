package manyongCrush;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BackgroundService.BackgroundService;
import BackgroundService.BackgroundServiceNormal;

public class Ground extends JFrame implements ActionListener {

	Ground groundContext = this;
	// todoTestCode
	Boss boss;

	Player player;


	JLabel backgroundHellImage;
	JLabel backgroundNormalImage;
	BackgroundService backgroundService;
	int modeCount;
	int charcterNumber;

	List<Meteor> meteorList;

	boolean flag;

	JLabel[] characterSkillCounts = new JLabel[5];
	String[] skillCounts = { " ● ", " ● ", " ● ", " ● ", " ● " };
	int skillCount;

	JLabel bossHpBox;
	JLabel bossHpBgBox;

	JLabel hpTitle;
	JLabel skillTitle;
	JPanel characterInfoBox;
	JLabel characterHp;
	JLabel characterName;

	int bossHpWidth;
	int characterHpWidth;

	// private String name = "▶ ▷ " + player.getName + " ◁ ◀";
	String name = "▶ ▷ 마법사 ◁ ◀"; // 테스트용 임시값 ▲ 값 넣고 삭제

	public Ground(int modeCount, int charcterNumber) {
		this.modeCount = modeCount;
		this.charcterNumber = charcterNumber;

		if (charcterNumber == 1 && modeCount == 1) {
			

			player = new Wizard(groundContext, "마법사", 200, 30, 116, 92, 116, 92);
			boss = new NormalBoss(800, 100);
		}
		
		initData();
		setInitLayout();
		addEventListener();

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
			System.out.println("스타트 전");
			new Thread(backgroundService = new BackgroundServiceNormal(player)).start();
			System.out.println("스타트 후");
			meteorList = new ArrayList<Meteor>();
			for (int i = 0; i < 5; i++) {
				meteorList.add(new Meteor(groundContext));
			}
			meteorStart(modeCount);
		} else {
			meteorList = new ArrayList<Meteor>();
			for (int i = 0; i < 10; i++) {
				meteorList.add(new Meteor(groundContext));
			}
			meteorStart(modeCount);
		}

		System.out.println("모드 카운터 값 : " + modeCount);

		if (modeCount == 1) {
			// 마법사 / 노말
			backgroundNormalImage = new JLabel(new ImageIcon("images/bossBackgroundMap.jpg"));
			setContentPane(backgroundNormalImage);
			System.out.println("마법사 / 노말");
			add(player);
			add(boss);

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

		bossHpBgBox = new JLabel("");
		bossHpBox = new JLabel("");

		characterInfoBox = new JPanel();
		characterHp = new JLabel("");
		characterName = new JLabel(name);
		hpTitle = new JLabel("HP");
		skillTitle = new JLabel("스킬");

//		skillCount = wizard.getSkillCount();
		skillCount = 5; // 테스트용 임시값 ▲ 값 넣고 삭제
		for (int i = 0; i < characterSkillCounts.length; i++) {
			characterSkillCounts[i] = new JLabel(skillCounts[i]);
		}

	} // end of initData

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		meteorList.forEach((m) -> {
			System.out.println("메테오 추가");
			add(m);
		});

		Color blackOp = new Color(0, 0, 0, 200);
		Color bloodRed = new Color(157, 0, 0);

		add(bossHpBox);
		add(bossHpBgBox);

		bossHpBgBox.setSize(800, 40);
		bossHpBgBox.setLocation(100, 50);
		bossHpBgBox.setOpaque(true);
		bossHpBgBox.setBackground(Color.LIGHT_GRAY);

//		bossHpWidth = boss.getHp(); 
		bossHpWidth = 800; // 테스트용 임시값 ▲ 값 넣고 삭제
		bossHpBox.setSize(bossHpWidth, 40);
		bossHpBox.setLocation(100, 50);
		bossHpBox.setOpaque(true);
		bossHpBox.setBackground(bloodRed);

		add(characterHp);

		add(characterName);
		add(hpTitle);
		add(skillTitle);

		hpTitle.setSize(50, 20);
		hpTitle.setLocation(30, 580);
		hpTitle.setForeground(Color.WHITE);
		hpTitle.setFont(new Font("SanSerif", Font.BOLD, 16));

		skillTitle.setSize(50, 20);
		skillTitle.setLocation(30, 605);
		skillTitle.setForeground(Color.WHITE);
		skillTitle.setFont(new Font("SanSerif", Font.BOLD, 12));

		characterName.setSize(145, 20);
		characterName.setLocation(55, 550);
		characterName.setForeground(Color.WHITE);
		characterName.setFont(new Font("SanSerif", Font.BOLD, 18));

		for (int i = 0; i < skillCount; i++) {
			add(characterSkillCounts[i]);
		}

		for (int i = 0; i < characterSkillCounts.length; i++) {
			characterSkillCounts[i].setSize(200 / 2, 20);
			characterSkillCounts[i].setLocation(60 + (i * 20), 605);
			characterSkillCounts[i].setFont(new Font("SanSerif", Font.BOLD, 18));
			characterSkillCounts[i].setForeground(Color.WHITE);
		}

//		characterHpWidth = wizard.getHp();
		characterHpWidth = 300; // 테스트용 임시값 ▲ 값 넣고 삭제
		characterHp.setSize(characterHpWidth / 2, 20);
		characterHp.setOpaque(true);
		characterHp.setBackground(bloodRed);
		characterHp.setLocation(60, 580);

		add(characterInfoBox);
		characterInfoBox.setSize(200, 100);
		characterInfoBox.setLocation(20, 540);
		characterInfoBox.setBackground(blackOp);

	} // end of setInitLayout

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

	} // end of addEventListenter

	@Override
	public void actionPerformed(ActionEvent e) {

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

//	public static void main(String[] args) {
//		// 테스트용 메인창
//		new Ground(1, 1);
//
//	}

}
