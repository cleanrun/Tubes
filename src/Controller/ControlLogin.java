package Controller;

import Database.Database;
import GUI.FormLogin;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlLogin implements ActionListener{
    private App model;
    private FormLogin view;
    private Database d;
    
    public ControlLogin(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormLogin();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {        
        Object click = ae.getSource();
        if(click.equals(view.getButtonAdmin())){
            new ControlLoginAdmin(model, d);
            view.dispose();
        }
        else if(click.equals(view.getButtonUser())){
            new ControlMenuUser(model, d);
            view.dispose();
        }
    }
}
