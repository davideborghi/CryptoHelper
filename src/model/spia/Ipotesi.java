package model.spia;


import java.io.Serializable;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Ipotesi extends javax.swing.tree.DefaultMutableTreeNode implements Serializable {
  
    private String key;
    private String messaggioParzialmenteDecifrato;
    
    public Ipotesi( String key, String messaggioParzialmenteDecifrato ) {
      this.key = key;
      this.messaggioParzialmenteDecifrato = messaggioParzialmenteDecifrato;
    }
    
    public String getMessaggioParzialmenteDecifrato() {
        return this.messaggioParzialmenteDecifrato;
    }
    
    public void add( Ipotesi p ) {
        super.add( p );
    }
    
    public void remove( Ipotesi p ) {
        super.remove( p );
    }
    
    public String toString() {
      return this.key;
    }
    
}
