import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CultivableLand {

    @FXML private GridPane gridPane;
    @FXML private ComboBox<String> seedComboBox;
    @FXML private Label selectedSeedLabel;

    @FXML private Label wheatLabel;
    @FXML private Label cornLabel;
    @FXML private Label carrotsLabel;
    @FXML private Label chickensLabel;
    @FXML private Label cowsLabel;
    @FXML private Label sheepLabel;
    @FXML private Label milkLabel;
    @FXML private Label eggsLabel;
    @FXML private Label woolLabel;
    @FXML private Label moneyLabel;

    private String selectedSeed = "Blé";

    public void initialize() {
        setupComboBox();
        setupGrid();
        updateStockLabels();
    }

    private void setupComboBox() {
        seedComboBox.setItems(FXCollections.observableArrayList("Blé", "Maïs", "Carotte", "Vache", "Mouton", "Poule"));

        seedComboBox.setOnAction(event -> {
            selectedSeed = seedComboBox.getValue();
            selectedSeedLabel.setText("Sélectionné : " + selectedSeed);
        });

        seedComboBox.getSelectionModel().selectFirst();
        selectedSeedLabel.setText("Sélectionné : " + selectedSeed);
    }

    private void setupGrid() {
        int rows = Count.row;
        int columns = Count.col;
        Object[][] farm = new Object[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Button button = new Button("🆓");
                GridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
                GridPane.setValignment(button, javafx.geometry.VPos.CENTER);
                gridPane.setAlignment(Pos.CENTER);

                final int finalRow = row;
                final int finalCol = col;

                button.setOnMouseClicked(event -> {
                    String buttonText = button.getText();

                    if (buttonText.equals("🆓")) {
                        boolean canPlace = false;

                        if (selectedSeed.equals("Blé") && Count.wheat > 0) {
                            Count.wheat--;
                            farm[finalRow][finalCol] = new Wheat(button);
                            canPlace = true;
                        } else if (selectedSeed.equals("Maïs") && Count.corn > 0) {
                            Count.corn--;
                            farm[finalRow][finalCol] = new Corn(button);
                            canPlace = true;
                        } else if (selectedSeed.equals("Carotte") && Count.carrots > 0) {
                            Count.carrots--;
                            farm[finalRow][finalCol] = new Carrot(button);
                            canPlace = true;
                        }

                        else if (selectedSeed.equals("Vache") && Count.cows > 0 && Count.wheat > 0) {
                            Count.cows--;
                            Count.wheat--;
                            farm[finalRow][finalCol] = new Cow(button);
                            canPlace = true;
                        } else if (selectedSeed.equals("Mouton") && Count.sheep > 0 && Count.wheat > 0) {
                            Count.sheep--;
                            Count.wheat--;
                            farm[finalRow][finalCol] = new Sheep(button);
                            canPlace = true;
                        } else if (selectedSeed.equals("Poule")) {
                            if (Count.chickens > 0 && Count.corn > 0) {
                                Count.chickens--;
                                Count.corn--;
                                farm[finalRow][finalCol] = new Chicken(button);
                                canPlace = true;
                            } else {
                                System.out.println("⚠️ Pas assez de maïs ou de poules !");
                            }
                        }

                        if (canPlace) {
                            if (farm[finalRow][finalCol] instanceof Plant) {
                                ((Plant) farm[finalRow][finalCol]).planting();
                            } else if (farm[finalRow][finalCol] instanceof Animals) {
                                ((Animals) farm[finalRow][finalCol]).startProduction();
                                button.setText(getAnimalEmoji(selectedSeed));
                            }
                        }
                    }

                    else {
                        if (buttonText.contains("🌾")) {
                            Count.wheat += 2;
                        } else if (buttonText.contains("🌽")) {
                            Count.corn += 2;
                        } else if (buttonText.contains("🥕")) {
                            Count.carrots += 2;
                        } else if (buttonText.contains("🥛") && Count.wheat > 0) {
                            Count.wheat--;
                            Count.milk++;
                            Count.cows++;
                        } else if (buttonText.contains("🥚")) {
                            if (Count.corn > 0) {
                                Count.corn--;
                                Count.eggs++;
                                Count.chickens++;
                            } else {
                                System.out.println("⚠️ Pas assez de maïs pour nourrir la poule !");
                            }
                        } else if (buttonText.contains("🧶") && Count.wheat > 0) {
                            Count.wheat--;
                            Count.wool++;
                            Count.sheep++;
                        }
                        button.setText("🆓");
                    }

                    updateStockLabels();
                });

                gridPane.add(button, col, row);
            }
        }
    }

    private void updateStockLabels() {
        wheatLabel.setText(String.valueOf(Count.wheat));
        cornLabel.setText(String.valueOf(Count.corn));
        carrotsLabel.setText(String.valueOf(Count.carrots));
        chickensLabel.setText(String.valueOf(Count.chickens));
        cowsLabel.setText(String.valueOf(Count.cows));
        sheepLabel.setText(String.valueOf(Count.sheep));
        milkLabel.setText(String.valueOf(Count.milk));
        eggsLabel.setText(String.valueOf(Count.eggs));
        woolLabel.setText(String.valueOf(Count.wool));
        moneyLabel.setText(String.valueOf(Count.money));
    }

    private String getAnimalEmoji(String animal) {
        return switch (animal) {
            case "Vache" -> "🐄";
            case "Mouton" -> "🐑";
            case "Poule" -> "🐔";
            default -> "❓";
        };
    }
}