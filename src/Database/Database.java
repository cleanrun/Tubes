package Database;

import Model.*;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
    Notes :
    - Method yang udah masih dalam tahap coba, belom bisa diimplementasikan ke controller
    - on progress
*/

public class Database {
    private Connection connection;
    private String address;
    private String username;
    private String password;
    
    public Database(){
        connect();
    }
    
    /*
    public void setProperties(String address, String username, String password){
        this.address = address;
        this.username = username;
        this.password = password;             
    }
    */
    
    private void connect(){
        this.address = "jdbc:mysql://localhost:3306/db_tubes";
        this.username = "cleanrun";
        this.password = "bismillah";
        
        try{
            connection = DriverManager.getConnection(address, username, password);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            System.out.println("Connected successfully!");
        } catch(SQLException e){
            System.out.println("Connection failed");
        }
    }
    
    public void saveMahasiswa(Mahasiswa m){       
        try{
            Statement s = connection.createStatement();
            String query = "INSERT INTO `mahasiswa` "
                    + "(`id`, `nama`, `umur`, `nim`, `fakultas`, `semester`, `sks`) "
                    + "VALUES (NULL, '"+ m.getNama()+"', '"+m.getUmur()+"', '"+m.getNim()+"',"
                    + " '"+m.getFakultas()+"', '"+m.getSemester()+"', '"+m.getSks()+"');";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();           
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void saveDosen(Dosen d){
        try{
            Statement s = connection.createStatement();
            String query = "INSERT INTO `dosen`(`id`, `nama`, `umur`, `nip`)"
                    + " VALUES (NULL,'"+ d.getNama() +"','"+ d.getUmur() +"','"+ d.getNip() +"')";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void saveMatakuliah(Matakuliah mk){
        try{
            Statement s = connection.createStatement();
            String query = "INSERT INTO `matakuliah`(`id`, `namamk`, `jmlhsks`, `wajib`) "
                    + "VALUES (NULL,'"+mk.getNamaMk()+"','"+mk.getJumlahSks()+"','"+mk.getWajib()+"')";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void saveKelas(Kelas k){
        try{
            Statement s = connection.createStatement();
            String query = "INSERT INTO `kelas`(`id`, `namakelas`, `matakuliah`, `dosen`, `jumlahmhs`)"
                    + " VALUES (NULL, '"+k.getNamaKelas()+"','"+k.getMatkul().getNamaMk()+"',"
                    + "'"+k.getDosen().getNama()+"','"+k.getJumlahMhs()+"')";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void deleteMahasiswa(String nim){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `mahasiswa` WHERE nim='"+nim+"'";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void deleteDosen(String nip){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `dosen` WHERE nip='"+nip+"'";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void deleteMatakuliah(String namamk){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `matakuliah` WHERE namamk='"+namamk+"'";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void deleteKelas(String namakelas){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `kelas` WHERE namakelas='"+namakelas+"'";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void updateSetDosen(String namaDosen, String namaKelas){
        try{
            Statement s = connection.createStatement();
            String query = "UPDATE kelas SET dosen='"+ namaDosen +"' WHERE namakelas='"+ namaKelas +"'";
            
            //System.out.println(query);
            
            s.executeUpdate(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void updateSetMatakuliah(String namaMk, String namaKelas){
        try{
            Statement s = connection.createStatement();
            String query = "UPDATE kelas SET matakuliah='"+ namaMk +"' WHERE namakelas='"+ namaKelas +"'";
            
            //System.out.println(query);
            
            s.executeUpdate(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public void updateAddMahasiswa(String namaKelas, String namaMahasiswa){
        try{
            int jumlahmhs = 0;           
            
            Statement s = connection.createStatement();
            String query1 = "SELECT jumlahmhs FROM kelas WHERE namakelas='"+ namaKelas +"'";
            ResultSet rs = s.executeQuery(query1);
            
            while(rs.next()){
                jumlahmhs = rs.getInt(1);
            }
            
            int jumlahmhsafter = jumlahmhs - 1;
            
            String query2 = "UPDATE kelas SET jumlahmhs='"+ jumlahmhsafter +"' WHERE namakelas='"+ namaKelas +"'";
            s.executeUpdate(query2);
            connection.commit();
            s.close();
            
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Mahasiswa> loadMahasiswa(){
        try{
            ArrayList<Mahasiswa> listmhs = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM mahasiswa";
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
                Mahasiswa m = new Mahasiswa(rs.getString("nama"), rs.getInt("umur"), 
                        rs.getString("nim"), rs.getString("fakultas"), 
                        rs.getInt("semester"), rs.getInt("sks"));
                
                listmhs.add(m);
            }
            
            return listmhs;  
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public ArrayList<Dosen> loadDosen(){
        try{
            ArrayList<Dosen> listdosen = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM dosen";
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
                Dosen d = new Dosen(rs.getString("nama"), rs.getInt("umur"), rs.getString("nip"));
                listdosen.add(d);
            }
            
            return listdosen;  
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<Matakuliah> loadMatakuliah(){
        try{
            ArrayList<Matakuliah> listmk = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM matakuliah";
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
                Matakuliah mk = new Matakuliah(rs.getString("namamk"), rs.getInt("jmlhsks"), 
                        rs.getString("wajib").charAt(0));
                listmk.add(mk);
            }
            
            return listmk;  
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public ArrayList<Kelas> loadKelas(){
        try{
            ArrayList<Kelas> listkelas = new ArrayList();
            
            Statement s = connection.createStatement();
            String querykelas = "SELECT * FROM kelas";
            ResultSet rskelas = s.executeQuery(querykelas);
            
            while(rskelas.next()){
                Statement sdosen = connection.createStatement();
                String querydosen = "SELECT * FROM dosen WHERE nama='"+rskelas.getString("dosen")+"'";
                ResultSet rsdosen = sdosen.executeQuery(querydosen);

                while(rsdosen.next()){
                    Dosen d = new Dosen(rsdosen.getString("nama"), 
                            rsdosen.getInt("umur"), rsdosen.getString("nip"));
                    
                    Statement smk = connection.createStatement();
                    String querymk = "SELECT * FROM matakuliah WHERE namamk='"+ rskelas.getString("matakuliah") +"'";
                    ResultSet rsmk = smk.executeQuery(querymk);
                
                    while(rsmk.next()){
                        Matakuliah mk = new Matakuliah(rsmk.getString("namamk"), 
                                rsmk.getInt("jmlhsks"), rsmk.getString("wajib").charAt(0));
                        
                        Kelas k = new Kelas(rskelas.getString("namakelas"), mk, d, rskelas.getInt("jumlahmhs"));
                        listkelas.add(k);
                    }
                }
            }
            
            return listkelas;
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        return null;
    }
    
    //-----------------------------------------------------------------------------------------------------------
    
    // Account methods
    
        
    public void saveAccount(Account a) throws MySQLIntegrityConstraintViolationException, SQLException{
            Statement s = connection.createStatement();
            String query = "INSERT INTO account (username, password) "
                    + "VALUES ('"+a.getUsername()+"', '"+a.getPassword()+"')";
            s.execute(query);
            connection.commit();
            s.close();
    }
    
    public Account getAccount(String username){
        try{
            Statement s = connection.createStatement();
            String query = "SELECT * FROM account WHERE username='"+ username +"'";
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                Account a = new Account(rs.getString("username"), rs.getString("Password"));
                return a;
            }
            
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        return null;
    }

    
    public void deleteAccount(String username){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM account WHERE username='"+username+"'";
            
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }

    public void updateAccountPassword(String username, String password){
        try{
            Statement s = connection.createStatement();
            String query = "UPDATE account SET password='"+password+"' WHERE username='"+username+"'";
            
            s.executeUpdate(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }

    public ArrayList<Account> loadAccount(){
        try{
            ArrayList<Account> listaccount = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM account";
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
                Account a = new Account(rs.getString("username"), rs.getString("password"));
                listaccount.add(a);
            }
            
            return listaccount;
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        
        return null;
    }
    
}
