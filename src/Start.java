import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    private int artSize = 16;
    private int scale = 3;
    private int tileSize = artSize * scale;
    private int screenWidth = tileSize * 16;
    private int screenHight = tileSize * 12;

    private void initContent(GridPane pane) {


        Canvas canvas = new Canvas(screenWidth, screenHight);

        pane.add(canvas, 0,0);

    }
}
