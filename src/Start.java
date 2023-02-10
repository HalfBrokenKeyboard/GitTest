import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Start extends Application {
    public void start(Stage stage) {
        stage.setTitle("Spil");
        stage.setResizable(false);

        GridPane pane = new GridPane();

        initContent(pane);

        Scene scene = new Scene(pane);

        stage.setScene(scene);

        stage.show();
    }

    private final int artSize = 16;
    private final int scale = 3;
    private final int tileSize = artSize * scale;
    private final int screenWidth = tileSize * 16;
    private final int screenHight = tileSize * 12;

    private void initContent(GridPane pane) {
        Canvas canvas = new Canvas(screenWidth, screenHight);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Image image = new Image("/billede.jpeg");

        graphicsContext.drawImage(image, 0, 0);

        graphicsContext.drawImage(new Image("/deez.jpg"), 0, 0 );



        pane.add(canvas, 0,0);
    }
}
