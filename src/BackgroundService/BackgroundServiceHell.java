package BackgroundService;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import manyongCrush.Player;

public class BackgroundServiceHell extends BackgroundService {


	private Player player;

	public BackgroundServiceHell(Player player) {
		super(player);
		
		try {
			playerService = ImageIO.read(new File("bossBackgroundMapServiceHell.jpg"));
		} catch (IOException e) {
			System.err.println("이미지 경로 에러 ");
		}
		
	}

}
