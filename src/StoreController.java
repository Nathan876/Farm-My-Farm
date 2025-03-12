import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.Random;

public class StoreController {

    @FXML
    private Button carrotBtn;

    @FXML
    private Button cornBtn;

    @FXML
    private Button wheatBtn;

    @FXML
    private Button sellWheat;

    @FXML
    private Button sellCorn;

    @FXML
    private Button sellCarrot;

    @FXML
    private Button sellWool;

    @FXML
    private Button sellMilk;

    @FXML
    private Button sellEggs;

    @FXML
    private Button buyChicken;

    @FXML
    private Button buyCow;

    @FXML
    private Label cowInventory;

    @FXML private Label carrotInventory;

    @FXML private Label cornInventory;
    @FXML private Label wheatInventory;

    @FXML private Label chickenInventory;
    @FXML private Label chickenSellLabel;
    @FXML private Label cowSellLabel;
    @FXML private Label sheepSellLabel;
    @FXML private Label sheepInventory;
    @FXML private Label milkInventory;
    @FXML private Label eggInventory;
    @FXML private Label woolInventory;
    @FXML private Button sellChicken;
    @FXML private Button sellCow;
    @FXML private Button sellSheep;
    @FXML private Button plantationParc;


    @FXML
    private Button buySheep;
    @FXML private Label carrotLabel;
    @FXML private Label cornLabel;
    @FXML private Label wheatLabel;
    @FXML private Label sheepLabel;
    @FXML private Label cowLabel;
    @FXML private Label chickenLabel;
    @FXML private Label milkSellLabel;
    @FXML private Label woolSellLabel;
    @FXML private Label eggSellLabel;
    @FXML private Label moneyLabel;
    @FXML private Label wheatSellLabel;
    @FXML private Label cornSellLabel;
    @FXML private Label carrotSellLabel;

    private Random random = new Random();



    @FXML
    public void initialize() {
        updatePrices();
        if (carrotBtn != null) carrotBtn.setOnMouseClicked(event -> buyCarrots());
        if (cornBtn != null) cornBtn.setOnMouseClicked(event -> buyCorn());
        if (wheatBtn != null) wheatBtn.setOnMouseClicked(event -> buyWheat());
        if (sellWheat != null) {
            sellWheat.setOnMouseClicked(event -> {
                    sellWheat();
            });
        }

        if (buyChicken != null) {
            buyChicken.setOnMouseClicked(event -> {
                buyChicken();
            });
        }

        if (buyCow != null) {
            buyCow.setOnMouseClicked(event -> {
                buyCow();
            });
        }

        if (buySheep != null) {
            buySheep.setOnMouseClicked(event -> {
                buySheep();
            });
        }

        if (sellCorn != null) {
            sellCorn.setOnMouseClicked(event -> {
                sellCorn();
            });
        }

        if (sellCarrot != null) {
            sellCarrot.setOnMouseClicked(event -> {
                sellCarrot();
            });
        }

        if (sellWool != null) {
            sellWool.setOnMouseClicked(event -> {
                sellWool();
            });
        }

        if (sellMilk != null) {
            sellMilk.setOnMouseClicked(event -> {
                sellMilk();
            });
        }

        if (sellEggs != null) {
            sellEggs.setOnMouseClicked(event -> {
                sellEggs();
            });
        }

        if (sellChicken !=null) {
            sellChicken.setOnMouseClicked(event -> {
                sellChicken();
            });
        };

        if (plantationParc != null) {
            plantationParc.setOnMouseClicked(event -> {
                if (Count.money >= 500) {
                    Count.money -= 500;
                    Count.row = 10;
                    Count.col = 10;
                    updatePrices();
                    plantationParc.setDisable(true);
                    Count.isExpand = true;
                }
            });
        }

        if (sellCow != null) {
            sellCow.setOnMouseClicked(event -> {
                sellCow();
            });
        };
        if (sellSheep != null) {
            sellSheep.setOnMouseClicked(event -> {
                sellSheep();
            });
        }
    }

    private void updatePrices() {
        if (Count.isExpand) {
            plantationParc.setDisable(true);
        }
        Prices.carrotPrice = getRandomPrice();
        carrotLabel.setText("Prix: " + Prices.carrotPrice);
        Prices.cornPrice = getRandomPrice();
        cornLabel.setText("Prix: " + Prices.cornPrice);
        Prices.wheatPrice = getRandomPrice();
        wheatLabel.setText("Prix: " + Prices.wheatPrice);
        Prices.sheepPrice = getRandomPrice();
        sheepLabel.setText("Prix: " + Prices.sheepPrice);
        Prices.cowPrice = getRandomPrice();
        cowLabel.setText("Prix: " + Prices.cowPrice);
        Prices.chickenPrice = getRandomPrice();
        chickenLabel.setText("Prix: " + Prices.chickenPrice);
        Prices.milkPrice = getRandomPrice();
        milkSellLabel.setText("Prix: " + Prices.milkPrice);
        Prices.woolPrice = getRandomPrice();
        woolSellLabel.setText("Prix: " + Prices.woolPrice);
        Prices.eggsPrice = getRandomPrice();
        moneyLabel.setText("Argent : " + Count.money);
        eggSellLabel.setText("Prix: " + Prices.eggsPrice);
        chickenInventory.setText(String.valueOf("Poules : " + Count.chickens));
        cowInventory.setText(String.valueOf("Vaches : " + Count.cows));
        chickenSellLabel.setText(String.valueOf("Prix: " + Prices.chickenSellPrice));
        cowSellLabel.setText(String.valueOf("Prix : " + Prices.cowSellPrice));
        sheepSellLabel.setText(String.valueOf("Prix: " + Prices.sheepSellPrice));
        sheepInventory.setText(String.valueOf("Moutons : " + Count.sheep));
        carrotInventory.setText(String.valueOf("Carottes : " + Count.carrots));
        wheatInventory.setText(String.valueOf("Blé : " + Count.wheat));
        Prices.cowSellPrice = getRandomPrice();
        cowSellLabel.setText("Prix: " + Prices.cowSellPrice);
        Prices.chickenSellPrice = getRandomPrice();
        chickenSellLabel.setText("Prix: " + Prices.chickenSellPrice);
        Prices.sheepSellPrice = getRandomPrice();
        sheepSellLabel.setText("Prix: " + Prices.sheepSellPrice);
        cornInventory.setText(String.valueOf("Maïs : " + Count.corn));
        milkInventory.setText(String.valueOf("Lait : " + Count.milk));
        eggInventory.setText(String.valueOf("Oeufs : " + Count.eggs));
        woolInventory.setText(String.valueOf("Laine : " + Count.wool));
        Prices.wheatSellPrice = getRandomPrice();
        wheatSellLabel.setText(String.valueOf("Prix: " + Prices.wheatSellPrice));
        Prices.cornSellPrice = getRandomPrice();
        cornSellLabel.setText("Prix: " + Prices.cornSellPrice);
        Prices.carrotSellPrice = getRandomPrice();
        carrotSellLabel.setText("Prix: " + Prices.carrotSellPrice);
    }

    private int getRandomPrice() {
        return 10 + random.nextInt(50);
    }
    private void sellEggs() {
        if (Count.eggs > 0) {
            Count.eggs = Count.eggs - 1;
            Count.money = Count.money + Prices.eggsPrice;
            updatePrices();
        }
    }

    private void sellChicken() {
        if (Count.chickens > 0) {
            Count.chickens = Count.chickens - 1;
            Count.money = Count.money + Prices.chickenSellPrice;
            updatePrices();
        }
    }

    private void sellCow() {
        if (Count.cows > 0) {
            Count.cows = Count.cows - 1;
            Count.money = Count.money + Prices.cowSellPrice;
            updatePrices();
        }
    }

    private void sellSheep() {
        if (Count.sheep > 0) {
            Count.sheep = Count.sheep - 1;
            Count.money = Count.money + Prices.sheepSellPrice;
            updatePrices();
        }
    }

    private void sellMilk() {
        if (Count.milk > 0) {
            Count.milk = Count.milk - 1;
            Count.money = Count.money + Prices.milkPrice;
            updatePrices();
        };
    }

    private void sellWool() {
        if (Count.wool > 0) {
            Count.wool = Count.wool - 1;
            Count.money = Count.money + Prices.woolPrice;
            updatePrices();
        };
    }

    private void buyCarrots() {
        if (Count.carrots > 0 && Count.money >= Prices.carrotPrice) {
            Count.carrots = Count.carrots + 1;
            Count.money = Count.money - Prices.carrotPrice;
            updatePrices();
        };
    }

    private void sellWheat() {
        if (Count.wheat > 0) {
            Count.wheat = Count.wheat - 1;
            Count.money = Count.money + Prices.wheatSellPrice;
            updatePrices();
        }
    }

    private void sellCorn() {
        if (Count.corn > 0) {
            Count.corn = Count.corn - 1;
            Count.money = Count.money + Prices.cornSellPrice;
            updatePrices();
        }
    }

    private void sellCarrot() {
        if (Count.carrots > 0) {
            Count.carrots = Count.carrots - 1;
            Count.money = Count.money + Prices.carrotSellPrice;
            updatePrices();
        }
    }

    private void buyCorn() {
        if (Count.money >= Prices.cornPrice) {
            Count.corn = Count.corn + 1;
            Count.money = Count.money - Prices.cornPrice;
            updatePrices();
        }
    }

    private void buyWheat() {
        if (Count.money > Prices.wheatPrice) {
            Count.wheat = Count.wheat + 1;
            Count.money = Count.money - Prices.wheatPrice;
            updatePrices();
        }
    }

    public void buyChicken() {
        if (Count.chickens > 0 && Count.money >= Prices.chickenPrice) {
            Count.chickens = Count.chickens + 1;
            Count.money = Count.money - Prices.chickenPrice;
            updatePrices();
        }
    }

    public void buyCow() {
        if (Count.cows > 0 && Count.money >= Prices.cowPrice) {
            Count.cows = Count.cows + 1;
            Count.money = Count.money - Prices.cowPrice;
            updatePrices();
        }
    }

    public void buySheep() {
        if (Count.sheep > 0 && Count.money >= Prices.sheepPrice) {
            Count.sheep = Count.sheep + 1;
            Count.money = Count.money - Prices.sheepPrice;
            updatePrices();
        }
    }

    public void initBoutons() {
        initialize();
    }
}