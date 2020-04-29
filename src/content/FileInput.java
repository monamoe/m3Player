/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author monamoe
 */
public class FileInput {

    //The index of the song that is currently being played
    int currentlyPlayingIndex = 0;

    // if the audio is currently paused
    private boolean currentlyPaused = true;

    //LinkedList of audio files loaded into the program
    LinkedList<AudioFile> filesList = new LinkedList<>();

    //AudioPlayer class
    AudioPlayer audioPlayer;

    //AudioPlayer Class
    /**
     * @param directory
     * @throws IOException
     * @throws SAXException
     * @throws TikaException
     */
    public FileInput(String directory) throws IOException, SAXException, TikaException {

        // The file selected by the user, will be the first to play in the queue
        File selectedFile = new File(directory);

        // Create a file object 
        File baseUrl = new File(FilenameUtils.getPath(directory));

        // Create a FileFilter 
        FileFilter filter = (File f1) -> f1.getName().endsWith("mp3");

        System.out.println("Dir Path: " + baseUrl.getAbsolutePath());

        // Get all the names of the files present that are mp3
//        File newFile = new File("C:\\Users\\Abdulrahman\\Documents\\1_Programming\\6_Desktop Apps\\mp3Player");
//        File[] directoryFiles = newFile.listFiles(filter);
        // 
        String fileextentiontmp = "";

        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
        Parser parser = new Mp3Parser();
        ParseContext parseCtx = new ParseContext();

        //load mp3 or wav audio files into the linked list
//        System.out.println(directoryFiles[0].toString());
        audioPlayer = new AudioPlayer(directory);

        // Adding entire directory to the queue
//        for (int i = 0; i < files.length; i++) {
//            fileextentiontmp = FilenameUtils.getExtension(inputFile.getAbsolutePath());
//            if (fileextentiontmp.equals(".wav") || fileextentiontmp.equals(".mp3")) {
//
//                try {
//                    AudioFile adding = new AudioFile(files.getClass().getName(), fileextentiontmp);
//
//                    //add metadata to the AudioFile object
//                    InputStream fileInputStream = new FileInputStream(new java.io.File(files[i].getClass().getName()));
//                    parser.parse(fileInputStream, handler, metadata, parseCtx);
//                    fileInputStream.close();
//
//                    adding.setTitle(metadata.get("title"));
//                    adding.setArtists(metadata.get("xmpDM:artist"));
//                    adding.setGenre(metadata.get("xmpDM:genre"));
//                    adding.setAlbum(metadata.get("xmpDM:album"));
//                    adding.setDir(inputFile.getAbsolutePath());
//
//                    //add to the end of the arraylist
//                    filesList.addLast(adding);
//
//                } catch (IOException | SAXException | TikaException e) {
//                    System.out.println(e);
//                }
//                setPlayingTrack();
//            }
//        }
    }

    /**
     * inits the audioplayer with a new track only called when skipping to next
     * track
     */
    public void setPlayingTrack() {
        //for linked list
//        audioPlayer = new AudioPlayer(filesList.get(currentlyPlayingIndex).getExtension());

    }

    /**
     * Event for if pressed or paused
     */
    public void playPauseButton() {
        //Audio is currently paused
        if (currentlyPaused) {
            audioPlayer.playAudio();
        } else {
            audioPlayer.pauseAudio();
        }
    }

    public int numberOfSoundFiles() {
        return filesList.size();
    }

    /**
     * The track being played
     *
     * @param change the number of
     */
    public void updatePlayingIndex(int change) {
        this.currentlyPlayingIndex += change;
    }

    public void setPlayingIndex(int newValue) {
        this.currentlyPlayingIndex = newValue;
    }

    public int getPlayingIndex() {
        return this.currentlyPlayingIndex;
    }
}
