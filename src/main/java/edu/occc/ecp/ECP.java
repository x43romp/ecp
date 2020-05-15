import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import edu.occc.ecp.ThermoHouse;
import edu.occc.ecp.ThermoRoom;

public class ECP extends Application implements EventHandler, ChangeListener {

    // Thermo House
    private ThermoHouse house;

    // Temperature Information
    private final Spinner<Integer> targetTemp = new Spinner<Integer>();
    private final SpinnerValueFactory<Integer> targetVal = //
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 150, 70);
    private final Button targetAuto = new Button("AUTO");
    private final Button targetOff = new Button("OFF");
    private final Label targetStatus = new Label("Mode: INITIALIZE");

    // Room Information
    private ComboBox roomSelector = new ComboBox();
    private final Label roomStatus = new Label("Select a room to get information");

    private static final Color color = Color.web("#464646");
    Button button3 = new Button("Down");
    DropShadow shadow = new DropShadow();
    Label label = new Label();

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Environmental Control Program");
        stage.setWidth(150);
        stage.setHeight(200);

        // Setup House
        final String[] roomNames = new String[] { "Living Room", "Master Bedroom", "Bathroom", "Kitchen", "Guest Room",
                "Office", "Den", "Basement", "Garage", "Kid's Room" };
        final int roomCount = new Random().nextInt(7) + 3;
        final double[] roomTemps = new double[roomCount];
        final String[] rooms = new String[roomCount + 1];
        rooms[0] = "All";
        for (int i = 0; i < roomTemps.length; i++) {
            roomTemps[i] = 70 - 15 + new Random().nextDouble() * 30;
            rooms[i + 1] = roomNames[i];
        }
        house = new ThermoHouse(roomTemps);

        // Setup container
        final VBox container = new VBox();

        // Setup Temeprature Panel
        final Label targetLabel = new Label("HOUSE TEMPERATURE");
        targetTemp.setValueFactory(targetVal);
        targetTemp.valueProperty().addListener(this);

        final GridPane pane = new GridPane();
        pane.setHgap(0);
        pane.getColumnConstraints().add(new ColumnConstraints(75));
        pane.getColumnConstraints().add(new ColumnConstraints(75));

        targetAuto.setMaxWidth(Double.MAX_VALUE);
        targetOff.setMaxWidth(Double.MAX_VALUE);

        targetAuto.setOnAction(this);
        targetOff.setOnAction(this);

        pane.add(targetLabel, 0, 0, 2, 1);
        pane.add(targetTemp, 0, 1, 2, 1);
        pane.add(targetAuto, 0, 2);
        pane.add(targetOff, 1, 2);
        pane.add(targetStatus, 0, 3, 2, 1);
        container.getChildren().add(pane);

        // Setup Room View
        roomSelector = new ComboBox(FXCollections.observableArrayList(rooms));
        roomSelector.setMaxWidth(Double.MAX_VALUE);
        roomSelector.setValue("All");
        roomSelector.setOnAction(this);
        pane.add(roomSelector, 0, 4, 2, 1);
        pane.add(roomStatus, 0, 5, 2, 1);

        // Add update button
        Button next = new Button("Next Hour");
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // targetStatus.setText("tick");
                house.update();
                updateInfo();
            }
        });

        next.setMaxWidth(Double.MAX_VALUE);
        pane.add(next, 0, 6, 2, 1);

        updateToggle(true);
        updateInfo();
        house.setTemperature(targetTemp.getValue());

        scene = new Scene(container, 100, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(final Event event) {
        if (event.getSource() == roomSelector) {
            updateInfo();
        } else if (event.getSource() == targetAuto) {
            updateToggle(true);
        } else if (event.getSource() == targetOff) {
            updateToggle(false);
        } else if (event.getSource() == targetTemp) {
            house.setTemperature(targetTemp.getValue());
            targetStatus.setText(targetTemp.getValue() + " ");
        }
    }

    public void updateToggle(final boolean on) {
        targetAuto.setDisable(on);
        targetOff.setDisable(!on);
    }

    public void updateInfo() {
        int room = roomSelector.getSelectionModel().getSelectedIndex();
        double temp = 0;
        String vents = "-";
        if (room == 0) {
            final int size = house.getRooms().size();
            double total = 0;
            for (int i = 0; i < size; i++) {
                total += house.getRoom(i).getTemperature();
            }
            vents = "-";
            temp = total / size;
        } else {
            room = room - 1;
            temp = house.getRoom(room).getTemperature();
            vents = (house.getRoom(room).getStatus() == ThermoRoom.STATUS_ON) ? "On" : " Off";
        }
        roomStatus.setText(String.format("Temp: %.0f\nVents: %s", temp, vents));
        targetStatus.setText(String.format("MODE: %s", house.getMode()));



    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        house.setTemperature(this.targetTemp.getValue());
    }
}
