package BackgroundService;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import manyongCrush.Player;

public class BackgroundServiceNormal extends BackgroundService {

	private Player player;

	public BackgroundServiceNormal(Player player) {
		super(player);
		this.player = player;
		try {
			playerService = ImageIO.read(new File("images/bossBackgroundMapService.jpg"));
		} catch (Exception e) {
<<<<<<< HEAD
			System.err.println("이미지 경로 에러 ");
=======
			System.out.println("노말 이미지 경로 에러 ");
>>>>>>> dev
		}

	}
}
