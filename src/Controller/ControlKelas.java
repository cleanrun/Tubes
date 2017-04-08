package Controller;

import GUI.FormKelas;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlKelas implements ActionListener{
    private App model;
    private FormKelas view;
    
    public ControlKelas(App model){
        this.model = model;
        view = new FormKelas(model.getListMk(), model.getListDosen());
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            Object click = ae.getSource();
            
            if(click.equals(view.getButtonInput())){
                try{
                        model.addKelas(view.getTextFieldNama(), 
                            view.getComboBoxMk(), 
                            view.getComboBoxDosen(), 
                            view.getSpinnerSks());
                        
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
