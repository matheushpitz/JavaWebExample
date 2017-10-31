/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Matheus Henrique Pitz
 */
@ManagedBean
public class Primos {
    private String primosText;

    public String getPrimosText() {
        this.primosText = "";
        this.addText("Numeros primos de 41 a 5002: ");
        
        int min = 41;
        int max = 5002;
        
        for(int i = min; i <= max; i++) {
            boolean p = false;
            for(int j = 2; j < i; j++) {
                if((i % j) == 0) {
                    p = true;
                    break;
                }
            }
            if(!p) {
                this.addText(i+", ");
            }
        }
        return this.primosText;
    }  
    
    private void addText(String t) {
        this.primosText += t;
    }
}
