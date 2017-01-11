/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.utils;

import com.controller.dialogs.AbstractDialogsUtils;
import com.model.DAO.MontadoraDao;
import com.model.entidades.Modelo;
import com.model.entidades.Montadora;
import com.services.ModeloCRUD;
import com.services.MontadoraCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Marcel
 */
public abstract class AbstractControllerUtils extends AbstractDialogsUtils {

    @FXML
    protected Button acao;

    @FXML
    protected Button cancelarBTN;

    @FXML
    protected Button limparBTN;

    /**
     * Pega a instância do botão LimparBTN
     *
     * @return Button LimparBTN
     */
    public Button getLimparBTN() {
        return limparBTN;
    }

    /**
     * Pega a instância do botão genérico que responde por (incluir, altererar
     * ou excluir item)
     *
     * @return Button - Acao
     */
    public Button getAcaoBTN() {
        return acao;
    }

    /**
     * Pega a instância do botão que cancela a atividade que o usuário estiver
     * fazendo na sub-tela da entidade
     *
     * @return Button - Cancelar
     */
    public Button getCancelarBTN() {
        return cancelarBTN;
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
     * @param nome Nome da entidade que irá ser buscada
     */
    public abstract void preencheFormulario(String nome);

    /**
     * Limpa todos os campos do formulário
     */
    protected abstract void limparCampos();

    /**
     * Preenche a lista com as Montadoras presentres banco de dados para popular
     * o combobox
     *
     * @return {@code ObservableList<Montadora>}ObservableList das Montadoras presentes no banco de dados
     */
    protected ObservableList<Montadora> preencheMarcasCBB() {
        ObservableList<Montadora> list = FXCollections.observableArrayList();

        list.addAll(MontadoraCRUD.getInstance()
                .getDao().getList());

        return list;
    }
    
    /**
     * Preenche a lista que irá popular o combo box com os Modelos
     * encontrados no banco de dados com base no parâmetro Montadora
     *
     * @param m Montadora que produz os modelos
     * @return {@code ObservableList<Modelo>}ObservableList dos Modelos presentes no banco de dados
     */
    protected ObservableList<Modelo> preencheModeloCBB(Montadora m) {
        return FXCollections.observableArrayList(
                ModeloCRUD.getInstance().getDao().getListFromMarca(m));
    }
}
