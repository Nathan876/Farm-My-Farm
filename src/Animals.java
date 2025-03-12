import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Animals {
    private boolean productionInProgress;
    public Button button;
    private Timeline productionTimeline;
    private String product;
    private int productionTime;
    private String foodType;
    private int foodQuantity;

    public Animals(Button button, String product, int productionTime, String foodType, int foodQuantity) {
        this.button = button;
        this.product = product;
        this.productionTime = productionTime;
        this.foodType = foodType;
        this.foodQuantity = foodQuantity;
        this.productionInProgress = false;
    }

    public void startProduction() {
        if (!productionInProgress && hasEnoughFood()) {
            consumeFood();
            productionInProgress = true;
            button.setText("🐾");
            button.setDisable(true);

            productionTimeline = new Timeline(new KeyFrame(Duration.seconds(productionTime), e -> {
                collectProduct();
                System.out.println(product + " prêt !");
            }));
            productionTimeline.setCycleCount(1);
            productionTimeline.play();
        }
    }

    private boolean hasEnoughFood() {
        return switch (foodType) {
            case "corn" -> Count.corn >= foodQuantity;
            case "wheat" -> Count.wheat >= foodQuantity;
            default -> false;
        };
    }

    private void consumeFood() {
        if (foodType.equals("corn")) Count.corn -= foodQuantity;
        if (foodType.equals("wheat")) Count.wheat -= foodQuantity;
    }

    public void collectProduct() {
        button.setText(product);
        button.setDisable(false);
        productionInProgress = false;
    }
}