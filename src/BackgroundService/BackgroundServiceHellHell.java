package BackgroundService;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import manyongCrush.Player;

public class BackgroundServiceHellHell extends BackgroundService {

	private BufferedImage playerServiceHell;

	private Player player;

	public BackgroundServiceHellHell(Player player) {
		super(player);
		
		try {
			playerServiceHell = ImageIO.read(new File("bossBackgroundMapServiceHell.jpg"));
		} catch (IOException e) {
			System.out.println("이미지 경로 에러 ");
		}
		
	}

}
