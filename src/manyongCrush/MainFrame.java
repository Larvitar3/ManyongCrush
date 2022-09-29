package manyongCrush;

import java.awt.Color;
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
	
	private JLabel[] characterSkillCounts = new JLabel[5];
	private String[] skillCounts = { "●", "●", "●", "●", "●" };
	private int count;

	JLabel bossHpBox;
	JLabel bossHpBgBox;

	JLabel hpTitle;
	JPanel characterInfoBox;
	JLabel characterHp;
	JLabel characterName;

	private int bossHpWidth;
	private int characterHpWidth;

	private String name;
	

	public MainFrame(int modeCount) {
		this.modeCount = modeCount;
		initData();
		setInitLayout();
		addEventLitenter();
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
		
		for (int i = 0; i < characterSkillCounts.length; i++) {
			characterSkillCounts[i] = new JLabel(skillCounts[i]);
		}
//		counts = wizard.getSkillCount();
	
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
	
//		bossHpWidth = boss.getHp();
		bossHpBgBox.setSize(800, 40);
		bossHpBgBox.setLocation(100, 50);
		bossHpBgBox.setOpaque(true);
		bossHpBgBox.setBackground(Color.LIGHT_GRAY);

		bossHpBox.setSize(bossHpWidth, 40);
		bossHpBox.setLocation(100, 50);
		bossHpBox.setOpaque(true);
		bossHpBox.setBackground(bloodRed);
		
		add(characterHp);
		for (int i = 0; i < count; i++) {
			add(characterSkillCounts[i]);
		}
		add(characterName);
		add(hpTitle);
		add(characterInfoBox);
		
		
		
	}

	private void addEventLitenter() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		// 테스트용 메인창
		new MainFrame(6);

	}

}
