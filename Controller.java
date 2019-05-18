package sample;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.scene.canvas.Canvas;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {

    // Context Menu po kliknięciu prawym przyciskiem myszy na obrazek
    ContextMenu context = new ContextMenu();
    MenuItem Item1 = new MenuItem("addLayer");
    MenuItem Item2 = new MenuItem("moveUp");
    MenuItem Item3 = new MenuItem("moveDown");
    MenuItem Item4 = new MenuItem("deleteLayer");
    MenuItem Item5 = new MenuItem("chooseLayer");

    // Nie wiem na razie do czego to jest ale Dawid miał to też dodałam
    @FXML
    private Canvas canvas;

    @FXML
    private MenuItem open;

    @FXML
    private MenuItem save;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem rotate;

    @FXML
    private MenuItem crop;

    @FXML
    private MenuItem scale;

    @FXML
    private MenuItem newLayer;

    @FXML
    private MenuItem perspective;

    @FXML
    private MenuItem freeDraw;

    @FXML
    private MenuItem rubber;

    @FXML
    private MenuItem drawFigure;

    @FXML
    private MenuItem text;

    @FXML
    private MenuItem colorIntensity;

    @FXML
    private MenuItem transparency;

    @FXML
    private MenuItem sepia;

    @FXML
    private MenuItem blackWhite;

    @FXML
    private ImageView background;

    @FXML
    public TextField value;

    // do dodawania tekstu
    @FXML
    void addText(ActionEvent event) {

    }

    // Zamyka program
    @FXML
    void closeFile(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void cropFunction(ActionEvent event) {

    }

    @FXML
    void drawFigureFunction(ActionEvent event) {

    }

    @FXML
    void freeDrawFunction(ActionEvent event) {

    }

    @FXML
    void moveToNewLayer(ActionEvent event) {

    }


    // otwiera plik
    @FXML
    void openFile(ActionEvent event) {      // GOTOWE

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG =
                new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg =
                new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG =
                new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng =
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            background.setImage(image);
        } catch (IOException ex) {
            //Logger.getLogger(JavaFxPixel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void perspectiveFunction(ActionEvent event) {

    }

    @FXML
    void rotateFunction(ActionEvent event) {

    }

    @FXML
    void rubberFunction(ActionEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {

    }

    @FXML
    void scaleFunction(ActionEvent event) {

    }

    @FXML
    void sepiaFunction(ActionEvent event) {

    }

    @FXML
    void setBlackWhite(ActionEvent event) {

    }

    // To jest cos przykladowego co znalazlam. I tak trzeba to zmienic i dac do klasy.
    @FXML
    void setColorIntensity(ActionEvent event) {
        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.0);
        lighting.setSpecularExponent(0.0);
        lighting.setSurfaceScale(0.0);
        lighting.setLight(new Light.Distant(45, 45, Color.GREEN));

        background.setEffect(lighting);
    }

    @FXML
    void setTransparency(ActionEvent event) {

    }


    // menu z warstwami
    @FXML
    void showContextMenu(MouseEvent event) {

        context.getItems().addAll(Item1,Item2,Item3,Item4,Item5);
        background.setOnContextMenuRequested(e -> { context.setY(event.getScreenY());
        context.setX(event.getScreenX());
        context.show(background.getScene().getWindow()); });

        // addLayer()
        Item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        // moveUpLayer()        // Tutaj jest przykład użycia klasy add tak żeby to zadzialalo. Po kliknięciu w
        Item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                add Dodaj = new add();
                String a = Dodaj.dodawanie("kot","pies");
                value.setText(a);
            }
        });

        // moveDownLayer()
        Item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        // deleteLayer()
        Item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        // chooseLayer()
        Item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }



}
