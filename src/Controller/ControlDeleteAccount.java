package Controller;

import Database.Database;
import GUI.FormDeleteAccount;
import Model.Account;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlDeleteAccount implements ActionListener{
    private App model;
    private FormDeleteAccount view;
    private Database d;
    private String username;
    
    public ControlDeleteAccount(App model, Database d, String username){
        this.model = model;
        this.d = d;
        this.username = username;
        view = new FormDeleteAccount();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        Account a;
        
        a = d.getAccount(username);
        
        if(click.equals(view.getButtonDelete())){
            if(view.getPassword().isEmpty()){
                JOptionPane.showMessageDialog(view, "Field can't be null!", "", JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(view.getPassword().equals(a.getPassword())){
                    if(view.getPassword().equals(view.getPasswordRetype())){
                        try{
                            int n = JOptionPane.showConfirmDialog(view, "Are you sure you want to delete your account?",
                                    "We'll miss you!", JOptionPane.YES_NO_OPTION);
                            if(n == 0){
                                d.deleteAccount(username);
                                new ControlLogin(model, d);
                                view.dispose();
                            }
                            else{
                                new ControlMenuUser(model, d, username);
                                view.dispose();
                            }
                        } catch(Exception e){
                            JOptionPane.showMessageDialog(view, "Error occured");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Password do not match!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(view, "Wrong password!", "", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(click.equals(view.getButtonCancel())){
            new ControlMenuUser(model, d, username);
            view.dispose();
        }
    }
}
