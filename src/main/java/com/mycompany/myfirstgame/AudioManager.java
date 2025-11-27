
package com.mycompany.myfirstgame;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

    private static MediaPlayer mediaPlayer;

    public void playMusic() {
        URL resource = getClass().getResource("/audio/1-01. Opening.mp3");
        if (resource != null) {
            Media media = new Media(resource.toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // ripete all'infinito
            mediaPlayer.setVolume(0.5); // volume da 0.0 a 1.0
            mediaPlayer.play();
            System.out.println("audio presente");
        } else {
            System.out.println("File audio non trovato!");
        }
    }

    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
