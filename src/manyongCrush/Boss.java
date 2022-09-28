package manyongCrush;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Boss extends JLabel {

	private ImageIcon[] boss = new ImageIcon[4];
	private String[] hellBossImage = {};
	private String[] bossImage = { "images/boss1.png", "images/boss2.png", "images/boss3.png", "images/boss2.png" };

	private ImageIcon[] bossAttack = new ImageIcon[19];
	private String[] hellBossAttackImage = {};
	private String[] bossAttackImage = { "images/bossMotion1.png", "images/bossMotion2.png", "images/bossMotion3.png",
			"images/bossMotion4.png", "images/bossMotion5.png", "images/bossMotion6.png", "images/bossMotion7.png",
			"images/bossMotion8.png", "images/bossMotion9.png", "images/bossMotion10.png", "images/bossMotion11.png",
			"images/bossMotion12.png", "images/bossMotion13.png", "images/bossMotion14.png", "images/bossMotion15.png",
			"images/bossMotion16.png", "images/bossMotion17.png", "images/bossMotion18.png",
			"images/bossMotion19.png" };

	private ImageIcon[] bossDie = new ImageIcon[3];
	private String[] bossDieImage = { "" };

	private final int BOSS_WIDTH = 293;
	private final int BOSS_HEIGHT = 590;

	private int hp;
	private int power;
	private int x;
	private int y;
	private int playerWidth;
	private int playerHeight;
	private int state = 0;

	private boolean waiting;
	private boolean attacking;
	private boolean beAttacked;
	private boolean hellMode;

	public Boss() {
		if (!hellMode) {
			normalBoss();
		} else {
			hellBoss();
		}
	}

	public void normalBoss() {

	}

	public void hellBoss() {

	}

}
