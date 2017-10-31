/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Matheus Henrique Pitz
 */
@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long oid;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_inicial;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_final;
    @Column
    private float vl_total;
    @Column
    private String observacao;

    public Lancamento() {
    }

    public Lancamento(Long oid, Date dt_inicial, Date dt_final, float vl_total, String observacao) {
        this.oid = oid;
        this.dt_inicial = dt_inicial;
        this.dt_final = dt_final;
        this.vl_total = vl_total;
        this.observacao = observacao;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Date getDt_inicial() {
        return dt_inicial;
    }

    public void setDt_inicial(Date dt_inicial) {
        if(dt_inicial == null) {
            throw new InvalidParameterException("A data inicial não pode ser nula.");
        }
        this.dt_inicial = dt_inicial;
    }

    public Date getDt_final() {
        return dt_final;
    }

    public void setDt_final(Date dt_final) {
        if(dt_final == null) {
            throw new InvalidParameterException("A data final não pode ser nula.");
        }
        this.dt_final = dt_final;
    }

    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
