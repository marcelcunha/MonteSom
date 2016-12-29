/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Marcel
 */
public abstract class AbstractDialogsUtils {
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
     * @param str Nome do campo que não pode ser vazio.
     * O texto mostrado será: 
     * "O campo " + str + " não pode ser vazio 
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
}
