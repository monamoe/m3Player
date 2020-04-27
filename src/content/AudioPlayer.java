/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author monamoe
 */
public class AudioPlayer {

    String playingDirectory = "";
    long timestamp = 0;
    public AudioInputStream audioInput;
    public Clip clip;

    public AudioPlayer(String location) {
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {
                audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();

                // looping
                //clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Error, file doesnt exist");
            }

        } catch (Exception e) {
        }
    }

    /**
     * Plays the audio file loaded in by the FileInput class
     */
    public void playAudio() {
        try {
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @return time stamp when paused
     */
    public long getAudioTimeStamp() {
        //time position
        timestamp = clip.getMicrosecondPosition();
        return clip.getMicrosecondPosition();
    }

    /**
     * Pauses the track currently playing
     */
    public void pauseAudio() {
        //update timestamp of track
        timestamp = clip.getMicrosecondPosition();
        
        //stop playing the track
        clip.stop();
        
        // set the new start location
        clip.setMicrosecondPosition(timestamp);

    }

}
