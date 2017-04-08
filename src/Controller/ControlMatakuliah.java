package Controller;

import GUI.FormMatakuliah;
import Model.App;
import Model.Matakuliah;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMatakuliah implements ActionListener{
    private App model;
    private FormMatakuliah view;
    
    public ControlMatakuliah(App model){
        this.model = model;
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
                new ControlMenuAdmin(model);
                view.dispose();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(view, "Error input",
                      "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
