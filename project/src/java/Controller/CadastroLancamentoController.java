/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ItemDAO;
import Model.DAO.LancamentoDAO;
import Model.DAO.LancamentoItemDAO;
import Model.Item;
import Model.Lancamento;
import Model.LancamentoItem;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Matheus Henrique Pitz
 */
@ManagedBean
@SessionScoped
public class CadastroLancamentoController {
    private Date dtInicial, dtFinal;
    private String observacao;
    private float valor;
    private float valorTotalLancamento;
    private int idLancamento = 1;    
    private int idItem = 1;
    
    private List<Lancamento> lancamentos;  
    private List<Item> items;
    private List<LancamentoItem> lancamentosItems;

    public List<Lancamento> getLancamentos() {
        this.lancamentos = LancamentoDAO.getAllLancamentos();
        return lancamentos;
    }       

    public List<Item> getItems() {
        this.items = ItemDAO.getAllItems();
        return items;
    }   

    public List<LancamentoItem> getLancamentosItems() {         
        this.lancamentosItems = LancamentoItemDAO.getLancamentoItemByLancamentoID(this.idLancamento);
        return lancamentosItems;
    }        

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {        
        this.idItem = idItem;
    }
    
    public int getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(int idLancamento) {         
        this.idLancamento = idLancamento;        
    }   

    public float getValorTotalLancamento() {
        Lancamento l =  LancamentoDAO.getLancamentoByID(this.idLancamento);
        if(l != null) {
            return l.getVl_total();
        }
        return 0.0f;
    }
    
    public Date getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {        
        this.dtFinal = dtFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    /**
     * Cadastra os lançamentos
     */
    public void cadastrar() {
        try {            
            Lancamento l = new Lancamento();
            
            l.setDt_final(dtFinal);
            l.setDt_inicial(dtInicial);
            l.setObservacao(observacao);
            l.setVl_total(0.0f);
            
            LancamentoDAO.save(l);
            
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Sucesso", "Lançamento cadastrado com sucesso"));
            
            this.observacao = "";
            this.valor = 0.0f;
            this.dtFinal = null;
            this.dtInicial = null;
            
        } catch(Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Erro", e.getMessage()));
        }
    }        
    /**
     * Vincula os itens ao lançamento
     */
    public void vinculaItem() {
        try {                        
            Item i = ItemDAO.getItemByID(this.idItem);
            Lancamento l = LancamentoDAO.getLancamentoByID(this.idLancamento);
            
            LancamentoItem li = new LancamentoItem();
            
            li.setOid_item(i);
            li.setOid_lancamento(l);
            
            LancamentoItemDAO.save(li);
            
            this.updateValorLancamento(this.idLancamento);
            
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Sucesso", "Item vinculado ao Lançamento com sucesso."));
            
        } catch(Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Erro", e.getMessage()));
        }
    }
    /**
     * Remove o LançamentoItem.
     * @param li ID do LançamentoItem.
     */
    public void removeLancamentoItem(LancamentoItem li) {
        try {            
            LancamentoItemDAO.remove(li);
            
            this.updateValorLancamento(this.idLancamento);
            
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Sucesso", "Deletado com sucesso."));
        } catch(Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Erro", e.getMessage()));
        }
    }
    /**
     * Atualiza o valor do lançamento.
     * @param ID id do lançamento.
     */
    private void updateValorLancamento(int id) {
        List<LancamentoItem> li = LancamentoItemDAO.getLancamentoItemByLancamentoID(id);
        
        float total = 0.0f;
        
        for(int i = 0; i < li.size(); i++) {
            total += li.get(i).getOid_item().getValor();
        }
        
        Lancamento l = LancamentoDAO.getLancamentoByID(id);
        
        l.setVl_total(total);
        
        LancamentoDAO.save(l);
        
        li = null;
        l = null;
    }
}
