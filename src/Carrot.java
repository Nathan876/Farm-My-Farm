import javafx.scene.control.Button;

public class Carrot extends Plant {

    public Carrot(Button button) {
        super(button);
    }

    @Override
    public void planting() {
        super.planting();
        System.out.println("Plantation de carottes en cours... 🥕");
    }

    @Override
    public void collect() {
        super.collect();
        System.out.println("Carottes récoltées ! 🥕");
        button.setText("🥕");
    }
}