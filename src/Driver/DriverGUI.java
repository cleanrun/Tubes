package Driver;

import Controller.ControlLogin;
import Database.Database;
import Model.App;
import javax.swing.JOptionPane;

public class DriverGUI {
    public static void main(String[] args) {
        try{
            Database d = new Database();

            App aplikasi = new App();
            aplikasi.load(d.loadMahasiswa(), d.loadDosen(), d.loadKelas(), d.loadMatakuliah());

            ControlLogin c = new ControlLogin(aplikasi ,d);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Failed to connect to Database!",
                    "Exception", JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        }
    }
}

/*
    Ya allah mudahkanlah hambamu dalam setiap proses belajar.
    Amin ya rabbal alamin.

    Insyallah sudah selesai.
*/