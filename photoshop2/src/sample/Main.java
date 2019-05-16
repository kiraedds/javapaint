package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.image.BufferedImage;
import javafx.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Main extends Application {
    ImageView myImageView;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Display image :)");

        myImageView = new ImageView();

        final javafx.scene.control.Button oB = new javafx.scene.control.Button("load");

        oB.setOnAction(btnLoadEventListener);
        VBox rootBox = new VBox();
        rootBox.getChildren().addAll(oB, myImageView);
        Scene scene = new Scene(rootBox,300,300);

        Canvas c = new Canvas();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("hello there");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

    EventHandler<ActionEvent> btnLoadEventListener = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
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

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                myImageView.setImage(image);
            } catch (IOException ex) {
                //Logger.getLogger(JavaFxPixel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
}
