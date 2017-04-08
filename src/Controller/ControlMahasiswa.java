package Controller;

import GUI.FormMahasiswa;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMahasiswa implements ActionListener{
    private App model;
    private FormMahasiswa view;
    
    public ControlMahasiswa(App model){
        this.model = model;
        view = new FormMahasiswa();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getBtnInput())){
            try{
                    model.addMahasiswa(view.getInpNamaMahasiswa(),
                        view.getJSpinnerUmur(), 
                        view.getInpNim(), 
                        view.getInpFakultas(), 
                        view.getInpSemester(), 
                        view.getJSpinnerSks());
                    
                    JOptionPane.showMessageDialog(view, "Input success!");
                    view.reset(); // Masih gafungsi
            }catch(Exception e){
                    JOptionPane.showMessageDialog(view, "Error input",
                      "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(click.equals(view.getBtnBack())){
            new ControlMenuAdmin(model);
            view.dispose();
        }
    }
    
    
}
