import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class FarmController {

    @FXML
    private AnchorPane farmContent;

    private CultivableLand cultivableLandController;

    @FXML
    public void initialize() {
        loadFarmView();
    }

    private void loadFarmView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/cultivableLand.fxml"));
            Parent farmView = loader.load();

            cultivableLandController = loader.getController();

            farmContent.getChildren().clear();
            farmContent.getChildren().add(farmView);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de la ferme !");
        }
    }
}