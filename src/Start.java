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

public class Start extends Application implements Runnable {
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
    private final int FPS = 60;

    private void initContent(GridPane pane) {
        Canvas canvas = new Canvas(screenWidth, screenHight);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Image image = new Image("/billede.jpeg");

        graphicsContext.drawImage(image, 10, 10);

        pane.add(canvas, 0,0);
    }


    @Override
    public void run() {

        int drawCount = 0;
        double drawInterval = 1000000000./FPS; // 0.016666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (true) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // 1 UPDATE: update information such as positions

                // 2 DRAW: draw the new updates on screen

                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                //FPS Counter terminal
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }
}
