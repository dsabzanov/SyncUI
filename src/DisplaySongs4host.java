/**
 * Created by Mac on 3/24/16.
 */
public class DisplaySongs4host {
    private String songName;
    private String filePath;

    public DisplaySongs4host(){
        this.songName = "";
        this.filePath = "";
    }

    public DisplaySongs4host (String songName) {
        this.songName = songName;
    }

    public DisplaySongs4host(String songName, String filePath) {
        this.songName = songName;
        this.filePath = filePath;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

