/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author MASTER
 */
public interface MessaggioDestinatario extends MessaggioAstratto {
    public boolean isLetto();

    public UserInfo getMittente();
}
