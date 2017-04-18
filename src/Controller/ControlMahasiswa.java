package Controller;

import Database.Database;
import GUI.FormMahasiswa;
import Model.App;
import Model.Mahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControlMahasiswa implements ActionListener{
    private App model;
    private FormMahasiswa view;
    private boolean b;
    private Database d;
    
    public ControlMahasiswa(App model, boolean b, Database d){
        this.b = b;
        this.model = model;
        this.d = d;
        view = new FormMahasiswa();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getBtnInput())){
            try{
                Mahasiswa m = new Mahasiswa(view.getInpNamaMahasiswa(),
                    view.getJSpinnerUmur(), 
                    view.getInpNim(), 
                    view.getInpFakultas(), 
                    view.getInpSemester(), 
                    view.getJSpinnerSks());
                
                d.saveMahasiswa(m);
                model.addMahasiswa(m);
                
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
            new ControlMenuAdmin(model, d);
            view.dispose();
        }
        else{
            new ControlMenuUser(model, d);
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
