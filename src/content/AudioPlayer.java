/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * Responsible for playing and pausing the selected AudioFile An instance of
 * this class in created for every new AudioFile being played
 *
 * @author monamoe
 */
public class AudioPlayer {

    // The state of weather or not the file is currently being played
    // Determins if the audio should be paused or played
    boolean currentlyPlaying = true;

    // if the audio should be looped or not
    boolean looping = false;

    // The location for the audio file
    String audioFileLocation;

    // The timestamp which the Audio file was paused in
    // Used to determin where to continue playing from
    long timestamp = 0;

    // Audio Playing stuff
    public AudioInputStream audioInput;
    public Clip clip;

    public AudioPlayer(String location) {
        // A new audio file has been selected

        // Check to see if the file exists
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {

                // Init variablss
                this.audioFileLocation = location;
                this.timestamp = 0;
                this.currentlyPlaying = false;

                audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();

            } else {
                System.out.println("Error, file doesnt exist");
            }

        } catch (Exception e) {
        }
    }

    /**
     * Plays the audio file loaded in by the FileInput class
     */
    public void playAudio(boolean currentlyPaused, boolean loop) throws LineUnavailableException, IOException {
        // Create audio playing thread
        currentlyPlaying = true;

        // Create AudioThread
        Thread audioPlayerThread = new Thread(new AudioThread());
        // Init player threads variables

        // If looping the file
        if (looping) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            // dont loop
        }

        // Starts the thread
        audioPlayerThread.start();
    }

    public void pauseAudio() {

        currentlyPlaying = false;

        //Pause the track
        //update timestamp of track
        timestamp = clip.getMicrosecondPosition();

        //stop playing the track
        clip.stop();

        // set the new start location
        clip.setMicrosecondPosition(timestamp);

    }

//    /**
//     *
//     * @return time stamp when paused
//     */
//    public long getAudioTimeStamp() {
//        //time position
//        return clip.getMicrosecondPosition();
//    }
}
