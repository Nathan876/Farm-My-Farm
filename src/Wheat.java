import javafx.scene.control.Button;

public class Wheat extends Plant {

    public Wheat(Button button) {
        super(button);
    }

    @Override
    public void planting() {
        super.planting();
        System.out.println("Plantation de blé en cours... 🌱");
    }

    @Override
    public void collect() {
        super.collect();
        System.out.println("Blé récolté ! 🌾");
        button.setText("🌾");
    }
}