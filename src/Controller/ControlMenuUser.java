package Controller;

import Database.Database;
import GUI.FormMenuUser;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMenuUser implements ActionListener{
    private App model;
    private FormMenuUser view;
    private Database d;

    public ControlMenuUser(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormMenuUser();
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonNew())){
            new ControlMahasiswa(model, false, d);
            view.dispose();
        }
        else if(click.equals(view.getButtonAdd())){
            new ControlAddMahasiswa(model, false, d);
            view.dispose();
        }
        else if(click.equals(view.getButtonInfo())){
            //JOptionPane.showMessageDialog(view, "Under maintanence", "", JOptionPane.WARNING_MESSAGE);
            
            
            new ControlInfo(model, false, d);
            view.dispose();
            
        }
        else if(click.equals(view.getButtonExit())){
            new ControlLogin(model, d);
            view.dispose();
        }
    }
}
