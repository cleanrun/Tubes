package Controller;

import GUI.FormMenuAdmin;
import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlMenuAdmin implements ActionListener{
    private App model;
    private FormMenuAdmin view;
    
    public ControlMenuAdmin(App model){
        this.model = model;
        view = new FormMenuAdmin();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
               
        if (click.equals(view.getButtonCreate())){
            Object[] options1 = {"Mahasiswa", "Dosen", "Matakuliah", "Kelas"};

            int n = JOptionPane.showOptionDialog(view,
                    "Select what you want to create",
                    "Create option",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options1,
                    options1[0]);
            
            if(n == 0){ //create Mahasiswa
                new ControlMahasiswa(model);
                view.dispose();
            }
            else if(n == 1){ //create Dosen
                new ControlDosen(model);
                view.dispose();
            }
            else if(n == 2){ //create Matakuliah
                new ControlMatakuliah(model);
                view.dispose();
            }
            else if(n == 3){ //create Kelas
                new ControlKelas(model);
                view.dispose();
            }

        }
        else if (click.equals(view.getButtonAdd())){
            JOptionPane.showMessageDialog(view, "Under Maintenance",
                      "", JOptionPane.WARNING_MESSAGE);
        }
        else if (click.equals(view.getButtonInfo())){
            JOptionPane.showMessageDialog(view, "Under Maintenance",
                      "", JOptionPane.WARNING_MESSAGE);
        }
        else{
            new ControlLogin(model);
            view.dispose();
        }
    }
    
}
