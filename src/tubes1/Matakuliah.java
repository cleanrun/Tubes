package tubes1;

public class Matakuliah {
    private String namaMk;
    private int jumlahSks;
    private boolean wajib;
    
    public Matakuliah(String namaMk, int jumlahSks, char bWajib){
        this.namaMk = namaMk;
        this.jumlahSks = jumlahSks;
        if(bWajib == 'y'){
            this.wajib = true;
        }
        else{
            this.wajib = false;
        }
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public int getJumlahSks() {
        return jumlahSks;
    }

    public void setJumlahSks(int jumlahSks) {
        this.jumlahSks = jumlahSks;
    }

    public boolean isWajib() {
        return wajib;
    }
    
    public String getWajib(){
        if(this.wajib == true){
            return "Ya";
        }
        else{
            return "tidak";
        }
    }

    public void setWajib(char bWajib) {
        if(bWajib == 'y'){
            this.wajib = true;
        }
        else{
            this.wajib = false;
        }
    }
    
    @Override
    public String toString(){
        String namaMk = "Nama Matakuliah = " + this.namaMk;
        String jumlahSks = "SKS = " + this.jumlahSks;
        String wajib = "Wajib = " + getWajib();
        
        return namaMk + '\n' + jumlahSks + '\n' + wajib + '\n';
    }
    
    
}
