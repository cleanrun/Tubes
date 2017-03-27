package Controller;

import Class.Mahasiswa;
import GUI.FormMahasiswa;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMahasiswa {
    private FormMahasiswa gui;
    private Model model;
    
    public ControlMahasiswa(FormMahasiswa gui, Model model){
        this.gui = gui;
        this.model = model;
        this.gui.btnInputPerformed(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Mahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks)
                String getNama  = gui.getInpNamaMahasiswa();
                int getUmur     = gui.getJSpinnerUmur();
                String getNim   = gui.getInpNim();
                String getFak   = gui.getInpFakultas();
                int getSemester = gui.getInpSemester();
                int getSks      = gui.getJSpinnerSks();
                
                model.setMahasiswa(getNama, getUmur, getNim, getFak, getSemester, getSks);
            }
            
        });
    }
    
   
}
