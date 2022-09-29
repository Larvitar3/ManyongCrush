package manyongCrush;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.ActivationInstantiator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoiceCharacter extends JFrame implements ActionListener {

	private JLabel backgroundImage;
	private JLabel wizardLabel;
	private JLabel warriorLabel;

	private JButton choiceWizard;
	private JButton choiceWarrior;
	private LoginBgm bgm;

	private int choiceCount;

	public ChoiceCharacter() {
		initData();
		setInitLayout();
		addEventListenter();
//		LoginBgm bgm = new LoginBgm();
	}

	private void initData() {
		setSize(1000, 700);
		setTitle("캐릭터 선택창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImage = new JLabel(new ImageIcon("Images/choiceBackground.png"));
		setContentPane(backgroundImage);

		ImageIcon wizardImg = new ImageIcon("Images/wizardChoiceImage.png");
		wizardLabel = new JLabel(wizardImg);

		ImageIcon warriordImg = new ImageIcon("Images/warriorChoiceImage.png");
		warriorLabel = new JLabel(warriordImg);

		ImageIcon choiceWizardBtn = new ImageIcon("Images/choiceWizard.png");
		choiceWizard = new JButton(choiceWizardBtn);

		ImageIcon choiceWarriorBtn = new ImageIcon("Images/choiceWarrior.png");
		choiceWarrior = new JButton(choiceWarriorBtn);

		ImageIcon startBtnImg = new ImageIcon("Images/startBtn.png");

		choiceWizard.setRolloverIcon(startBtnImg);
		choiceWarrior.setRolloverIcon(startBtnImg);

		choiceWizard.setPressedIcon(startBtnImg);
		choiceWarrior.setPressedIcon(startBtnImg);

	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		add(wizardLabel);
		wizardLabel.setSize(200, 170);
		wizardLabel.setLocation(247, 370);

		add(warriorLabel);
		warriorLabel.setSize(200, 170);
		warriorLabel.setLocation(530, 370);

		add(choiceWizard);
		choiceWizard.setSize(113, 43);
		choiceWizard.setLocation(285, 537);
		choiceWizard.setBorderPainted(false);
		choiceWizard.setContentAreaFilled(false);

		add(choiceWarrior);
		choiceWarrior.setSize(113, 43);
		choiceWarrior.setLocation(576, 537);
		choiceWarrior.setBorderPainted(false);
		choiceWarrior.setContentAreaFilled(false);

	}

	private void addEventListenter() {

		choiceWizard.addActionListener(this);
		choiceWarrior.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choiceWizard) {
			setVisible(false);
			choiceCount = 1;

//			LoginBgm loginBgm = new LoginBgm();
			ChoiceLevel choiceLevel = new ChoiceLevel();
			System.out.println("생성위치: " + choiceLevel.hashCode());
			choiceLevel.setCharcterNumber(choiceCount);
			System.out.println("마법사 선택 ");
			// wizard 선택

		} else {
			choiceCount = 2;
			setVisible(false);
//			LoginBgm loginBgm = new LoginBgm();
			ChoiceLevel choiceLevel = new ChoiceLevel();
			choiceLevel.setCharcterNumber(choiceCount);
			System.out.println("전사 선택");
			// warrior 선택

		}
//		bgm.clipStop();
		System.out.println(choiceCount);

	}

	public static void main(String[] args) {
		new ChoiceCharacter();
	}

}
