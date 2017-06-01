package UI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 пробуем рисовать поле для крестиков и ноликов
 */
public class Ui extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ArrayList<Button> buttonList = new ArrayList<>(9);
        Image imageX = new Image(getClass().getResourceAsStream("X.png"));
        Image imageO = new Image(getClass().getResourceAsStream("O.png"));

        for (int i = 0; i < 9; i++) {
            buttonList.add(new Button());
            buttonList.get(i).setPrefSize(imageX.getWidth(),imageX.getHeight());

            int finalI = i;
            buttonList.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                 if(event.getButton()== MouseButton.PRIMARY)  buttonList.get(finalI).setGraphic(new ImageView(imageX));
                 if(event.getButton()== MouseButton.SECONDARY)  buttonList.get(finalI).setGraphic(new ImageView(imageO));
                }
            });
        }

        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setPadding(new Insets(0,10,0,10));
        int i=0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++,i++) {

                gridPane.add(buttonList.get(i),y,x);
            }
        }

        Group group = new Group(gridPane);

        Scene scene= new Scene(group, 330,330, Color.WHITE);
        primaryStage.setTitle("Пробуем рисовать крестики нолики");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


