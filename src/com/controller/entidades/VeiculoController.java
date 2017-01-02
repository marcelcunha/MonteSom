/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.entidades;

import com.controller.utils.AbstractControllerUtils;
import com.model.DAO.VeiculoDao;
import com.model.entidades.IEntidades;
import com.model.entidades.Montadora;
import com.model.entidades.Veiculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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

        if (verificaCampos()) {
            VeiculoDao dao = new VeiculoDao();
            Veiculo v = new Veiculo();
            dao.salvar(v);

            alertInfoAdiciona("Veículo", nomeTF.getText());
            limparCampos();
        }
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
    @FXML
    protected void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEntidades encontraEntidade(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
