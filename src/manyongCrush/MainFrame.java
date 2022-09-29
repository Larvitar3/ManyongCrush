package manyongCrush;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements ActionListener {

	JLabel backgroundHellImage;
	JLabel backgroundNormalImage;

	List<Meteor> meteorList;
	int modeCount;

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

		if (modeCount == 1 || modeCount == 2) {
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
		}

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

	private void addEventLitenter() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		// 테스트용 메인창
<<<<<<< HEAD
		new MainFrame(3);
=======
		new MainFrame(4);
>>>>>>> f-metorBackgroundmerge

	}

}
