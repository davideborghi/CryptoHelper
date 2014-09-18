package model.spia;


import model.Messaggio;
import model.Messaggio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public interface SistemaDiSupporto {
    public Ipotesi start(Ipotesi ipCorrente, Messaggio messaggio);
}
