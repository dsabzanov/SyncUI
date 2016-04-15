package GUI.DataWrappers;

import java.io.File;

/**
 * Created by Mac on 3/24/16.
 * Project: Sync
 */
public class SongWrapper {
    private String songName;
    private String filePath;
    private File file;

    public SongWrapper(File file) {
        this.songName = file.getName();
        this.filePath = file.getAbsolutePath();
        this.file = file;
    }

    public String getSongName() {
        return songName;
    }

    public String getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }
}

