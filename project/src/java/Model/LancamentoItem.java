/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matheus Henrique Pitz
 */
@Entity
@Table(name = "lancamentoItem")
public class LancamentoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oid_lancamento")
    private Lancamento oid_lancamento;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oid_item")
    private Item oid_item;

    public LancamentoItem() {
    }

    public LancamentoItem(Long id, Lancamento oid_lancamento, Item oid_item) {
        this.id = id;
        this.oid_lancamento = oid_lancamento;
        this.oid_item = oid_item;
    }
    

    public Lancamento getOid_lancamento() {
        return oid_lancamento;
    }

    public void setOid_lancamento(Lancamento oid_lancamento) {
        this.oid_lancamento = oid_lancamento;
    }

    public Item getOid_item() {
        return oid_item;
    }

    public void setOid_item(Item oid_item) {
        this.oid_item = oid_item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
    
}
