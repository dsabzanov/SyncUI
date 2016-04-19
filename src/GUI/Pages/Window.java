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
        } else {
            switch (page) { // Please see PAGE enum for details
                case CREATE_GROUP:
                    pageInstance = new CreateGroupPage();
                    break;
                case CREATE_PLAYLIST:
                    pageInstance = new CreatePlaylistPage();
                    break;
                case HOSTLIST:
                    pageInstance = new HostListPage();
                    break;
                case MAIN:
                    pageInstance = new MainPage();
                    break;
                case OPTIONS:
                    pageInstance = new OptionsPage();
                    break;
                case SERVER_PLAYER:
                    pageInstance = new PlayerPage(true);
                    break;
                case CLIENT_PLAYER:
                    pageInstance = new PlayerPage(false);
                    break;
                case SEARCH_PROGRESS:
                    pageInstance = new SearchProgressPage();
                    break;
                case SEARCH_PROGRESSV2:
                    pageInstance = new SearchProgressPageV2();
                    break;
                default:
                    pageInstance = new MainPage();
            }
            if (!page.equals(PAGE.SEARCH_PROGRESS) &&
                    !page.equals(PAGE.CLIENT_PLAYER) &&
                    !page.equals(PAGE.SERVER_PLAYER)) // Dont cache Search progress
                pageCache.put(page, pageInstance);
        }
        stage.setScene(pageInstance);
    }

    /**
     * Contains a list of pages that the Window caches and displays.
     * If a new page is created, one must add the page to the enum and
     * add the page to the {@link #setScene(PAGE)} switch statement.
     * <p>
     * If one wishes for the pages content to be thrown away, simply add the page
     * to the if statement at the end of the switch block.
     */
    enum PAGE {
        CREATE_GROUP, CREATE_PLAYLIST, HOSTLIST, MAIN, OPTIONS, SERVER_PLAYER, CLIENT_PLAYER, SEARCH_PROGRESS, SEARCH_PROGRESSV2
    }
}

