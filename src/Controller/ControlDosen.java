package Controller;

import GUI.FormDosen;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlDosen implements ActionListener{
    private App model;
    private FormDosen view;
    
    public ControlDosen(App model){
        this.model = model;
        view = new FormDosen();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        //masih salah, selalu input success
        if (click.equals(view.getBtnInput())){
            try{
                model.addDosen(view.getFieldNama(), 
                        view.getJSpinnerUmur(), 
                        view.getFieldNip());
                
                JOptionPane.showMessageDialog(view, "Input success!");
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                        "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            new ControlMenuAdmin(model);
            view.dispose();
        }
    }
}
