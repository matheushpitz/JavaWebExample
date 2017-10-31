/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Matheus Henrique Pitz
 */
@ManagedBean
public class IntersecaoController {
    private int faixa11, faixa12, faixa21, faixa22;

    public int getFaixa11() {
        return faixa11;
    }

    public void setFaixa11(int faixa11) {
        this.faixa11 = faixa11;
    }

    public int getFaixa12() {
        return faixa12;
    }

    public void setFaixa12(int faixa12) {
        this.faixa12 = faixa12;
    }

    public int getFaixa21() {
        return faixa21;
    }

    public void setFaixa21(int faixa21) {
        this.faixa21 = faixa21;
    }

    public int getFaixa22() {
        return faixa22;
    }

    public void setFaixa22(int faixa22) {
        this.faixa22 = faixa22;
    }
    
    public void verifica() {        
        if(((faixa21 > faixa11) && (faixa21 < faixa12)) || ((faixa22 > faixa11) && (faixa22 < faixa12))) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Existe interseção entre as faixas 1 e 2."));
        } else {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Não há interseção entre as faixas 1 e 2."));
        }                       
    }    
}
