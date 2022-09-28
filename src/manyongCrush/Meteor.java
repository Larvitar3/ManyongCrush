package manyongCrush;

import java.util.Random;

import javax.swing.JLabel;

public class Meteor extends JLabel{

	
	private int x;
	private int y;
	
	private boolean lavaMeteorFalling;// true : 떨어짐
	private boolean hited; // 플레이어가 맞았을때
	
	private Random random = new Random();
	private int lavaMeteors;
	private final int LAVA_METEOR_WIDTH = 57;
	private final int LAVA_METEOR_HEIGHT = 123;
	
}
