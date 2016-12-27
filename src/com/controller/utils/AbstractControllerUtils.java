/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import com.controller.dialogs.SearchDialog;
import com.model.DAO.MontadoraDao;
import com.model.entidades.IEntidades;
import com.model.entidades.Montadora;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public abstract class AbstractControllerUtils {

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
    
    protected abstract Callback<ButtonType, IEntidades> buscaBanco(String param);
    /**
     * Mostra o Dialog de informação na tela
     *
     * @param mensagem
     */
    private void alertInfo(String mensagem) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setHeaderText(null);
        a.setContentText(mensagem);
        a.showAndWait();
    }

    /**
     * Abre o Dialog na tela com a mensagem de confirmação com dois botões de
     * opção (Sim e Não)
     *
     * @param mensagem Mensagem que será mostrada no Dialog
     * @return true se o usuário clicou no botão Sim, false, caso contrário
     */
    private boolean alertConfirm(String mensagem) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);

        a.setHeaderText(null);
        a.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        a.setContentText(mensagem);

        return a.showAndWait().get() == ButtonType.YES;
    }

    /**
     * Dialog para informar que um campo do formulário não pode estar vazio
     *
     * @param str Nome do campo que não pode ser vazio
     */
    protected void alertInfoVerifica(String str) {
        alertInfo("O campo " + str + " não pode ser vazio ");
    }

    /**
     * Dialog para informar que um item foi inserido com sucesso
     *
     * @param tipo Nome da entidade que está sendo inserida. Ex.: Veículo
     * @param nome Nome do item que está sendo inserido. Ex.: Corsa
     */
    protected void alertInfoAdiciona(String tipo, String nome) {
        alertInfo(tipo + " " + nome + " foi cadastrado(a) com sucesso!");
    }

    /**
     * Dialog de confirmação se o usuário deseja excluir o registro
     *
     * @return true se sim, false, se não
     */
    protected boolean alertConfirmExclui() {
        return alertConfirm("Deseja excluir o ítem?");
    }

    /**
     * Dialog de confirmação se o usuário deseja fazer a alteração no formulário
     *
     * @return true se sim, false, se não
     */
    protected boolean alertConfirmAltera() {
        return alertConfirm("Deseja salvar as alterações feitas?");
    }

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
    public IEntidades buscarEntidade(Callback<ButtonType, IEntidades> callback) {
        SearchDialog dialog = new SearchDialog();
        dialog.getDialog(callback);
    }
    
    }
     /*public IEntidades buscarEntidade(Callback<ButtonType, IEntidades> callback) {
        Dialog<IEntidades> d = new Dialog();
        DialogPane dp = new DialogPane();

        ButtonType BUSCAR = new ButtonType("Buscar");
        Label label = new Label("Digite o código ou nome:");
        TextField tf = new TextField();
        GridPane gp = new GridPane();

        GridPane.setMargin(gp, new Insets(10, 10, 10, 10));
        gp.add(label, 0, 0);
        gp.add(tf, 1, 0);
        dp.setContent(gp);
        dp.getButtonTypes().addAll(ButtonType.CANCEL, BUSCAR);

        d.setDialogPane(dp);
        d.setContentText("Counteudo");
        d.setTitle("titulo");
        d.setHeaderText("cabecalho");
        
        d.setResultConverter(new Callback<ButtonType, IEntidades>() {

            @Override
            public IEntidades call(ButtonType param) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        d.showAndWait();
        return d.getResult();
    }*/
}
