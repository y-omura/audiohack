package com.yfoggi.audiohack;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

class AudioHack extends Thread {
	private double f = 22000.0;

	public static void main(String[] args) {
		AudioHack hack = new AudioHack();
		hack.init();
		hack.start();
	}

	private void init(){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("java.class.path")+"/../audiohack.prop"));

			String fs = (String)prop.get("f");
			if(fs != null){
				double f = Float.parseFloat(fs);
				if(f > 0){
					this.f = f;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			byte[] wave = new byte[44100 * 1];
			for (int i = 0; i < wave.length; i++) {
				wave[i] = (byte) (1 * Math.sin(i / 44100d * f * Math.PI * 2));
			}

			AudioFormat format = new AudioFormat(44100, 8, 1, true, false);
			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(format, wave, 0, wave.length);

			while(true){
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				try{
					Thread.sleep(Long.MAX_VALUE);
				} catch(Exception e){
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}