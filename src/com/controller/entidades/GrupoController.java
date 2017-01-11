/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.services.GrupoCRUD;
import com.controller.utils.AbstractControllerUtils;
import com.model.entidades.Montadora;
import com.model.entidades.Veiculo;
import com.services.VeiculoCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;

/**
 *
 * @author Marcel
 */
public class GrupoController extends AbstractControllerUtils implements Initializable {

    ObservableList<Veiculo> veiList = FXCollections.observableArrayList();

    GrupoCRUD crud = GrupoCRUD.getInstance();

    @FXML
    private Label codL;

    @FXML
    private TextField codTF;

    @FXML
    private TextField nomeTF;

    @FXML
    private ComboBox<Montadora> montadoraCBB;

    @FXML
    private ListView<Veiculo> veiculoLV;

    @FXML
    void limparCampos(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        montadoraCBB.setItems(super.preencheMarcasCBB());
        montadoraCBB.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue<? extends Montadora> observable,
                Montadora oldValue, Montadora newValue) -> {
                    veiculoLV.setItems(
                            FXCollections.observableArrayList(
                                    VeiculoCRUD.getInstance()
                                    .getDao().getListFromMarca(newValue)));
                });

        veiculoLV.setCellFactory(CheckBoxListCell.forListView((Veiculo param) -> {
            BooleanProperty observable = new SimpleBooleanProperty();

            observable
                    .addListener((ObservableValue<? extends Boolean> observable1,
                                    Boolean oldValue, Boolean newValue) -> {
                        if (newValue) {
                            veiList.add(param);
                        }else
                            veiList.remove(param);
                    });
            return observable;
        }));
        veiculoLV.disableProperty().bind(montadoraCBB.valueProperty().isNull());
    }

    @Override
    protected boolean verificaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preencheFormulario(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Button getLimparBTN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
