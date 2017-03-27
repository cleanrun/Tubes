package Model;

import Class.Dosen;
import Class.Mahasiswa;

public class Model {
    private Mahasiswa m;
    private Dosen d;
    
    public void setMahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks){
        //Mahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks)
        m = new Mahasiswa(nama, umur, nim, fakultas, semester, sks);
    }
    
    public void setDosen(String nama, int umur, String nip){
        //Dosen(String nama, int umur, String nip)
        d = new Dosen(nama, umur, nip);        
    }
}
