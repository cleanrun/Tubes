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
            //JOptionPane.showMessageDialog(view, "Admin menu on progress!",
            //      "Under Maintenance", JOptionPane.WARNING_MESSAGE);
            new ControlMenuAdmin(model);
            view.dispose();
        }
        else if(click.equals(view.getButtonUser())){            
            JOptionPane.showMessageDialog(view, "User menu on progress!",
                    "Under Maintenance", JOptionPane.WARNING_MESSAGE);
        }
    }
}
