/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import com.model.DAO.MontadoraDao;
import com.model.entidades.Montadora;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author Marcel
 */
public abstract class AbstractUIUtils {

    protected abstract boolean verificaCampos();

    protected abstract void adicionar();

    protected abstract void limparCampos();

    private void alertInfo(String mensagem) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setHeaderText(null);
        a.setContentText(mensagem);
        a.showAndWait();
    }

    protected void alertInfoVerifica(String str) {
        alertInfo("O campo " + str + " não pode ser vazio ");
    }

    protected void alertInfoAdiciona(String tipo, String nome) {
        alertInfo(tipo + " " + nome + " foi cadastrado(a) com sucesso!");
    }
    
    /**
     *
     * @return
     */
    protected ObservableList<Montadora> preencheMarcasCBB() {
        ObservableList<Montadora> list = FXCollections.observableArrayList();
        MontadoraDao dao = new MontadoraDao();

        list.addAll(dao.getList());

        return list;
    }
}
