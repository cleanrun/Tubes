package Controller;

import Database.Database;
import GUI.FormAddMahasiswa;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlAddMahasiswa implements ActionListener{
    private App model;
    private FormAddMahasiswa view;
    private boolean b;
    private Database d;
    
    public ControlAddMahasiswa(App model, boolean b, Database d){
        this.b = b;
        this.model = model;
        this.d = d;
        view = new FormAddMahasiswa(model.getListMhs(), model.getListKelas());
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonAdd())){
            try{
                view.getComboBoxKelas().addMhs(view.getComboBoxMahasiswa());
                d.updateAddMahasiswa(view.getComboBoxKelas().getNamaKelas(), 
                        view.getComboBoxMahasiswa().getNama());
                JOptionPane.showMessageDialog(view, "Input success!");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(view, "Kelas is full!",
                      "", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(click.equals(view.getButtonBack())){
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
}
