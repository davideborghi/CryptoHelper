package model.spia;


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
public class Ipotesi extends javax.swing.tree.DefaultMutableTreeNode {

    private char cifrata;
    private char inChiaro;
    
    private String messaggioParzialmenteDecifrato;
    
    
    public void add( Ipotesi p ) {
        super.add( p );
    }
    
    public void remove( Ipotesi p ) {
        super.remove( p );
    }
    
}
