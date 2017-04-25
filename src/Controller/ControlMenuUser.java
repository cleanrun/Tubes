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
    private String username;

    public ControlMenuUser(App model, Database d, String username){
        this.model = model;
        this.d = d;
        this.username = username;
        view = new FormMenuUser(username);
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonNew())){
            new ControlMahasiswa(model, false, d, username);
            view.dispose();
        }
        else if(click.equals(view.getButtonAdd())){
            new ControlAddMahasiswa(model, false, d, username);
            view.dispose();
        }
        else if(click.equals(view.getButtonInfo())){
            new ControlInfo(model, false, d, username);
            view.dispose();            
        }
        else if(click.equals(view.getButtonChangePassword())){
            new ControlChangePassword(model, d, false, username);
            view.dispose();            
        }
        else if(click.equals(view.getButtonDelete())){
            new ControlDeleteAccount(model, d, username);
            view.dispose();           
            
            //JOptionPane.showMessageDialog(view, "Under maintanence", "", JOptionPane.WARNING_MESSAGE);
        }
        else if(click.equals(view.getButtonExit())){
            new ControlLogin(model, d);
            view.dispose();
        }
    }
}
