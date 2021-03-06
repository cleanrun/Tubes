/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Kelas;
import Model.Matakuliah;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author cleanrun
 */
public class FormSetMatakuliah extends javax.swing.JFrame {

    /**
     * Creates new form FormSetMatakuliah
     */
    public FormSetMatakuliah(ArrayList<Matakuliah> listmk, ArrayList<Kelas> listkelas) {
        initComponents();
        setLocationRelativeTo(null);
        this.listmk = listmk;
        this.listkelas = listkelas;
        setComboBoxMatakuliah();
        setComboBoxKelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMk = new javax.swing.JComboBox<>();
        jComboBoxKelas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonSet = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SET MATAKULIAH TO KELAS");

        jLabel2.setText("Select Matakuliah :");

        jLabel3.setText("Select Kelas :");

        jButtonSet.setText("Set");

        jButtonBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxMk, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBack)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonSet)
                        .addGap(47, 47, 47)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSet)
                    .addComponent(jButtonBack))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setActionListener(ActionListener a){
        jButtonBack.addActionListener(a);
        jButtonSet.addActionListener(a);
    }
    
    public JButton getButtonBack(){
        return jButtonBack;
    }
    
    public JButton getButtonSet(){
        return jButtonSet;
    }
    
    private void setComboBoxMatakuliah(){
        for(Matakuliah m : listmk){
            jComboBoxMk.addItem(m.getNamaMk());
        }
    }
    
    private void setComboBoxKelas(){
        for(Kelas k : this.listkelas){
            jComboBoxKelas.addItem(k.getNamaKelas());
        }
    }
    
    public Kelas getComboBoxKelas(){
        for(Kelas k : this.listkelas){
            if(jComboBoxKelas.getSelectedItem() == k.getNamaKelas()){
                return k;
            }
        }
        return null;
    }

    public Matakuliah getComboBoxMatakuliah(){
        for(Matakuliah m : this.listmk){
            if(jComboBoxMk.getSelectedItem() == m.getNamaMk()){
                return m;
            }
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSet;
    private javax.swing.JComboBox<String> jComboBoxKelas;
    private javax.swing.JComboBox<String> jComboBoxMk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Matakuliah> listmk;
    private ArrayList<Kelas> listkelas;
}
