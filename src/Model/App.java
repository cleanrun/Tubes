package Model;

import java.util.ArrayList;

/*
    note :
    - mungkin belom selesai, masih harus ada yang ditambah

*/

public class App {
    private ArrayList<Mahasiswa> listMhs;
    private ArrayList<Dosen> listDosen;
    private ArrayList<Kelas> listKelas;
    private ArrayList<Matakuliah> listMk;
    
    public App(){
        listMhs = new ArrayList();
        listDosen = new ArrayList();
        listKelas = new ArrayList();
        listMk = new ArrayList();
    }
    
    public void load(ArrayList<Mahasiswa> listMhs, ArrayList<Dosen> listDosen, ArrayList<Kelas> listKelas, ArrayList<Matakuliah> listMk){
        this.listMhs = listMhs;
        this.listDosen = listDosen;
        this.listMk = listMk;
        this.listKelas = listKelas;
    }
    
    //method add secara objek
    
    public void addMahasiswa(Mahasiswa m){
        listMhs.add(m);
    }
    
    public void addDosen(Dosen d){
        listDosen.add(d);
    }
    
    public void addKelas(Kelas k){
        listKelas.add(k);
    }
    
    public void addMatakuliah(Matakuliah mk){
        listMk.add(mk);
    }
    
    //method add manual
    
    public void addMahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks){
        listMhs.add(new Mahasiswa(nama, umur, nim, fakultas, semester, sks));
    }
    
    public void addDosen(String nama, int umur, String nip){
        listDosen.add(new Dosen(nama, umur, nip));
    }
    
    public void addKelas(String namaKelas, Matakuliah matkul, Dosen dosen, int jumlahMhs){
        listKelas.add(new Kelas(namaKelas, matkul, dosen, jumlahMhs));
    }
    
    public void addMatakuliah(String namaMk, int jumlahSks, char bWajib){
        listMk.add(new Matakuliah(namaMk, jumlahSks, bWajib));
    }
    
    //method get
    
    public Mahasiswa getMahasiswa(String nim){
        for(Mahasiswa m : listMhs){
            if(m.getNim().equals(nim)){
                return m;
            }
        }
        return null;
    }
    
    public Dosen getDosen(String nip){
        for(Dosen d : listDosen){
            if(d.getNip().equals(nip)){
                return d;
            }
        }
        return null;
    }
    
    public Matakuliah getMatakuliah(String namaMk){
        for(Matakuliah m : listMk){
            if(m.getNamaMk().equals(namaMk)){
                return m;
            }
        }
        return null;
    }
    
    public Kelas getKelas(String namaKelas){
        for(Kelas k : listKelas){
            if(k.getNamaKelas().equals(namaKelas)){
                return k;
            }
        }
        return null;
    }
    
    public ArrayList<Dosen> getListDosen(){
        return listDosen;
    }
    
    public ArrayList<Kelas> getListKelas(){
        return listKelas;
    }
    
    public ArrayList<Mahasiswa> getListMhs(){
        return listMhs;
    }
    
    public ArrayList<Matakuliah> getListMk(){
        return listMk;
    }
}
