/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DAO.MontadoraDao;
import com.model.DAO.VeiculoDao;
import com.model.entidades.Montadora;
import com.model.entidades.Veiculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
    private ComboBox<Montadora> marcaCBB;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        marcaCBB.setItems(preencheMarcasCBB());
        marcaCBB.setCellFactory(marcaCBBFactory());
        marcaCBB.setButtonCell(cell());
    }

    @Override
    protected boolean verificaCampos() {
        if (nomeTF.getText().isEmpty()) {
            super.alertInfoVerifica("\"Nome\"");
            return false;
       
        } else if (marcaCBB.getSelectionModel().isEmpty()) {
            super.alertInfoVerifica("\"Marca\"");
            return false;
        }
        return true;
    }

    @Override
    @FXML
    protected void adicionar() {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                if (verificaCampos()) {
                    VeiculoDao dao = new VeiculoDao();
                    Veiculo v = new Veiculo(
                            nomeTF.getText(),                          
                            marcaCBB.getSelectionModel().getSelectedItem());
                    dao.salvar(v);

                    alertInfoAdiciona("Veículo", nomeTF.getText());
                    limparCampos();
                }
            }
        });

    }

    @Override
    @FXML
    protected void limparCampos() {
        nomeTF.setText(null);
        marcaCBB.getSelectionModel().clearSelection();
     
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

            @Override
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
