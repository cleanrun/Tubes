package Controller;

import GUI.FormLogin;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlLogin implements ActionListener{
    private App model;
    private FormLogin view;
    
    public ControlLogin(App model){
        this.model = model;
        view = new FormLogin();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {        
        Object click = ae.getSource();
        if(click.equals(view.getButtonAdmin())){
            new ControlLoginAdmin(model);
            view.dispose();
        }
        else if(click.equals(view.getButtonUser())){
            new ControlMenuUser(model);
            view.dispose();
        }
    }
}
