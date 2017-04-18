package Controller;

import Database.Database;
import GUI.FormMatakuliah;
import Model.App;
import Model.Matakuliah;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMatakuliah implements ActionListener{
    private App model;
    private FormMatakuliah view;
    private Database d;
    
    public ControlMatakuliah(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormMatakuliah();
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        try{
            if (click.equals(view.getBtnInput())){
                
                model.addMatakuliah(view.getFieldNama(), 
                        view.getSpinnerSks(), 
                        view.getCheckBoxWajib());
                
                Matakuliah mk = new Matakuliah(view.getFieldNama(), 
                        view.getSpinnerSks(), 
                        view.getCheckBoxWajib());
                
                d.saveMatakuliah(mk);
                model.addMatakuliah(mk);
                
                /*
                if(view.getCheckBoxWajib() == 'y'){
                    JOptionPane.showMessageDialog(view, "Wajib");
                }
                else{
                    JOptionPane.showMessageDialog(view, "Ga wajib");
                }
                */
                
                JOptionPane.showMessageDialog(view, "Input Success!");               
            }
            else if (click.equals(view.getBtnBack())){
                new ControlMenuAdmin(model, d);
                view.dispose();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(view, "Error input",
                      "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
