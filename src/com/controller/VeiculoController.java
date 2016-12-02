/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DAO.MontadoraDao;
import com.model.entidades.Montadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Marcel
 */
public class VeiculoController extends AbstractUIUtils implements Initializable {

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField modeloTF;

    @FXML
    private ComboBox<Montadora> marcaCBB;

    @FXML
    private ComboBox<Integer> portasCBB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        portasCBB.getItems().addAll(2, 3, 4);
        marcaCBB.setItems(preencheMarcasCBB());

        marcaCBB.setCellFactory(marcaCBBFactory());
        marcaCBB.setButtonCell(cell());
    }

    @Override
    protected boolean verificaCampos() {
        if (nomeTF.getText().isEmpty()) {
            super.alertInfoVerifica("\"Nome\"");
            return false;
        } else if (modeloTF.getText().isEmpty()) {
            super.alertInfoVerifica("\"Modelo\"");
             return false;
        } else if (marcaCBB.getSelectionModel().isEmpty()) {
            super.alertInfoVerifica("\"Marca\"");
             return false;
        } else if (portasCBB.getSelectionModel().isEmpty()) {
            super.alertInfoVerifica("\"Quantidade de portas\"");
             return false;
        } 
        return true;
    }

    @Override
    @FXML
    protected void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FXML
    protected void limparCampos() {
        nomeTF.setText(null);
        modeloTF.setText(null);
        marcaCBB.setSelectionModel(null);
        portasCBB.setSelectionModel(null);
    }

    private ObservableList<Montadora> preencheMarcasCBB() {
        ObservableList<Montadora> list = FXCollections.observableArrayList();
        MontadoraDao dao = new MontadoraDao();

        list.addAll(dao.getList());

        return list;
    }

    private Callback<ListView<Montadora>, ListCell<Montadora>> marcaCBBFactory() {
        return new Callback<ListView<Montadora>, ListCell<Montadora>>() {

            @Override
            public ListCell<Montadora> call(ListView<Montadora> param) {
                return cell();
            }
        };
    }

    private ListCell<Montadora> cell() {
        final ListCell<Montadora> cell = new ListCell<Montadora>() {

            protected void updateItem(Montadora item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setText(item.getNomeMarca());
                }
            }
        };
        return cell;
    }
}
