package Controller;

import GUI.FormDosen;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlDosen {
    private FormDosen gui;
    private Model model;
    
    public ControlDosen(FormDosen gui, Model model){
        this.gui = gui;
        this.model = model;
        this.gui.btnInputPerfomed(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Dosen(String nama, int umur, String nip)
                String getNama = gui.getFieldNama();
                String getNip = gui.getFieldNama();
                int getUmur = gui.getJSpinnerUmur();
                
                model.setDosen(getNama, getUmur, getNip);
                JOptionPane.showMessageDialog(gui, "Data terinput", "Success", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
    }
}
