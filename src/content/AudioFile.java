/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author monamoe
 */
public class AudioFile {

    private final String fileName;
    private final String extension;
    private String title;
    private String artists;
    private String genre;
    private String album;
    private String dir;

    public AudioFile(String fileName, String fileExtension) {
        this.fileName = fileName;
        this.extension = fileExtension;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }

}
