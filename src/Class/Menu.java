package Class;

/*
    NOTE UTAMA ==
    - method menu main udah mau selesai, tapi mungkin
       butuh ditambah kode untuk bikin objek baru
       kalo objek nya belom ada di add dosen to
       kelas, dll
    - method otw sederhana
*/

import java.util.Scanner;

public class Menu {
    
    // database masih bentuk array, bersifat sementara
    // tes sebelum masuk ke database
    private Mahasiswa[] arrayMhs = new Mahasiswa[100];
    private Matakuliah[] arrayMk = new Matakuliah[100];
    private Dosen[] arrayD = new Dosen[100];
    private Kelas[] arrayK = new Kelas[100];
    
    
    // Method method menu dan inputan
    // butuh method bagian admin
    // butuh method bagian user
    
    public void pilMenuMain(){
        System.out.println("-----------Menu-----------");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai User");
        System.out.println("0. Exit");
    }
    
    public void pilMenuAdmin(){
        System.out.println("Menu Admin");
        System.out.println("1.  Create mahasiswa");
        System.out.println("2.  Create Dosen");
        System.out.println("3.  Create Matakuliah");
        System.out.println("4.  Create Kelas");
        System.out.println("5.  Add dosen to Kelas");
        System.out.println("6.  Add mahasiswa to Kelas");
        System.out.println("7.  Add matakuliah to Kelas");
        System.out.println("8.  Info mahasiswa");
        System.out.println("9.  Info Dosen");
        System.out.println("10. Info kelas");
        System.out.println("0.  Exit to main menu");
    }
    
    public void pilMenuUser(){
        System.out.println("Menu User");
        System.out.println("1. New Mahasiswa");
        System.out.println("2. Add Kelas to Mahasiswa");
        System.out.println("3. Get Info");
        System.out.println("0. Exit");
    }
    
    // input mahasiswa ke array arrayMhs
    private void inpArrayMahasiswa(Mahasiswa m){
        for(int i = 0; i <= arrayMhs.length; i++){
            if(arrayMhs[i] == null){
                arrayMhs[i] = m;
                break;
            }
        }
    }
    
    // input matakuliah ke array arrayMk
    private void inpArrayMatakuliah(Matakuliah m){
        for(int i = 0; i <= arrayMk.length; i++){
            if(arrayMk[i] == null){
                arrayMk[i] = m;
                break;
            }
        }
    }
    
    // input dosen ke array arrayD
    private void inpArrayDosen(Dosen d){
        for(int i = 0; i <= arrayD.length; i++){
            if(arrayD[i] == null){
                arrayD[i] = d;
                break;
            }
        }
    }
    
    // input kelas ke array arrayK
    private void inpArrayKelas(Kelas k){
        for(int i = 0; i <= arrayK.length; i++){
            if(arrayK[i] == null){
                arrayK[i] = k;
                break;
            }
        }
    }
    
    // bikin mahasiswa
    private void instMhs(){
        Scanner nama = new Scanner(System.in);
        Scanner umur = new Scanner(System.in);
        Scanner nim = new Scanner(System.in);
        Scanner fakultas = new Scanner(System.in);
        Scanner semester = new Scanner(System.in);
        Scanner sks = new Scanner(System.in);
            System.out.print("Nama mhs = ");     String inpNama = nama.nextLine();
            System.out.print("Umur mhs = ");     int inpUmur = umur.nextInt();
            System.out.print("NIM mhs = ");      String inpNim = nim.nextLine();
            System.out.print("Fakultas mhs = "); String inpFakultas = fakultas.nextLine();
            System.out.print("Semester mhs = "); int inpSemester = semester.nextInt();
            System.out.print("SKS mhs = ");      int inpSks = sks.nextInt();
                            
            Mahasiswa mhs = new Mahasiswa(inpNama, inpUmur, inpNim, inpFakultas, inpSemester, inpSks);
            inpArrayMahasiswa(mhs);
    }
    
    // bikin dosen
    private void instDosen(){
        Scanner namaD = new Scanner(System.in);
        Scanner umurD = new Scanner(System.in);
        Scanner nipD = new Scanner(System.in);
            System.out.print("Nama dosen = "); String inpNamaD = namaD.nextLine();
            System.out.print("Umur dosen = "); int inpUmurD = umurD.nextInt();
            System.out.print("NIP dosen = ");  String inpNipD = nipD.nextLine();
                        
            Dosen dosen = new Dosen(inpNamaD, inpUmurD, inpNipD);
            inpArrayDosen(dosen);
    }
    
    // bikin matakuliah
    private void instMk(){
        Scanner namaMk = new Scanner(System.in);
        Scanner jumlahSksMk = new Scanner(System.in);
        Scanner bWajibMk = new Scanner(System.in);
            System.out.print("Nama matakuliah = ");      String inpNamaMk = namaMk.nextLine();
            System.out.print("SKS matakuliah  = ");      int inpJumlahSksMk = jumlahSksMk.nextInt();
            System.out.print("Status (Wajib/tidak) = "); char inpBWajibMk = bWajibMk.next().charAt(0);
                            
            Matakuliah mk = new Matakuliah(inpNamaMk, inpJumlahSksMk, inpBWajibMk);
            inpArrayMatakuliah(mk);    
    }
    
    // bikin kelas
    private void instKelas(){
        Scanner namaK = new Scanner(System.in);
        Scanner matakuliahK = new Scanner(System.in);
        Scanner dosenK = new Scanner(System.in);
        Scanner jumlahmhsK = new Scanner(System.in);
            System.out.print("Nama Kelas = "); String inpNamaK = namaK.nextLine();
            System.out.print("id Matakuliah di Kelas = "); int inpMatakuliahK = matakuliahK.nextInt();
            System.out.print("id Dosen matakuliah = "); int inpDosenK = dosenK.nextInt();
            System.out.print("Jumlah tampung mahasiswa = "); int inpJumlahmhsK = jumlahmhsK.nextInt();
                            
            Kelas k = new Kelas(inpNamaK, arrayMk[inpMatakuliahK], arrayD[inpDosenK], inpJumlahmhsK);
            inpArrayKelas(k);    
    }
    
    // perlu diringkas lagi, yang "add%" belom selesai
    public void menuAdmin(){
        boolean exit = false;
        
        do{
            pilMenuAdmin();
            
            try{
                Scanner inp = new Scanner(System.in);
                int scaninp = inp.nextInt();
                
                switch(scaninp){
                    case 1 : // Create Mahasiswa
                        // Mahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks)
                        try{
                            instMhs();
                        } catch (Exception e){
                            System.out.println("Failed to create Mahasiswa");
                        }
                        
                        break;
                    case 2 : // Create Dosen
                        // Dosen(String nama, int umur, String nip)
                        try{
                            instDosen();
                        } catch(Exception e){
                            System.out.println("Failed to create Dosen");
                        }
                        
                        break;
                    case 3 : // Create Matakuliah
                        // Matakuliah(String namaMk, int jumlahSks, char bWajib)
                        try{
                            instMk();
                        } catch(Exception e){
                            System.out.println("Failed to create Matakuliah");
                        }                       
                        
                        break;
                    case 4 : // Create Kelas
                        // Kelas(String namaKelas, Matakuliah matkul, Dosen dosen, int jumlahMhs)
                        try{
                            instKelas();
                        } catch(Exception e){
                            System.out.println("Failed to create kelas");
                        }
                        
                        break;
                    case 5 : // Add dosen to kelas
                        Scanner idD = new Scanner(System.in);
                        Scanner idK = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Dosen yang dipilih = "); int inpIdD = idD.nextInt();
                            System.out.print("id Kelas yang dipilih = "); int inpIdK = idK.nextInt();
                            
                            if(arrayD[inpIdD] != null && arrayK[inpIdK] != null){
                                arrayK[inpIdK].setDosen(arrayD[inpIdD]);
                            }
                            else if(arrayD[inpIdD] != null && arrayK[inpIdK] == null){
                                instKelas();
                                // belom jadi
                            }
                            else if(arrayD[inpIdD] == null && arrayK[inpIdK] != null){
                                instDosen();
                                // belom jadi
                            }
                            else if(arrayD[inpIdD] == null && arrayK[inpIdK] == null){
                                instKelas();
                                instDosen();
                                // belom jadi
                            }
                            else{
                                System.out.println("Failed to set dosen to kelas");
                            }
                        } catch(Exception e){
                            System.out.println("Failed to set dosen to kelas");
                        }
                        break;
                    case 6 : // Add mahasiswa to kelas
                        Scanner idMhs = new Scanner(System.in);
                        Scanner idKelas = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Mahasiswa yang dipilih = "); int inpIdMhs = idMhs.nextInt();
                            System.out.print("id Kelas yang dipilih = "); int inpIdKelas = idKelas.nextInt();
                            
                            if(arrayMhs[inpIdMhs] != null && arrayK[inpIdKelas] != null){
                                arrayK[inpIdKelas].addMhs(arrayMhs[inpIdMhs]);
                            }
                            else{
                                System.out.println("Failed to add mahasiswa to kelas");
                            }
                        } catch(Exception e){
                            System.out.println("Failed to add mahasiswa to kelas");
                        }
                        
                        break;
                    case 7 : // Add matakuliah to kelas
                        Scanner idMatkul = new Scanner(System.in);
                        Scanner idkelas = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Matakuliah yang dipilih = "); int inpIdMatkul = idMatkul.nextInt();
                            System.out.print("id Kelas yang dipilih = "); int inpIdkelas = idkelas.nextInt();
                            
                            if(arrayMk[inpIdMatkul] != null && arrayK[inpIdkelas] != null){
                                arrayK[inpIdkelas].setMatkul(arrayMk[inpIdMatkul]);
                            }
                            else{
                                System.out.println("Failed to set matakuliah to kelas");
                            }
                            
                        } catch(Exception e){
                            System.out.println("Failed to set matakuliah to kelas");
                        }
                        break;
                    case 8 : // info Mahasiswa
                        Scanner a = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Mahasiswa = "); int inpA = a.nextInt();
                            
                            if(arrayMhs[inpA] != null){
                                System.out.println(arrayMhs[inpA]);
                            }
                            else{
                                System.out.println("Mahasiswa doesn't exist");
                            }
                        } catch(Exception e){
                            System.out.println("Failed to get info mahasiswa");
                        }
                        break;
                    case 9 : // info Dosen
                        Scanner b = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Dosen = "); int inpB = b.nextInt();
                            
                            if(arrayD[inpB] != null){
                                System.out.println(arrayD[inpB]);
                            }
                            else{
                                System.out.println("Dosen doesn't exist");
                            }
                        } catch(Exception e){
                            System.out.println("Failed to get info mahasiswa");
                        }
                        break;
                    case 10 : // info kelas
                        Scanner c = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Kelas = "); int inpC = c.nextInt();
                            
                            if(arrayK[inpC] != null){
                                System.out.println(arrayK[inpC]);
                            }
                            else{
                                System.out.println("Kelas doesn't exist");
                            }
                        } catch(Exception e){
                            System.out.println("Failed to get info kelas");
                        }
                        break;                    
                    case 0 : // Exit
                        exit = true;
                        break;
                    default :
                        System.out.println("Input Error, restart the program");
                        break;
                        
                }
            }
            catch(Exception e){
                System.out.println("Input Error, restart the program");
            }
            
        } while(exit == false);
        
    }
    
    public void menuUser(){
        boolean exit = false;
        
        do{
            pilMenuUser();
            
            try{
                Scanner inp = new Scanner(System.in);
                int scaninp = inp.nextInt();
                
                switch(scaninp){
                    case 1 : // New Mahasiswa
                        // Mahasiswa(String nama, int umur, String nim, String fakultas, int semester, int sks)
                        try{
                            instMhs();
                        } catch (Exception e){
                            System.out.println("Failed to create Mahasiswa");
                        }
                        
                        break;
                    case 2 : // Add kelas to mahasiswa
                        Scanner a = new Scanner(System.in);
                        Scanner b = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Mahasiswa = "); int inpA = a.nextInt();
                            System.out.print("id Kelas = "); int inpB = b.nextInt();
                            
                            if(arrayMhs[inpA] != null && arrayK[inpB] != null){
                                arrayMhs[inpA].addKelas(arrayK[inpB]);
                            }
                            else{
                                System.out.println("Failed to add kelas to mahasiwa");
                            }
                            
                        } catch(Exception e){
                            System.out.println("Failed to add kelas to mahasiwa");
                        }
                        
                        break;
                    case 3 : // Get info
                        Scanner c = new Scanner(System.in);
                        
                        try{
                            System.out.print("id Mahasiswa = "); int inpC = c.nextInt();
                            
                            if(arrayMhs[inpC] != null){
                                System.out.println(arrayMhs[inpC]);
                            }
                            else{
                                System.out.println("Mahasiswa doesn't exist");
                            }
                        } catch(Exception e){
                            System.out.println("Failed to get info mahasiswa");
                        }
                        
                        break;
                    case 0 : // Exit
                        exit = true;
                        break;
                    default :
                        System.out.println("Invalid input, restart the program");
                        break;
                }
                
            } catch(Exception e){
                System.out.println("Invalid input, restart the program");
            }
        } while(exit == false);
    }
}
