package Controller;

import Database.Database;
import GUI.FormDosen;
import Model.App;
import Model.Dosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlDosen implements ActionListener{
    private App model;
    private FormDosen view;
    private Database d;
    
    public ControlDosen(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormDosen();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if (click.equals(view.getBtnInput())){
            try{
                Dosen ds = new Dosen(view.getFieldNama(), 
                        view.getJSpinnerUmur(), 
                        view.getFieldNip());
                
                d.saveDosen(ds);
                model.addDosen(ds);
                
                JOptionPane.showMessageDialog(view, "Input success!");
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                        "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            new ControlMenuAdmin(model, d);
            view.dispose();
        }
    }
}
