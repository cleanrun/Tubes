package Controller;

import GUI.FormLoginAdmin;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlLoginAdmin implements ActionListener{
    private App model;
    private FormLoginAdmin view;
    
    public ControlLoginAdmin(App model){
        this.model = model;
        view = new FormLoginAdmin();
        view.setActionListener(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonLogin())){
            if(view.getUsername().equals("administrator") && view.getPassword().equals("password") == true){
                new ControlMenuAdmin(model);
                view.dispose();
            }
            else{
                JOptionPane.showMessageDialog(view, "Wrong username or Password!");
            }
        }
        else if(click.equals(view.getButtonBack())){
            new ControlLogin(model);
            view.dispose();
        }
    }
    
}
