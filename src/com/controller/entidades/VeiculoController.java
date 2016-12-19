/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
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
public class VeiculoController extends AbstractControllerUtils implements Initializable {

    @FXML
    private TextField nomeTF;

    @FXML
    private ComboBox<Montadora> marcaCBB;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        marcaCBB.setItems(preencheMarcasCBB());
       /* marcaCBB.setCellFactory(super.marcaCBBFactory());
        marcaCBB.setButtonCell(cell());*/
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
    public void adicionar() {
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

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
