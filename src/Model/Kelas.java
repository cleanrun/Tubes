package Model;

public class Kelas {
    private String namaKelas;
    private Matakuliah matkul;
    private Dosen dosen;
    private Mahasiswa[] isiMhs;
    private final int jumlahMhs;
    private final int sks;
    
    public Kelas(String namaKelas, Matakuliah matkul, Dosen dosen, int jumlahMhs){
        this.namaKelas = namaKelas;
        this.matkul = matkul;
        this.dosen = dosen;
        this.jumlahMhs = jumlahMhs;
        this.sks = matkul.getJumlahSks();
        isiMhs = new Mahasiswa[jumlahMhs];
    }
    
    
    // Getter
    public String getNamaKelas() {
        return namaKelas;
    }
    
    public void setMatkul(Matakuliah m){
        this.matkul = m;
    }

    public Matakuliah getMatkul() {
        return matkul;
    }
    
    public void setDosen(Dosen d){
        this.dosen = d;
    }
    
    public Dosen getDosen() {
        return dosen;
    }

    public Mahasiswa getMhs(int id) {
        return isiMhs[id];
    }

    public int getJumlahMhs() {
        return jumlahMhs;
    }

    public int getSks() {
        return sks;
    }
    
    public void addMhs(Mahasiswa m){
        for(int i = 0; i <= isiMhs.length; i++){
            if(isiMhs[i] == null){
                isiMhs[i] = m;
                break;
            }
        }
    }
    
    @Override
    public String toString(){
        String namakelas = "Kelas " + namaKelas;
        String dosenpengajar = "Dosen = " + dosen.getNama();
        String kapasitas = "Kapasitas kelas = " + jumlahMhs;
        String sks = "SKS = " + this.sks;
        
        return namakelas + '\n' + dosenpengajar + '\n' + kapasitas + '\n' + sks;
        
     }    
}
