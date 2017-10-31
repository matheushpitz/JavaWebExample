/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ItemDAO;
import Model.Item;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Matheus Henrique Pitz
 */
@ManagedBean
public class CadastroItemController {
    private String descricao;
    private float valor;
    private List<Item> items;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValor() {
        return valor;
    }

    public List<Item> getItems() {
        this.items = ItemDAO.getAllItems();
        return items;
    }    
    
    /**
     * Função para cadastrar o item
     */
    public void cadastrar() {
        try {
            // cria o item
            Item i = new Item();
            // seta os valores
            i.setDescricao(descricao);
            i.setValor(valor);
            // salva
            ItemDAO.save(i);
            // exibe mensagem
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Sucesso", "Item cadastrado com sucesso"));
            // reseta os formulários.
            this.setDescricao("");
            this.setValor(0.0f);
            
        } catch(Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Erro", e.getMessage()));
        }
    }
    
}
