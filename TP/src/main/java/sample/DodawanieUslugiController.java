package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class DodawanieUslugiController {

    private Parent parent;
    private Stage stage;
    private Scene scene;
    private final DodawanieFakturyController dodawanieFakturyController;


    public DodawanieUslugiController(final DodawanieFakturyController dodawanieFakturyController, final Faktura faktura) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("/dodanieUslugi.fxml"));
        scene = new Scene(parent, 1100, 850);
        this.dodawanieFakturyController = dodawanieFakturyController;
        final TextField textFieldUsluga = (TextField) parent.lookup("#textFieldUsluga");
        final TextField textFieldWartoscNettoUslugi = (TextField) parent.lookup("#textFieldWartoscNettoUslugi");
        final TextField textFieldIloscUslug = (TextField) parent.lookup("#textFieldIloscUslug");
        final TextField textFieldProcentPodatku = (TextField) parent.lookup("#textFieldProcentPodatku");
        Button buttonDodajKolejnaUsluge = (Button) parent.lookup("#buttonDodajKolejnaUsluge");
        Button buttonZapisz = (Button) parent.lookup("#buttonZapisz");
        this.stage = dodawanieFakturyController.getStage();


        buttonDodajKolejnaUsluge.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String nazwaUslugi = textFieldUsluga.getText();
                Double cenaUslugi = Double.parseDouble(textFieldWartoscNettoUslugi.getText());
                int iloscUslugi = Integer.parseInt(textFieldIloscUslug.getText());
                double procentPodatku = Double.parseDouble(textFieldProcentPodatku.getText());
                Usluga usluga = new Usluga(nazwaUslugi, cenaUslugi, iloscUslugi, procentPodatku);
                faktura.dodajUsluge(usluga);

                textFieldUsluga.clear();
                textFieldWartoscNettoUslugi.clear();
                textFieldIloscUslug.clear();
                textFieldProcentPodatku.clear();
            }
        });

        buttonZapisz.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String nazwaUslugi = textFieldUsluga.getText();
                Double cenaUslugi = Double.parseDouble(textFieldWartoscNettoUslugi.getText());
                int iloscUslugi = Integer.parseInt(textFieldIloscUslug.getText());
                double procentPodatku = Double.parseDouble(textFieldProcentPodatku.getText());
                Usluga usluga = new Usluga(nazwaUslugi, cenaUslugi, iloscUslugi, procentPodatku);
                faktura.dodajUsluge(usluga);

                textFieldUsluga.clear();
                textFieldWartoscNettoUslugi.clear();
                textFieldIloscUslug.clear();
                textFieldProcentPodatku.clear();

                stage.setTitle("Dodawanie faktury");
                stage.setScene(dodawanieFakturyController.getScene());
            }
        });


    }

    public Scene getScene() {return scene;}
}