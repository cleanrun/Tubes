package Driver;

import Controller.ControlLogin;
import Database.Database;
import Model.App;

public class DriverGUI {
    public static void main(String[] args) {
        Database d = new Database();
        
        App aplikasi = new App();
        aplikasi.load(d.loadMahasiswa(), d.loadDosen(), d.loadKelas(), d.loadMatakuliah());
        
        ControlLogin c = new ControlLogin(aplikasi ,d);
    }
}

/*
    Ya allah mudahkanlah hambamu dalam setiap proses belajar.
    Amin ya rabbal alamin.
*/