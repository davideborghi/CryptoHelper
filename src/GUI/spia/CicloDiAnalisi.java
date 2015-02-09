/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.spia;

import GUI.PopUpViewer;
import java.util.Observable;
import java.util.Observer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import model.spia.AnalisiFrequenze;
import model.spia.Ipotesi;
import model.spia.Sessione;
import model.spia.SostituzioneSemplice;
import model.spia.StrumentoDiManipolazione;
import model.spia.StrumentoDiSupporto;
import model.spia.RipristinaIpotesiPrecedente;

/**
 *
 * @author davide
 */
public class CicloDiAnalisi extends javax.swing.JFrame implements Observer {

  public CicloDiAnalisi() {
    initComponents();
  }

  /**
   * Creates new form CicloDiAnalisi
   */
  public CicloDiAnalisi(Sessione s) {
    this();
    this.sessione = s;
    
    updateIpotesi();
    s.addObserver( this );
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do
   * NOT modify this code. The content of this method is always regenerated by the Form
   * Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jButton3 = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTree1 = new javax.swing.JTree();
    jButton4 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel2.setText("Ciclo di Analisi");

    jButton1.setLabel("Esegui analisi frequenze");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setLabel("Sostituisci una lettera");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jTextArea1.setEditable(false);
    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setText("Testo parzialmente decifrato");
    jScrollPane1.setViewportView(jTextArea1);

    jButton3.setText("TerminaCicloDiAnalisi");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jScrollPane2.setViewportView(jTree1);

    jButton4.setText("RipristinaIpotesi");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(117, 117, 117)
                .addComponent(jButton3))
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18))
          .addGroup(layout.createSequentialGroup()
            .addGap(58, 58, 58)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1)
            .addGap(30, 30, 30)))
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jButton3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButton2)
              .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton4)
            .addGap(26, 26, 26))))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      StrumentoDiSupporto a = new AnalisiFrequenze();
      
      a.start( this.sessione.getIpotesiCorrente().getMessaggioParzialmenteDecifrato() );
      new PopUpViewer(a.toString()).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      StrumentoDiManipolazione s = new SostituzioneSemplice();
      s.elabora( this.sessione );
    }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    this.dispose();
    synchronized( this.sessione ) {
      //torna il controllo a Sessione.start();
      this.sessione.notify();
    }
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    StrumentoDiManipolazione s = new  RipristinaIpotesiPrecedente();
    s.elabora( this.sessione );
  }//GEN-LAST:event_jButton4ActionPerformed

  private Sessione sessione;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTree jTree1;
  // End of variables declaration//GEN-END:variables

  
  private void updateIpotesi() {
    Sessione s = this.sessione;
    Ipotesi ip = s.getIpotesiCorrente();
    
    jTextArea1.setText(ip.getMessaggioParzialmenteDecifrato());
    
    DefaultTreeModel treeModel = new DefaultTreeModel( s.getIpotesiRadice() );
    jTree1.setModel( treeModel );
    
    for( int i = 0; i < jTree1.getRowCount(); i++ ) {
      jTree1.expandRow(i);
    }
    
    DefaultMutableTreeNode currentNode = this.sessione.getIpotesiCorrente();
    TreeNode[] nodes = ((DefaultTreeModel) jTree1.getModel()).getPathToRoot( currentNode );
    TreePath tpath = new TreePath(nodes);
    jTree1.scrollPathToVisible(tpath);
    jTree1.setSelectionPath(tpath);
  }
  @Override
  public void update(Observable o, Object arg) {
    updateIpotesi();
  }
}
