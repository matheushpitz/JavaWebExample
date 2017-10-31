/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



/**
 *
 * @author Matheus Henrique Pitz
 */
@ManagedBean
public class IndexController {
    public void redirectToItemCad() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/cadastroItem.xhtml");
    }
    
    public void redirectToLancamentoCad() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/cadastroLancamento.xhtml");
    }
    
    public void redirectToIntersecao() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/intersecao.xhtml");
    }
    
    public void redirectToPrimos() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/primos.xhtml");
    }
}
