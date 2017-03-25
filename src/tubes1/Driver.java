package tubes1;

/*
    Keterangan program ==
    1. Database info masih berbentuk array (Belom jadi SQL)
    2. masih belom selesai (dikit lagi kayaknya)
*/

import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        boolean exit = false;
        Menu m = new Menu(); // Menu object (on progress)
        
        do {
        m.pilMenuMain();
        
        try {
            Scanner inp = new Scanner(System.in);
            int scaninp = inp.nextInt();
            
                switch(scaninp){
                    case 1 :
                        //System.out.println("Maintenance.");
                        m.menuAdmin();
                        break;
                    case 2 :
                        //System.out.println("maintenance");
                        m.menuUser();
                        break;
                    case 0 :
                        exit = true;
                        System.out.println("Exit program...");
                        break;
                    default :
                        System.out.println("Input error, restart the program.");
                        break;
                }
            }
        
        catch(Exception e){
            System.out.println("Input Error, restart the program.");
        }
        
        } while(exit == false);
    }  
}
