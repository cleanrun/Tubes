package Controller;

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
    
    public ControlSetDosen(App model){
        this.model = model;
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
                JOptionPane.showMessageDialog(view, "Input success!");
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                            "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(click.equals(view.getButtonBack())){
            new ControlMenuAdmin(model);
            view.dispose();
        }
    }
}
