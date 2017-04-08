package Driver;

import Controller.ControlLogin;
import Model.App;
import javax.swing.JOptionPane;

public class DriverGUI {
    /*
        note :
        - console menu belom ada
        - on progress
    */
    
    public static void main(String[] args) {
        App aplikasi = new App();
        ControlLogin c = new ControlLogin(aplikasi);
    }
}
