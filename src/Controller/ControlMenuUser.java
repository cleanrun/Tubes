package Controller;

import GUI.FormMenuUser;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMenuUser implements ActionListener{
    private App model;
    private FormMenuUser view;

    public ControlMenuUser(App model){
        this.model = model;
        view = new FormMenuUser();
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonNew())){
            new ControlMahasiswa(model, false);
            view.dispose();
        }
        else if(click.equals(view.getButtonAdd())){
            new ControlAddMahasiswa(model, false);
            view.dispose();
        }
        else if(click.equals(view.getButtonInfo())){
            //JOptionPane.showMessageDialog(view, "Under maintanence", "", JOptionPane.WARNING_MESSAGE);
            
            
            new ControlInfo(model, false);
            view.dispose();
            
        }
        else if(click.equals(view.getButtonExit())){
            new ControlLogin(model);
            view.dispose();
        }
    }
}
