package GUI.DataWrappers;

/**
 * Created by davidsabzanov on 4/14/16.
 */
public class HostWrapper {

    private String hostName;

    public HostWrapper() {
        this.hostName = "";
    }

    public HostWrapper(String hostName) {
        this.hostName = hostName;
    }


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
