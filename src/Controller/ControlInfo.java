package Controller;

import GUI.FormInfo;
import Model.App;
import Model.Dosen;
import Model.Kelas;
import Model.Mahasiswa;
import Model.Matakuliah;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControlInfo extends MouseAdapter implements ActionListener{
    private App model;
    private FormInfo view;
    private boolean b;
    
    public ControlInfo(App model, boolean b){
        this.model = model;
        this.b = b;
        view = new FormInfo();
        view.setActionListener(this);
        view.setVisible(true);
    }
    
    private String[] getList(){
        String[] daftar;
        
        if(view.getComboBoxList() == "Mahasiswa"){
            daftar = new String[model.getListMhs().size()];
            for(int i = 0; i < daftar.length; i++){
                daftar[i] = model.getListMhs().get(i).getNama();
            }
            return daftar;
        }
        else if(view.getComboBoxList() == "Dosen"){
            daftar = new String[model.getListDosen().size()];
            for(int i = 0; i < daftar.length; i++){
                daftar[i] = model.getListDosen().get(i).getNama();
            }
            return daftar;
        }
        else if(view.getComboBoxList() == "Matakuliah"){
            daftar = new String[model.getListMk().size()];
            for(int i = 0; i < daftar.length; i++){
                daftar[i] = model.getListMk().get(i).getNamaMk();
            }
            return daftar;
        }
        else if(view.getComboBoxList() == "Kelas"){
            daftar = new String[model.getListKelas().size()];
            for(int i = 0; i < daftar.length; i++){
                daftar[i] = model.getListKelas().get(i).getNamaKelas();
            }
            return daftar;
        }
        return null;
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getButtonGet())){
            view.setList(getList());
        }
        else if(click.equals(view.getButtonBack())){
            back();
        }
        else if(click.equals(view.getButtonGetInfo())){
            try{
                //int i = view.getSelectedList();
                if(view.getComboBoxList() == "Mahasiswa"){
                    int i = view.getSelectedList();
                    Mahasiswa m = model.getListMhs().get(i);
                    view.setTextArea(m.toString());
                }
                else if(view.getComboBoxList() == "Dosen"){
                    int i = view.getSelectedList();
                    Dosen d = model.getListDosen().get(i);
                    view.setTextArea(d.toString());
                }
                else if(view.getComboBoxList() == "Matakuliah"){
                    int i = view.getSelectedList();
                    Matakuliah mk = model.getListMk().get(i);
                    view.setTextArea(mk.toString());
                }
                else if(view.getComboBoxList() == "Kelas"){
                    int i = view.getSelectedList();
                    Kelas k = model.getListKelas().get(i);
                    view.setTextArea(k.toString());
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(view, "Null selection!",
                      "", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(click.equals(view.getButtonDelete())){
            if(view.getComboBoxList() == "Mahasiswa"){
                try{
                    int i = view.getSelectedList();
                    model.getListMhs().remove(i);
                    view.clearTextArea();
                    view.setList(getList());
                } catch(Exception e){
                    JOptionPane.showMessageDialog(view, "Doesn't exist!",
                      "", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(view.getComboBoxList() == "Dosen"){
                try{
                    int i = view.getSelectedList();
                    model.getListDosen().remove(i);
                    view.clearTextArea();
                    view.setList(getList());
                } catch(Exception e){
                    JOptionPane.showMessageDialog(view, "Doesn't exist!",
                      "", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(view.getComboBoxList() == "Matakuliah"){
                try{
                    int i = view.getSelectedList();
                    model.getListMk().remove(i);
                    view.clearTextArea();
                    view.setList(getList());
                } catch(Exception e){
                    JOptionPane.showMessageDialog(view, "Doesn't exist!",
                      "", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(view.getComboBoxList() == "Kelas"){
                try{
                    int i = view.getSelectedList();
                    model.getListKelas().remove(i);
                    view.clearTextArea();
                    view.setList(getList());
                } catch(Exception e){
                    JOptionPane.showMessageDialog(view, "Doesn't exist!",
                      "", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
    
    // belom berfungsi
    
    @Override
    public void mousePressed(MouseEvent me){
        Object click = me.getSource();   
        
        if(click.equals(view.getList())){
            int i = view.getSelectedList();
            if(view.getComboBoxList() == "Mahasiswa"){
                //int i = view.getSelectedList();
                Mahasiswa m = model.getListMhs().get(i);
                view.setTextArea(m.toString());
            }
            else if(view.getComboBoxList() == "Dosen"){
                //int i = view.getSelectedList();
                Dosen d = model.getListDosen().get(i);
                view.setTextArea(d.toString());
            }
            else if(view.getComboBoxList() == "Matakuliah"){
                //int i = view.getSelectedList();
                Matakuliah mk = model.getListMk().get(i);
                view.setTextArea(mk.toString());
            }
            else if(view.getComboBoxList() == "Kelas"){
                //int i = view.getSelectedList();
                Kelas k = model.getListKelas().get(i);
                view.setTextArea(k.toString());
            }
        }       
    }
    
    private void back(){
        if(b == true){
            new ControlMenuAdmin(model);
            view.dispose();
        }
        else{
            new ControlMenuUser(model);
            view.dispose();
        }
    }
    
}
