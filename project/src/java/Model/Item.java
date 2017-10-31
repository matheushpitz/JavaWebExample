/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Matheus Henrique Pitz
 */
@Entity(name = "item")
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long oid;
    @Column    
    private String descricao;
    @Column
    private float valor;

    public Item() {
    }

    public Item(Long oid, String descricao, float valor) {
        this.oid = oid;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getDescricao() {        
        return descricao;
    }

    public void setDescricao(String descricao) {        
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
