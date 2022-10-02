package manyongCrush;

import javax.swing.ImageIcon;

public class Wizard extends Player {

	Ground groundContext;

	private SkillImpact skillImpact;
	private String[] wizardLeftAttackMotion = { "images/wizardAttackMotionL.png", "images/wizardWaitingMotionL.png" };
	private String[] wizardRightAttackMotion = { "images/wizardAttackMotionR.png", "images/wizardWaitingMotionR.png" };
	private String[] wizardLeftSkillMotion = { "images/wizardSkillMotionL.png", "images/wizardWaitingMotionL.png" };
	private String[] wizardRightSkillMotion = { "images/wizardSkillMotionR.png", "images/wizardWaitingMotionR.png" };

	public Wizard(Ground groundContext, String name, int hp, int power, int x, int y, int playerWidth,
			int playerHeight) {
		super(groundContext, name, hp, power, x, y, playerWidth, playerHeight);
		this.groundContext = groundContext;
		System.out.println("위자드 생성");

		initData();
		setInitLayout();

	}

	public void initData() {
		for (int i = 0; i < wizardLeftAttackMotion.length; i++) {
			getPlayerLeftAttackMotionImg()[i] = new ImageIcon(wizardLeftAttackMotion[i]);
			System.out.println("사진 넣음");
		}
		for (int i = 0; i < wizardRightAttackMotion.length; i++) {
			getPlayerRightAttackMotionImg()[i] = new ImageIcon(wizardRightAttackMotion[i]);
		}
		for (int i = 0; i < wizardLeftSkillMotion.length; i++) {
			getPlayerLeftSkillMotionImg()[i] = new ImageIcon(wizardLeftSkillMotion[i]);
		}
		for (int i = 0; i < wizardRightSkillMotion.length; i++) {
			getPlayerRightSkillMotionImg()[i] = new ImageIcon(wizardRightSkillMotion[i]);
		}
	}

	@Override
	public void attack() {

		// Q눌렀을 때 공격 모션
		// 모션 중 스킬이 나감
		// 파이어볼 객체 구현
		setAttacking(true);
		new Thread(() -> {
			if (getPWay() == PlayerWay.LEFT) {
				for (int i = 0; i < wizardLeftAttackMotion.length; i++) {
					setIcon(getPlayerLeftAttackMotionImg()[i]);
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
				}
				skillImpact = new Fireball(groundContext, this, x, y, 30, 50, 100, 100);
				skillImpact.skillsLeftFly();
			} else if (getPWay() == PlayerWay.RIGHT) {
				for (int i = 0; i < wizardRightAttackMotion.length; i++) {
					setIcon(getPlayerRightAttackMotionImg()[i]);
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
				}
				skillImpact = new Fireball(groundContext, this, x, y, 30, 50, 100, 100); // 스킬 다른걸로 바꿔야함
				skillImpact.skillsRightFly();
			}
		}).start();
		setAttacking(false);
	}

	@Override
	public void skill() {

		new Thread(() -> {

			if (getPWay() == PlayerWay.LEFT) {
				for (int i = 0; i < wizardLeftSkillMotion.length; i++) {
					setIcon(getPlayerLeftSkillMotionImg()[i]);
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
				}
				skillImpact = new ChainFireball(groundContext, this, x, y, 50, 100, 200, 170);
				skillImpact.skillsLeftFly();
			} else {
				for (int i = 0; i < wizardRightSkillMotion.length; i++) {
					setIcon(getPlayerRightSkillMotionImg()[i]);
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
				}
				skillImpact = new ChainFireball(groundContext, this, x, y, 30, 50, 200, 170);
				skillImpact.skillsRightFly();
			}
		}).start();
	}
}