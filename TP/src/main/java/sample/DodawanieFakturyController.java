package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.cell.PropertyValueFactory;


public class DodawanieFakturyController {
    private Scene scene;
    private MainController mainController;
    private ArrayList<Klient> arrayListKlienci;
    private ListView<String> listViewKlienci;
    private String nazwaKlienta;
    private Klient wybranyKlient;
    private Faktura tworzonaFaktura;

    public DodawanieFakturyController(final MainController mainController) throws IOException {
        this.mainController = mainController;
        Parent parent = FXMLLoader.load(getClass().getResource("/dodawanieFaktury.fxml"));
        tworzonaFaktura = new Faktura();
        final DodawanieUslugiController dodawanieUslugi = new DodawanieUslugiController(this, tworzonaFaktura);
        scene = new Scene(parent, 1100, 850);

        final TextField textFieldAdresFirmy = (TextField) parent.lookup("#textFieldAdresFirmy");
        final TextField textFieldNIP = (TextField) parent.lookup("#textFieldNIP");
        Button buttonPowrot = (Button) parent.lookup("#buttonPowrot");
        Button buttonZapiszFakturę = (Button) parent.lookup("#buttonZapiszFakturę");
        Button buttonDodajUsługę = (Button) parent.lookup("#buttonDodajUsługę");


        buttonDodajUsługę.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                getStage().setTitle("Dodaj usluge");
                getStage().setScene(dodawanieUslugi.getScene());
            }
        });

        buttonZapiszFakturę.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Faktura faktura = new Faktura(tworzonaFaktura);
                faktura.ustawKlienta(wybranyKlient);
                ResourceManager.getInstance().getFakturyStorage().dodajFakture(faktura);
                System.out.println(faktura.zwrocUslugi().size());
                System.out.println(faktura.zwrocKlienta().getNazwa());
                tworzonaFaktura.clear();
                textFieldAdresFirmy.clear();
                textFieldNIP.clear();
                mainController.pokazMnie();
            }
        });

        buttonPowrot.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                tworzonaFaktura.clear();
                textFieldAdresFirmy.clear();
                textFieldNIP.clear();
                mainController.pokazMnie();
            }
        });



        listViewKlienci = (ListView<String>) parent.lookup("#listViewKlienci");

        arrayListKlienci = ResourceManager.getInstance().getKlientStorage().zwrocKlientow();

        listViewKlienci.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue !=null) {
                    nazwaKlienta = newValue;
                    wybranyKlient = ResourceManager.getInstance().getKlientStorage().znajdzKlientaNazwa(nazwaKlienta);
                    textFieldAdresFirmy.setText(wybranyKlient.getAdres());
                    textFieldNIP.setText(wybranyKlient.getNip());
                }
            }
        });
    }

    public Scene getScene(){
        if(listViewKlienci.getItems() != null && !listViewKlienci.getItems().isEmpty())
            listViewKlienci.getItems().clear();
        for(Klient klient:arrayListKlienci){
            listViewKlienci.getItems().add(klient.getNazwa());
            System.out.println(klient.getNazwa());
        }

        return scene;
    }

    public Stage getStage (){
        return mainController.getStage();
    }
}
