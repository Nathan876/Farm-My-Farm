import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Plant {
    private boolean plantingInProgress;
    public Button button;
    private Timeline growthTimeline;

    public Plant(Button button) {
        this.button = button;
        this.plantingInProgress = false;
    }

    public void planting() {
        if (!plantingInProgress) {
            plantingInProgress = true;
            button.setText("🌱");
            button.setDisable(true);

            growthTimeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> {
                collect();
                System.out.println("🌾 i m READY !!! Collect me !!!");
            }));
            growthTimeline.setCycleCount(1);
            growthTimeline.play();
        }
    }

    public void collect() {
        button.setText("🌾");
        button.setDisable(false);
    }

    public Button getButton() {
        return button;
    }
}