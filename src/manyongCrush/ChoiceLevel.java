package manyongCrush;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoiceLevel extends JFrame implements ActionListener {

	private JLabel backgroundImage;

	private JButton choiceNormal;
	private JButton choiceHell;
	private ChoiceCharacter choiceCharacter;

	private int charcterNumber;
	int flagCount;

	public ChoiceLevel() {
		initData();
		setInitLayout();
		addEventListenter();
	}

	private void initData() {
		setSize(1000, 700);
		setTitle("던전 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		choiceCharacter = new ChoiceCharacter();
		choiceCharacter.setVisible(false);

		backgroundImage = new JLabel(new ImageIcon("Images/choiceLevelBakcground.jpg"));
		setContentPane(backgroundImage);

		ImageIcon choiceNormalBtn = new ImageIcon("Images/choiceLevelNormal.png");
		choiceNormal = new JButton(choiceNormalBtn);

		ImageIcon choiceHellBtn = new ImageIcon("Images/choiceLevelHell.png");
		choiceHell = new JButton(choiceHellBtn);

		ImageIcon nomalHover = new ImageIcon("Images/choiceLevelNormalHover.png");
		ImageIcon hellHover = new ImageIcon("Images/choiceLevelHellHover.png");

		choiceNormal.setRolloverIcon(nomalHover);
		choiceHell.setRolloverIcon(hellHover);

		choiceNormal.setPressedIcon(nomalHover);
		choiceHell.setPressedIcon(hellHover);

	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		add(choiceNormal);
		choiceNormal.setSize(262, 310);
		choiceNormal.setLocation(158, 248);
		choiceNormal.setBorderPainted(false);
		choiceNormal.setContentAreaFilled(false);
		// 노말 선택 설정

		add(choiceHell);
		choiceHell.setSize(262, 310);
		choiceHell.setLocation(563, 248);
		choiceHell.setBorderPainted(false);
		choiceHell.setContentAreaFilled(false);
		// 헬 선택 설정

	}

	private void addEventListenter() {
		choiceNormal.addActionListener(this);
		choiceHell.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == choiceNormal && charcterNumber == 1) {

			setVisible(false);
			flagCount = 1;
			MainFrame mainFrame = new MainFrame(flagCount);
			mainFrame.modeCount = flagCount;
			System.out.println("선택 : 노말선택" + "  번호 :  " + charcterNumber + " 마법사 선택");

		} else if (e.getSource() == choiceNormal && charcterNumber == 2) {

			setVisible(false);
			flagCount = 2;
			MainFrame mainFrame = new MainFrame(flagCount);
			System.out.println("선택 : 노말선택" + "  번호 :  " + charcterNumber + " 전사 선택");

		} else if (e.getSource() == choiceHell && charcterNumber == 1) {

			setVisible(false);

			flagCount = 3;
			MainFrame mainFrame = new MainFrame(flagCount);
			mainFrame.modeCount = flagCount;
			System.out.println("선택 : 헬 선택" + "  번호 :  " + charcterNumber + " 마법사 선택");

		} else if (e.getSource() == choiceHell && charcterNumber == 2) {

			setVisible(false);

			flagCount = 4;
			MainFrame mainFrame = new MainFrame(flagCount);
			mainFrame.modeCount = flagCount;
			System.out.println("선택 : 헬 선택" + "  번호 :  " + charcterNumber + " 전사 선택");
		} else {
			System.out.println("값 없음");
		}

	}

}
