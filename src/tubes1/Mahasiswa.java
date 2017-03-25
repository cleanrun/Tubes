package tubes1;

public class Mahasiswa extends Orang{
    private String nim;
    private String fakultas;
    private int semester;
    private final int sks;
    // butuh array kelas, udah dikasih array kelas
    private int jumlahSks;
    private Kelas[] isiKelas;
    
    public Mahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks){
        super(nama, umur);
        this.nim = nim;
        this.fakultas = fakultas;
        this.semester = semester;   
        this.sks = sks;
        this.jumlahSks = sks;
        
        isiKelas = new Kelas[15];
    }

    public int getSks() {
        return sks;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public int getSisaSks(){
        return jumlahSks;
    }
    
    // add & remove kelas
    
    public void addKelas(Kelas k){
        if(jumlahSks > 0){
            for(int i = 0; i <= isiKelas.length; i++){
                if(isiKelas[i] == null){
                    isiKelas[i] = k;
                    jumlahSks -= k.getSks();
                    break;
                }
            }
        }
    }
    
    public void removeKelas(Kelas k){
        if(jumlahSks > 0){
            for(int i = 0; i <= isiKelas.length; i++){
                if(isiKelas[i] == k){
                    isiKelas[i] = null;
                    jumlahSks += k.getSks();
                    break;
                }
            }
        }
        
    }
    
    public Kelas getKelas(int id){
        return isiKelas[id];
    }
    
    public String getKelasInfo(int id){
        return isiKelas[id].toString();
    }
    
    
    @Override
    public String toString(){
        String nama = "Nama Mhs = " + super.getNama();
        String nim = "NIM = " + this.nim;
        String umur = "Umur = " + super.getUmur();
        String fakultas = "Fakultas = " + this.fakultas;
        String semester = "Semester = " + this.semester;
        String sksto = "SKS = " + this.sks;
        
        return nama + '\n' + nim + '\n' + umur + '\n' + fakultas + '\n' + semester + '\n';        
    }
    
}
