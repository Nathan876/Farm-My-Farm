import javafx.scene.control.Button;

public class Corn extends Plant {

    public Corn(Button button) {
        super(button);
    }

    @Override
    public void planting() {
        super.planting();
        System.out.println("Plantation de maïs en cours... 🌽");
    }

    @Override
    public void collect() {
        super.collect();
        System.out.println("Maïs récolté ! 🌽");
        button.setText("🌽");
    }
}