package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DodawanieKlientaController {
    private final Scene scene;

    public DodawanieKlientaController(final MainController mainController) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/dodawanieKlienta.fxml"));
        scene = new Scene(parent, 1100, 850);
        final TextField textFieldNazwaKlienta = (TextField) parent.lookup("#textFieldNazwaKlienta");
        final TextField textFieldAdresKlienta = (TextField) parent.lookup("#textFieldAdresKlienta");
        final TextField textFieldNIPKlienta = (TextField) parent.lookup("#textFieldNIPKlienta");

        Button buttonDodajKlienta = (Button) parent.lookup("#buttonDodajKlienta");
        Button buttonPowrot = (Button) parent.lookup("#buttonPowrot");

        buttonDodajKlienta.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String nazwa = textFieldNazwaKlienta.getText();
                String adres = textFieldAdresKlienta.getText();
                String nip   = textFieldNIPKlienta.getText();
                Klient klient = new Klient(nazwa, adres, nip);

                textFieldNazwaKlienta.clear();
                textFieldAdresKlienta.clear();
                textFieldNIPKlienta.clear();

                ResourceManager.getInstance().getKlientStorage().dodajKlienta(klient);

                mainController.pokazMnie();
            }
        });

        buttonPowrot.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textFieldNazwaKlienta.clear();
                textFieldAdresKlienta.clear();
                textFieldNIPKlienta.clear();

                mainController.pokazMnie();
            }
        });
    }

    public Scene getScene(){
        return scene;
    }
}
