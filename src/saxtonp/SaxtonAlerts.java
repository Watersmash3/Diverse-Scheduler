package saxtonp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class SaxtonAlerts {
    /**
     * This method creates an alert that only stays open for a specified amount of time with a
     * given title, content, and a time.
     * @param title     - A passed in Title
     * @param content   - The passed in content text
     * @param time      - The passed in time spent open.
     */
    public static void createTimedAlert(String title, String content, Double time) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.show();

        // Specifies the timeline in which the alert will stay open
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(time),
                ae -> alert.hide()));
        timeline.play();
    }

    /**
     * This method creates an alert with a specified title and content.
     * @param title     - A passed in title
     * @param content   - A passed in content text
     */
    public static void createAlert(String title, String content) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
