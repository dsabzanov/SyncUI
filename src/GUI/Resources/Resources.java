package GUI.Resources;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gregl on 4/16/2016.
 * Project: Sync
 */
public class Resources {
    private static Resources instance = null;
    private static String resourceDirectory = System.getProperty("user.dir") + "/src/GUI/Resources";
    private static HashMap<String, Image> images = new HashMap<>();

    private Resources() {
        loadAllResources();
        instance = this;
    }

    private void loadAllResources() {
        List<File> imageFiles;

        // Gets a list of files within the Images directory
        try (Stream<File> fileStream = Files.walk(Paths.get(resourceDirectory + "/Images"))
                .filter(Files::isRegularFile).map(Path::toFile)) {
            imageFiles = fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Unable to load Resources");
            e.printStackTrace();
            return;
        }

        // Loads all images into the images colleciton
        for (File file : imageFiles) {
            String imageName = file.getName().substring(0, file.getName().lastIndexOf('.'));
            images.put(imageName, new Image("File:" + file.getPath()));
        }
    }

    public Image getImage(String imageName) {
        return images.containsKey(imageName) ? images.get(imageName) : null;
    }


    public ImageView getImageView(String imageName) {
        ImageView view = new ImageView(getImage(imageName));
        view.setPreserveRatio(true);
        return view;
    }

    public static Resources getInstance() {
        return instance == null ? new Resources() : instance;
    }

}
