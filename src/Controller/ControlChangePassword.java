package Controller;

import Database.Database;
import GUI.FormChangePassword;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlChangePassword implements ActionListener{
    private App model;
    private FormChangePassword view;
    private boolean b;
    private Database d;
    private String username;
    
    public ControlChangePassword(App model, Database d, boolean b, String username){
        this.model = model;
        this.b = b;
        this.d = d;
        this.username = username;
        view = new FormChangePassword();
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonSubmit())){
            if(view.getPassword().isEmpty()){
                JOptionPane.showMessageDialog(view, "Password can't be empty.");
            }
            else{
                if(view.getPassword().equals(view.getPasswordRetype())){
                    try{
                        d.updateAccountPassword(username, view.getPassword());
                        JOptionPane.showMessageDialog(view, "Password changed succesfully!");

                        back();
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(view, "Error occured!");
                    }                   
                }
                else{
                    JOptionPane.showMessageDialog(view, "Password do not match!");
                }
            }
        }
        else if(click.equals(view.getButtonCancel())){
            back();
        }
    }
    
    private void back(){
        if(b == true){
            new ControlMenuAdmin(model, d);
            view.dispose();
        }
        else{
            new ControlMenuUser(model, d, username);
            view.dispose();
        }
    }
    
}
