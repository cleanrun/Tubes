/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Dosen;
import Model.Kelas;
import Model.Mahasiswa;
import Model.Matakuliah;

/**
 *
 * @author cleanrun
 */
public class TestingField {
    public static void main(String[] args) {
        Database d = new Database();
        //d.connect();
        
        Mahasiswa m1 = new Mahasiswa("Marchell", 19, "1301154278", "FIF", 5, 18);
        Mahasiswa m2 = new Mahasiswa("Fazaliqa", 22, "1111", "FIKOM", 5, 18);
        //d.saveMahasiswa(m);
        //d.saveMahasiswa(m2);

        //d.deleteMahasiswa("1301154278");
        
        Dosen dosen = new Dosen("ahmad", 40, "1301154278");
        //d.saveDosen(dosen);
        //d.deleteDosen("1301154278");
        
        Matakuliah mk = new Matakuliah("Matakuliah 1", 3, 'y');
        Matakuliah mk2 = new Matakuliah("Matakuliah 2", 3, 't');
        //d.saveMatakuliah(mk);
        //d.saveMatakuliah(mk2);
        //d.deleteMatakuliah("Matakuliah 1");
        
        Kelas k = new Kelas("Kelas 1", mk, dosen, 40);
        //d.saveKelas(k);
        //d.deleteKelas("Kelas 1");
        
        //d.updateSetDosen("Mahmud", "Kelas 1");
        
        //d.updateAddMahasiswa("Kelas 1");
        
        //System.out.println(d.loadMahasiswa());
        //System.out.println(d.loadDosen());
        System.out.println(d.loadMatakuliah());
    }
}
