package BackgroundService;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import manyongCrush.Player;

public class BackgroundServiceNormal extends BackgroundService{
	
	private BufferedImage playerServiceNormal;
	private Player player;
	

	public BackgroundServiceNormal(Player player) {
		super(player);
		
		try {
			playerServiceNormal = ImageIO.read(new File("images/bossBackgroundMapService.jpg"));
		} catch (IOException e) {
			System.out.println("이미지 경로 에러 ");
		}
		
	}
}
