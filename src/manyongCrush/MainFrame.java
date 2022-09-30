package manyongCrush;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

	JLabel backgroundHellImage;
	JLabel backgroundNormalImage;
	int modeCount;

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

	private int bossHpWidth;
	private int characterHpWidth;

// private String name = "▶ ▷ " + player.getName + " ◁ ◀";
	private String name = "▶ ▷ 마법사 ◁ ◀"; // 테스트용 임시값 ▲ 값 넣고 삭제

	public MainFrame(int modeCount) {
		this.modeCount = modeCount;
		initData();
		setInitLayout();
		addEventLitener();
	}

	private void initData() {
		setSize(1000, 700);
		setTitle("ManyongCrush");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (modeCount == 1) {
			// 마법사 / 노말
			backgroundNormalImage = new JLabel(new ImageIcon("images/bossBackgroundMap.jpg"));
			setContentPane(backgroundNormalImage);
			System.out.println("마법사 / 노말");

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

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

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

	}

	private void addEventLitener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		// 테스트용 메인창
		new MainFrame(1);

	}

}
