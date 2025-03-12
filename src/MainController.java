import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private MenuItem marketMenuItem;

    @FXML
    private MenuItem farmMenuItem;

    @FXML
    private Button carrotBtn;

    @FXML
    private Button cornBtn;

    @FXML
    private Button wheatBtn;

    @FXML
    public void initialize() {
        marketMenuItem.setOnAction(event -> openStore());
        farmMenuItem.setOnAction(event -> openFarm());

        if (carrotBtn != null) carrotBtn.setOnMouseClicked(event -> acheterCarottes());
        if (cornBtn != null) cornBtn.setOnMouseClicked(event -> acheterMaïs());
        if (wheatBtn != null) wheatBtn.setOnMouseClicked(event -> acheterBlé());
    }

    private void acheterCarottes() {
        System.out.println("Carottes achetées !");
    }

    private void acheterMaïs() {
        System.out.println("Maïs acheté !");
    }

    private void acheterBlé() {
        System.out.println("Blé acheté !");
    }

    private void openFarm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/cultivableLand.fxml"));
            Parent farmView = loader.load();

            CultivableLand cultivableLand = loader.getController();

            contentArea.getChildren().clear();
            contentArea.getChildren().add(farmView);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading cultivableLand.fxml");
        }
    }

    private void openStore() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/store.fxml"));
            Parent storeView = loader.load();

            StoreController storeController = loader.getController();
            storeController.initBoutons();

            contentArea.getChildren().clear();
            contentArea.getChildren().add(storeView);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de store.fxml");
        }
    }
}