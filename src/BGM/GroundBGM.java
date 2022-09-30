package BGM;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import lombok.Getter;

@Getter
public class GroundBGM {
	private Clip clip;

	public GroundBGM() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("images/groundBGM.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);

			// 소리 설정
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			// 볼륨 조정
//            gainControl.setValue(-30.0f);

			clip.start();

		} catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();
		}
	}


	public void clipStop() {
		clip.stop();
	}

}