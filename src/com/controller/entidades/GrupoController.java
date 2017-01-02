/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.crud.GrupoCRUD;
import com.controller.crud.VeiculoCRUD;
import com.controller.utils.AbstractControllerUtils;
import com.model.entidades.IEntidades;
import com.model.entidades.Montadora;
import com.model.entidades.Veiculo;
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
    private Label veiLBL;

    @FXML
    void limparCampos(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        montadoraCBB.setItems(super.preencheMarcasCBB());
        montadoraCBB.getSelectionModel().selectedItemProperty().addListener(
                (new ChangeListener<Montadora>() {

                    @Override
                    public void changed(ObservableValue<? extends Montadora> observable, Montadora oldValue, Montadora newValue) {
                        veiLBL.setVisible(true);
                        veiculoLV.setVisible(true);
                        veiculoLV.setItems(FXCollections.observableArrayList(
                                        VeiculoCRUD.getInstance().getDao().getListFromMarca(newValue)));
                    }

                }));

        veiculoLV.setCellFactory(CheckBoxListCell.forListView((Veiculo param) -> {
            BooleanProperty observable = new SimpleBooleanProperty();

            observable.addListener((ObservableValue<? extends Boolean> observable1, Boolean oldValue, Boolean newValue) -> {
                if (newValue) {
                    veiList.add(param);

                }
            });

            return observable;
        }));
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
    public void preencheFormulario(IEntidades entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEntidades encontraEntidade(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
