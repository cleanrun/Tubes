package tubes1;

public class Dosen extends Orang{
    private String nip;
    
    public Dosen(String nama, int umur, String nip){
        super(nama, umur);
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    @Override
    public String toString(){
        String nama = "Nama Dosen = " + super.getNama();
        String nip = "NIP = " + this.nip;
        String umur = "Umur = " + super.getUmur();
        
        return nama + '\n' + nip + '\n' + umur + '\n';
    }
}
