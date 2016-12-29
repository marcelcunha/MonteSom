/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import com.controller.dialogs.AbstractDialogsUtils;
import com.model.DAO.MontadoraDao;
import com.model.entidades.IEntidades;
import com.model.entidades.Montadora;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 *
 * @author Marcel
 */
public abstract class AbstractControllerUtils extends AbstractDialogsUtils {

    @FXML
    protected Button acao;

    public Button getAcaoBTN() {
        return acao;
    }

    /**
     * Verifica se todos os campos importantes do formulário estão preenchidos
     *
     * @return Retorna true se todos campos importantes estão preenchidos, falso
     * se não
     */
    protected abstract boolean verificaCampos();

    /**
     * Adiciona os dados do formulário no banco de dados
     */
    public abstract void adicionar();

    /**
     * Remove um item cadastradado previamente selecionado do banco de dados
     */
    public abstract void excluir();

    /**
     * Altera um item cadastradado previamente selecionado no banco de dados
     */
    public abstract void alterar();

    /**
     * Preenche os campos do formulário com as informações do banco de dados
     *
     * @param entidade Entidade cujos valores irão preencher os campos
     */
    public abstract void preencheFormulario(IEntidades entidade);

    /**
     * Limpa todos os campos do formulário
     */
    protected abstract void limparCampos();

    public abstract IEntidades encontraEntidade(String str);

    
    /**
     * Preenche a lista com as Montadoras presentres banco de dados para popular
     * o combobox
     *
     * @return ObservableList das Montadoras presentes no banco de dados
     */
    protected ObservableList<Montadora> preencheMarcasCBB() {
        ObservableList<Montadora> list = FXCollections.observableArrayList();
        MontadoraDao dao = new MontadoraDao();

        list.addAll(dao.getList());

        return list;
    }

    public IEntidades buscarEntidade() {
        Dialog<IEntidades> d = new Dialog();
        DialogPane dp = new DialogPane();

        ButtonType BUSCAR = new ButtonType("Buscar", ButtonBar.ButtonData.APPLY);
       
        Label label = new Label("Digite o código ou nome:");
        TextField tf = new TextField();
        GridPane gp = new GridPane();

        GridPane.setMargin(gp, new Insets(10, 10, 10, 10));
        gp.add(label, 0, 0);
        gp.add(tf, 1, 0);
        dp.setContent(gp);
        dp.getButtonTypes().addAll(BUSCAR, ButtonType.CANCEL );

        d.setDialogPane(dp);
        d.setContentText("Counteudo");
        d.setTitle("titulo");
        d.setHeaderText("cabecalho");
        
        Button buscar = (Button) dp.lookupButton(BUSCAR);
        tf.requestFocus();
        
        d.setResultConverter(new Callback<ButtonType, IEntidades>() {

            @Override
            public IEntidades call(ButtonType param) {
                return encontraEntidade(tf.getText());
            }
        });
        d.showAndWait();
        return d.getResult();
    }
}
