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
            
            try{
                String[] options1 = {"Mahasiswa", "Dosen", "Matakuliah", "Kelas"};

                int n = JOptionPane.showOptionDialog(view,
                        "Select what you want to create",
                        "Create option",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options1,
                        options1[0]);
            
                if(n == 0){ //create Mahasiswa
                    new ControlMahasiswa(model, true);
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
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                      "", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (click.equals(view.getButtonAdd())){
            
            try{
                String[] options2 = {"Set Dosen", "Add Mahasiswa", "Set Matakuliah"};

                int a = JOptionPane.showOptionDialog(view,
                        "Select what you want to do",
                        "Add/Set to Kelas option",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options2,
                        options2[0]);

                if(a == 0){ //set Dosen
                    new ControlSetDosen(model);
                    view.dispose();
                }
                else if(a == 1){ //Add Mahasiswa
                    new ControlAddMahasiswa(model, true);
                    view.dispose();
                }
                else if(a == 2){ //Set Matakuliah
                    new ControlSetMatakuliah(model);
                    view.dispose();
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Error input",
                      "", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (click.equals(view.getButtonInfo())){
            new ControlInfo(model, true);
            view.dispose();
            
            
            /*JOptionPane.showMessageDialog(view, "Under Maintenance",
                      "", JOptionPane.WARNING_MESSAGE);
            */
        }
        else{
            new ControlLogin(model);
            view.dispose();
        }
    }
    
}
