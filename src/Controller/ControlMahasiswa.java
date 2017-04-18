package Controller;

import GUI.FormMahasiswa;
import Model.App;
import Model.Mahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMahasiswa implements ActionListener{
    private App model;
    private FormMahasiswa view;
    private boolean b;
    
    public ControlMahasiswa(App model, boolean b){
        this.b = b;
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

                JOptionPane.showMessageDialog(view, "Input Success!");
                
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                    "", JOptionPane.ERROR_MESSAGE);
            }                                 
        }
        else if(click.equals(view.getBtnBack())){
            back();
        }
    }
    
    private void back(){
        if(b == true){
            new ControlMenuAdmin(model);
            view.dispose();
        }
        else{
            new ControlMenuUser(model);
            view.dispose();
        }
    }
    
    /*
    private boolean nimExist(String nim){
        for(Mahasiswa m : model.getListMhs()){
            if(m.getNim() == nim){
                return false;
            }
            else{
                return true;
            }
        }
        return true;
    }
    */  
}
