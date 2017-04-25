package Controller;

import Database.Database;
import GUI.FormSignUp;
import Model.Account;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlSignUp implements ActionListener{
    private App model;
    private FormSignUp view;
    private Database d;
    
    
    public ControlSignUp(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormSignUp();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonSignUp())){
            if(view.getFieldUsername().isEmpty()){
                JOptionPane.showMessageDialog(view, "Username can't be empty.");
            }
            else{
            if(view.getCheckBox().isSelected()){
                if(view.getPassword().isEmpty()){
                    JOptionPane.showMessageDialog(view, "Password can't be empty.");
                }
                else{
                    if(view.getPassword().equals(view.getPasswordRetype())){
                        try{
                            Account a = new Account(view.getFieldUsername(), view.getPassword());
                            try{
                                d.saveAccount(a);

                                JOptionPane.showMessageDialog(view, "Account successfully created!");
                                new ControlLogin(model, d);
                                view.dispose();
                            } catch(Exception e){
                                JOptionPane.showMessageDialog(view, "Username already taken.");
                            }
                        } catch(Exception e){
                            JOptionPane.showMessageDialog(view, "Error Occured.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Password do not match");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(view, "You must read and agree the Terms and Conditions");
            }
          }
            
        }
        else if(click.equals(view.getButtonBack())){
            new ControlLogin(model, d);
            view.dispose();
        }
    }
}
