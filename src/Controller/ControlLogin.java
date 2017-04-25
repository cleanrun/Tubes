package Controller;

import Database.Database;
import GUI.FormLogin;
import Model.Account;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlLogin extends MouseAdapter implements ActionListener{
    private App model;
    private FormLogin view;
    private Database d;
    private ArrayList<Account> accounts;
    
    public ControlLogin(App model, Database d){
        this.model = model;
        this.d = d;
        view = new FormLogin();
        view.setActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        
        loadAccounts();
    }
    
    private void loadAccounts(){
        accounts = d.loadAccount();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonLogin())){
            //String getUsername = view.getUsername();
            try{
                /*
                if(view.getUsername().equals("administrator") && view.getPassword().equals("password") == true){
                    new ControlMenuAdmin(model, d);
                    view.dispose();
                }
                */
                if(view.getUsername().equals("administrator")){
                    Account a = d.getAccount("administrator");
                    
                    if(view.getPassword().equals(a.getPassword())){
                        new ControlMenuAdmin(model, d);
                        view.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Wrong username or Password!");
                    }
                }
                else{
                    Account getAccount = d.getAccount(view.getUsername());

                    if(view.getPassword().equals(getAccount.getPassword())){
                        new ControlMenuUser(model, d, view.getUsername());
                        view.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Wrong username or Password!");
                    }
                }
            } catch(NullPointerException e){
                JOptionPane.showMessageDialog(view, "Wrong username or Password!");
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error occured, restart the program");
                System.exit(0);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        Object click = me.getSource();
        
        if(click.equals(view.getSignUp())){
            new ControlSignUp(model, d);
            view.dispose();
            
            //JOptionPane.showMessageDialog(view, "Click!");
        }
    }
}
