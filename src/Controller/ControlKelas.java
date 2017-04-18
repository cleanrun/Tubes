package Controller;

import Database.Database;
import GUI.FormKelas;
import Model.App;
import Model.Kelas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlKelas implements ActionListener{
    private App model;
    private FormKelas view;
    private Database d;
    
    public ControlKelas(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormKelas(model.getListMk(), model.getListDosen());
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            Object click = ae.getSource();
            
            if(click.equals(view.getButtonInput())){
                try{
                    Kelas k = new Kelas(view.getTextFieldNama(), 
                        view.getComboBoxMk(), 
                        view.getComboBoxDosen(), 
                        view.getSpinnerSks());
                    
                    d.saveKelas(k);
                    model.addKelas(k);                       
                    JOptionPane.showMessageDialog(view, "Input success!");
                } catch(Exception e){
                        JOptionPane.showMessageDialog(view, "Error input",
                            "", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(click.equals(view.getButtonBack())){
                new ControlMenuAdmin(model, d);
                view.dispose();
            }
        }
}
