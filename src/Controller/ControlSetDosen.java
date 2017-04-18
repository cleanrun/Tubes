package Controller;

import Database.Database;
import GUI.FormSetDosen;
import Model.App;
import Model.Dosen;
import Model.Kelas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlSetDosen implements ActionListener{
    private App model;
    private FormSetDosen view;
    private Database d;
    
    public ControlSetDosen(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormSetDosen(model.getListDosen(), model.getListKelas());
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonSet())){
            try{
                view.getComboBoxKelas().setDosen(view.getComboBoxDosen()); 
                d.updateSetDosen(view.getComboBoxDosen().getNama(), 
                        view.getComboBoxKelas().getNamaKelas());
                
                JOptionPane.showMessageDialog(view, "Input success!");
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                            "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(click.equals(view.getButtonBack())){
            new ControlMenuAdmin(model ,d);
            view.dispose();
        }
    }
}
