package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController extends Application {

    private Scene scene;
    private Stage stage;
    private ILoader loader;


    @Override
    public void start(final Stage primaryStage) throws Exception{

        loader = new MockingLoader();
        loader.load();
        stage = primaryStage;
        final Parent parentMainMenu = FXMLLoader.load(getClass().getResource("/mainMenu.fxml"));
        final Parent parentDodajKlienta = FXMLLoader.load(getClass().getResource("/dodawanieKlienta.fxml"));


        final DodawanieKlientaController dodawanieKlienta = new DodawanieKlientaController(this);
        final DodawanieFakturyController dodawanieFaktury = new DodawanieFakturyController( this);
        final WyswietlanieFakturyController wyswietlanieFaktury = new WyswietlanieFakturyController(this);

        scene = new Scene(parentMainMenu, 1100, 850);
        pokazMnie();
        primaryStage.show();

        Button buttonStworzNowaFakture = (Button) ( parentMainMenu.lookup("#buttonStworzNowaFakture"));
        Button buttonStworzNowegoKlienta = (Button) ( parentMainMenu.lookup("#buttonStworzNowegoKlienta"));
        Button buttonWyswietlFaktury = (Button) ( parentMainMenu.lookup("#buttonWyswietlFaktury"));

        buttonStworzNowaFakture.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Dodawanie faktury");
                primaryStage.setScene(dodawanieFaktury.getScene());
            }
        });

        buttonStworzNowegoKlienta.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Dodawanie klienta");
                primaryStage.setScene(dodawanieKlienta.getScene());
            }
        });

        buttonWyswietlFaktury.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Wyświetl faktury");
                primaryStage.setScene(wyswietlanieFaktury.getScene());
            }
        });

    }

    public void pokazMnie(){
        stage.setTitle("Menu główne");
        stage.setScene(scene);
    }

    public Stage getStage() { return stage;}


    public static void main(String[] args) {
        launch(args);
    }
}
