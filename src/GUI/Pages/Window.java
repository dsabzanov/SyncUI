package GUI.Pages;
/**
 * Created by Mac on 3/16/16.
 * Project: Sync
 */

import GUI.Resources.Resources;
import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.String;
import java.util.HashMap;


public class Window extends Application {
    private static Stage stage;
    private static final HashMap<PAGE, Page> pageCache = new HashMap<>();
    public static final int HEIGHT = 380;
    public static final int WIDTH = 300;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Resources.getInstance();
        stage.setTitle("Sync 1.0");
        stage.setResizable(false);
        stage.setScene(new MainPage());
        stage.sizeToScene();
        stage.show();
    }

    /**
     * Changes the page currently displayed.
     * This method has an internal cache of pages which
     * allows pages to be saved with its contents intact.
     *
     * @param page The page to switch to
     */
    public static void setScene(PAGE page) {
        Page pageInstance;
        if (pageCache.containsKey(page)) {
            pageInstance = pageCache.get(page);
        } else
            switch (page) { // Please see PAGE enum for details
                case CREATEGROUP:
                    pageInstance = new CreateGroupPage();
                    pageCache.put(PAGE.CREATEGROUP, pageInstance);
                    break;
                case CREATEPLAYLIST:
                    pageInstance = new CreatePlaylistPage();
                    pageCache.put(PAGE.CREATEPLAYLIST, pageInstance);
                    break;
                case HOSTLIST:
                    pageInstance = new HostListPage();
                    pageCache.put(PAGE.HOSTLIST, pageInstance);
                    break;
                case MAIN:
                    pageInstance = new MainPage();
                    pageCache.put(PAGE.MAIN, pageInstance);
                    break;
                case OPTIONS:
                    pageInstance = new OptionsPage();
                    pageCache.put(PAGE.OPTIONS, pageInstance);
                    break;
                case PLAYER:
                    pageInstance = new PlayerPage();
                    pageCache.put(PAGE.PLAYER, pageInstance);
                    break;
                case SEARCHPROGRESS:
                    pageInstance = new SearchProgressPage();
                    pageCache.put(PAGE.SEARCHPROGRESS, pageInstance);
                    break;
                default:
                    pageInstance = new MainPage();
                    pageCache.put(PAGE.MAIN, pageInstance);
            }
        stage.setScene(pageInstance);
    }

    /**
     * Contains a list of pages that the Window caches and displays.
     * If a new page is created, one must add the page to the enum and
     * add the page to the {@link #setScene(PAGE)} switch statement.
     * <p>
     * If one wishes for the pages content to be thrown away, simply do not add
     * the pageInstance into the pageCache within the switch statement.
     */
    enum PAGE {
        CREATEGROUP, CREATEPLAYLIST, HOSTLIST, MAIN, OPTIONS, PLAYER, SEARCHPROGRESS
    }
}

