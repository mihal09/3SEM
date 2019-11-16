package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

class WyswietlanieFakturyController {
    private final Scene scene;
    private TableView<Usluga> tableViewFaktury;
    private ArrayList<Klient> arrayListKlienci;
    private ListView<String> listViewKlienci;
    private String nazwaKlienta;
    private ArrayList<Faktura> wybraneFaktury;
    private ListView<Integer> listViewNumeryFaktur;

    public WyswietlanieFakturyController(final MainController mainController) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/wyswietlanieFaktury.fxml"));
        scene = new Scene(parent, 1100, 850);
        final ObliczCeneFaktury obliczCeneFaktury = new ObliczCeneFaktury();
        tableViewFaktury = (TableView<Usluga>) parent.lookup("#tableViewFaktury");
        TableColumn<Usluga, String> name = new TableColumn<Usluga, String>("Nazwa");
        TableColumn<Usluga, Integer> liczba = new TableColumn<Usluga, Integer>("Liczba");
        TableColumn<Usluga, Double> netto = new TableColumn<Usluga, Double>("Netto");
        TableColumn<Usluga, Double> vat = new TableColumn<Usluga, Double>("VAT");
        TableColumn<Usluga, Double> brutto = new TableColumn<Usluga, Double>("Brutto");

        name.setCellValueFactory(new PropertyValueFactory<Usluga,String>("nazwaUslugi"));
        liczba.setCellValueFactory(new PropertyValueFactory<Usluga,Integer>("iloscUslug"));
        netto.setCellValueFactory(new PropertyValueFactory<Usluga,Double>("KwotaNetto"));
        vat.setCellValueFactory(new PropertyValueFactory<Usluga,Double>("KwotaVAT"));
        brutto.setCellValueFactory(new PropertyValueFactory<Usluga,Double>("KwotaBrutto"));
        tableViewFaktury.getColumns().addAll(name,liczba,netto,vat,brutto);

        Button buttonWyswietl = (Button) parent.lookup("#buttonWyswietl");

        Button buttonPowrot = (Button) parent.lookup("#buttonPowrot");

        final Label labelZaplata = (Label) parent.lookup("#labelZaplata");

        listViewKlienci = (ListView<String>) parent.lookup("#listViewKlienci");
        listViewNumeryFaktur = (ListView<Integer>) parent.lookup("#listViewNumeryFaktur");

        arrayListKlienci = ResourceManager.getInstance().getKlientStorage().zwrocKlientow();

        buttonPowrot.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mainController.pokazMnie();
            }
        });

        buttonWyswietl.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Faktura f = ResourceManager.getInstance().getFakturyStorage().zwrocFaktury().get(0);
                odswiezListe(f);
                labelZaplata.setText(String.valueOf(obliczCeneFaktury.policzCene(f)));

            }
        });


        listViewKlienci.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                wybraneFaktury.clear();
                nazwaKlienta = newValue;
                //wybranyKlient = ResourceManager.getInstance().getKlientStorage().znajdzKlientaNazwa(nazwaKlienta);
                for(Faktura faktura: ResourceManager.getInstance().getFakturyStorage().zwrocFaktury()){
                    try {
                        if (faktura.zwrocKlienta().getNazwa().equals(nazwaKlienta))
                            wybraneFaktury.add(faktura);
                    }catch (Exception e){
                        System.out.println(faktura.zwrocKlienta());
                    }
                }

                listViewNumeryFaktur.getItems().clear();
                for(int i = 0; i < wybraneFaktury.size();i++){
                    listViewNumeryFaktur.getItems().add(i);
                }
            }

        });

        listViewNumeryFaktur.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                try {labelZaplata.setText(String.valueOf(obliczCeneFaktury.policzCene(wybraneFaktury.get(newValue))));odswiezListe(wybraneFaktury.get(newValue));}catch(Exception e){}
            }
        });
    }

    private void odswiezListe(Faktura faktura){
        ObservableList<Usluga> data = FXCollections.observableArrayList();

        for(Usluga usluga : faktura.zwrocUslugi()){
            data.add(usluga);
        }
        tableViewFaktury.setItems(data);
    }

    public Scene getScene(){
        wybraneFaktury = new ArrayList<Faktura>();
        listViewKlienci.getItems().clear();
        for(Klient klient:arrayListKlienci){
            listViewKlienci.getItems().add(klient.getNazwa());
        }
        return scene;
    }
}