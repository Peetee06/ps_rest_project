package de.noltetrost.ps_rest_client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

import jakarta.ws.rs.core.Response;
import model.Artikel;

public class ControllerTabelle implements Initializable {

	RestClient client = new RestClient();

	@FXML private TableColumn<Artikel,Integer> artikelIDColumn;
	@FXML private TableColumn<Artikel,String> bezeichnungColumn;
	@FXML private TableColumn<Artikel,Integer> lagerbestandColumn;
	@FXML private TableColumn<Artikel,Double> preisColumn;

	@FXML private TableView<Artikel> tableView;
	@FXML private TextField artikelIDField;
	@FXML private TextField bezeichnungField;
	@FXML private TextField lagerbestandField;
	@FXML private TextField preisField;

	@FXML
	protected void addArtikel(ActionEvent event) {

		if(!artikelIDField.getText().isEmpty() 
				&& !bezeichnungField.getText().isEmpty() 
				&& !lagerbestandField.getText().isEmpty() 
				&& !preisField.getText().isEmpty())
		{

			Response response = client.postArtikel(
					new Artikel(Integer.parseInt(artikelIDField.getText()),
							bezeichnungField.getText(),
							Integer.parseInt(lagerbestandField.getText()),
							Double.parseDouble(preisField.getText())
							));

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Eintrag hinzufuegen");
			alert.setHeaderText("Daten unvollstaendig.");
			alert.setContentText("Bitte Daten vervollstaendigen.");
			alert.show();
		}

		artikelIDField.setText("");
		bezeichnungField.setText("");
		lagerbestandField.setText("");
		preisField.setText("");

		this.refreshArtikel();
	}

	@FXML
	protected void refreshArtikel(ActionEvent event) {
		this.refreshArtikel();
	}

	public ObservableList<Artikel> getArtikelList() {

		Artikel[] artikelArray = this.client.getAllArtikel();

		ObservableList<Artikel> artikelList = FXCollections.observableArrayList(artikelArray);
		return artikelList;
	}

	public void refreshArtikel() {
		tableView.setItems(this.getArtikelList());
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		artikelIDColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("artikelID"));
		bezeichnungColumn.setCellValueFactory(new PropertyValueFactory<Artikel, String>("bezeichnung"));
		lagerbestandColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("lagerbestand"));
		preisColumn.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("preis"));

		artikelIDColumn.setCellFactory(
				TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		bezeichnungColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lagerbestandColumn.setCellFactory(
				TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		preisColumn.setCellFactory(
				TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

		artikelIDColumn.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Artikel, Integer>>() {
					@Override
					public void handle(TableColumn.CellEditEvent<Artikel, Integer> t) {
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
								).setArtikelID(t.getNewValue());
					}


				}
				);


		bezeichnungColumn.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Artikel, String>>() {
					@Override
					public void handle(TableColumn.CellEditEvent<Artikel, String> t) {
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
								).setBezeichnung(t.getNewValue());
					}


				}
				);


		lagerbestandColumn.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Artikel, Integer>>() {
					@Override
					public void handle(TableColumn.CellEditEvent<Artikel, Integer> t) {
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
								).setLagerbestand(t.getNewValue());
					}


				}
				);


		preisColumn.setOnEditCommit(
				new EventHandler<TableColumn.CellEditEvent<Artikel, Double>>() {
					@Override
					public void handle(TableColumn.CellEditEvent<Artikel, Double> t) {
						(t.getTableView().getItems().get(
								t.getTablePosition().getRow())
								).setPreis(t.getNewValue());
					}


				}
				);

		this.refreshArtikel();
	}

}


