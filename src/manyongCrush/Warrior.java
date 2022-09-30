package manyongCrush;

import javax.swing.ImageIcon;

public class Warrior extends Player {

	Ground groundContext;

	private SkillImpact skillImpact;
	private String[] warriorLeftAttackMotion = { "images/warriorAttackMotionL.png",
			"images/warriorWaitingMotionL.png" };
	private String[] warriorRightAttackMotion = { "images/warriorAttackMotionR.png",
			"images/warriorWaitingMotionR.png" };
	private String[] warriorLeftSkillMotion = { "images/warriorSkillMotionL.png", "images/warriorWaitingMotionL.png" };
	private String[] warriorRightSkillMotion = { "images/warriorSkillMotionR.png", "images/warriorWaitingMotionR.png" };

	public Warrior(Ground groundContext, String name, int hp, int power, int x, int y, int playerWidth,
			int playerHeight) {
		super(groundContext, name, hp, power, x, y, playerWidth, playerHeight);
		this.groundContext = groundContext;
		initData();
		setInitLayout();
	}

	public void initData() {
		for (int i = 0; i < warriorLeftAttackMotion.length; i++) {
			getPlayerLeftAttackMotionImg()[i] = new ImageIcon(warriorLeftAttackMotion[i]);
		}
		for (int i = 0; i < warriorRightAttackMotion.length; i++) {
			getPlayerRightAttackMotionImg()[i] = new ImageIcon(warriorRightAttackMotion[i]);
		}
		for (int i = 0; i < warriorLeftSkillMotion.length; i++) {
			getPlayerLeftSkillMotionImg()[i] = new ImageIcon(warriorLeftSkillMotion[i]);
		}
		for (int i = 0; i < warriorRightSkillMotion.length; i++) {
			getPlayerRightSkillMotionImg()[i] = new ImageIcon(warriorRightSkillMotion[i]);
		}
	}

	@Override
	public void attack() {


		new Thread(() -> {

			if (getPWay() == PlayerWay.LEFT) {
				for (int i = 0; i < warriorLeftAttackMotion.length; i++) {
					setIcon(getPlayerLeftAttackMotionImg()[i]);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println("워리어 왼쪽 어택");
					}
					skillImpact = new Slash(groundContext, this, getX(), getY(), 30, 50, 110, 89);
					groundContext.boss.beAttacked(skillImpact.getPower());
				}
			} else if(getPWay() == PlayerWay.RIGHT){
				for (int i = 0; i < warriorRightAttackMotion.length; i++) {
					setIcon(getPlayerRightAttackMotionImg()[i]);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println("워리어 오른쪽 어택");
					}
					skillImpact = new Slash(groundContext, this, getX(), getY(), 30, 50, 110, 89);
					groundContext.boss.beAttacked(skillImpact.getPower());
				}
			}
		}).start();
	}

	@Override
	public void skill() {

		new Thread(() -> {

			if (isLeft()) {
				for (int i = 0; i < warriorLeftSkillMotion.length; i++) {
					setIcon(getPlayerLeftSkillMotionImg()[i]);
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						System.out.println("워리어 왼쪽 스킬");
					}
				}
				skillImpact = new MegaSlash(groundContext, this, getX(), getY(), 50, 70, 110, 104);
			} else {
				for (int i = 0; i < warriorRightSkillMotion.length; i++) {
					setIcon(getPlayerRightSkillMotionImg()[i]);
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						System.out.println("워리어 오른쪽 스킬");
					}
				}
				skillImpact = new MegaSlash(groundContext, this, getX(), getY(), 30, 50, 110, 104);
			}
		}).start();
	}
}