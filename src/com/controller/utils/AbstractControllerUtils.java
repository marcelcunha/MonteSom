/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import com.controller.Action;
import com.model.DAO.MontadoraDao;
import com.model.entidades.Montadora;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Marcel
 */
public abstract class AbstractControllerUtils {
    
    @FXML
    protected Button acao;

    public AbstractControllerUtils() {
    }

    public Button getAcaoBTN() {
        return acao;
    }
    
    public AbstractControllerUtils(Action action, String textoComponente) {
        acao.setText(textoComponente);
        acao.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (action == Action.INSERIR) {
                    adicionar();
                } else if (action == Action.ALTERAR) {
                    alterar();
                } else if (action == Action.REMOVER) {
                    excluir();
                }
                
            }
        });
    }
    
    protected abstract boolean verificaCampos();
    
    public abstract void adicionar();
    
    public abstract void excluir();
    
    public abstract void alterar();
    
    protected abstract void limparCampos();
    
    private void alertInfo(String mensagem) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        
        a.setHeaderText(null);
        a.setContentText(mensagem);
        a.showAndWait();
    }
    
    public <T> T dialogPesquisa() {
        
        Dialog<T> dialog = new Dialog<>();
        
        dialog.setTitle("Buscar");
        dialog.setHeaderText("Buscar Montadora");
        dialog.setGraphic(new ImageView("/com/view/icons/search.png"));
        
        ButtonType buscar = new ButtonType("Buscar", ButtonBar.ButtonData.OK_DONE);        
        dialog.getDialogPane().getButtonTypes().addAll(buscar, ButtonType.CANCEL);
        
        TextField campo = new TextField();
        Label label = new Label("Digite o nome ou código: ");
        VBox vbox = new VBox(campo, label);
        dialog.getDialogPane().getChildren().add(vbox);
        dialog.showAndWait();
        
        return null;
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
