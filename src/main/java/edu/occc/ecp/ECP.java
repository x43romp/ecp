import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class ECP extends Application {

    private static final Color color = Color.web("#464646");
    Button button3 = new Button("Down");
    DropShadow shadow = new DropShadow();
    Label label = new Label();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Environmental Control Program");
        stage.setWidth(500);
        stage.setHeight(500);

        label.setFont(Font.font("Times New Roman", 22));
        label.setTextFill(color);

       // Image imageDecline = new Image(getClass().getResourceAsStream("not.png"));
       // Image imageAccept = new Image(getClass().getResourceAsStream("ok.png"));

        VBox vbox = new VBox();
        vbox.setLayoutX(20);
        vbox.setLayoutY(20);
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();

        //Button button2 = new Button("Accept", new ImageView(imageAccept));
        Button button1 = new Button();
        button1.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                label.setText("Accepted");
            }
        });


        Button button2 = new Button("Up");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                label.setText("Temperature is going up");
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                 label.setText("Temperature is going down");
            }
        });

        button3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button3.setEffect(shadow);
            }
        });

        button3.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                button3.setEffect(null);
            }
        });


        hbox1.getChildren().add(button2);
        hbox1.getChildren().add(button3);
        hbox1.getChildren().add(label);
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.BOTTOM_CENTER);

        Button button4 = new Button("On");
   //     button4.setGraphic(new ImageView(imageAccept));
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                label.setText("Thermostat On");
            }
        });


        Button button5 = new Button("Off");
     //   button5.setGraphic(new ImageView(imageDecline));
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                label.setText("Thermostat Off");
            }
        });

        hbox2.getChildren().add(button4);
        hbox2.getChildren().add(button5);
        hbox2.setSpacing(25);

        vbox.getChildren().add(button1);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.setSpacing(10);
        ((Group)scene.getRoot()).getChildren().add(vbox);

        stage.setScene(scene);
        stage.show();
    }
}

    
    
    /* 		
    Button buttonDown = new Button("Down");
    Button buttonDesiredTemp = new Button("Desired Temperature");
    Button buttonActualTemp = new Button("Actual Temperature");
    Button buttonOn = new Button("On");
    Button buttonOff = new Button("Off");
    Button buttonNextRoom = new Button ("Next Room");
    Button buttonLastRoom = new Button ("Last Room");
    
    
    try {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(buttonUp, 400, 400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
    primaryStage.setTitle("Environmental Control Program");
    

    

}

}

*/