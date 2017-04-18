package Controller;

import GUI.FormSetMatakuliah;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlSetMatakuliah implements ActionListener{
    private App model;
    private FormSetMatakuliah view;
    
    public ControlSetMatakuliah(App model){
        this.model = model;
        view = new FormSetMatakuliah(model.getListMk(), model.getListKelas());
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if (click.equals(view.getButtonSet())){
            try{
                view.getComboBoxKelas().setMatkul(view.getComboBoxMatakuliah());
                JOptionPane.showMessageDialog(view, "Input success!");
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                            "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (click.equals(view.getButtonBack())){
            new ControlMenuAdmin(model);
            view.dispose();
        }
    }
    
}
