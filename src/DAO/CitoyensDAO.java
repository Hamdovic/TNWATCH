/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entities.Citoyens;
import Entities.Personne;
import Util.MyConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CitoyensDAO {
  
public List<Citoyens> DisplayAlnoncitoyen (){


        List<Citoyens> listCitoyens = new ArrayList<Citoyens>();

        String requete = "select Login,Cin,Nom,Prenom,Email,Telephone from citoyens where confirmation=0";
      
           try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Citoyens citoyen =new Citoyens();
                  citoyen.setLogin(resultat.getString(1));
               citoyen.setCin(resultat.getInt(2));
                citoyen.setNom(resultat.getString(3));
                citoyen.setPrenom(resultat.getString(4));
                 citoyen.setEmail(resultat.getString(5));
                  citoyen.setTelephone(resultat.getInt(6));
               

            listCitoyens.add(citoyen);
            }
            return listCitoyens;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
    }
public void deletecitoyens(int id){
        String requete = "delete from citoyens where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
}
public List<Citoyens> DisplayAlcitoyen (){
        List<Citoyens> listCitoyens = new ArrayList<Citoyens>();

        String requete = "select Login,Cin,Nom,Prenom,Email,Telephone from citoyens where confirmation=1";
      
           try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Citoyens citoyen =new Citoyens();
               citoyen.setLogin(resultat.getString(1));
               citoyen.setCin(resultat.getInt(2));
               citoyen.setNom(resultat.getString(3));
               citoyen.setPrenom(resultat.getString(4));
               citoyen.setEmail(resultat.getString(5));
               citoyen.setTelephone(resultat.getInt(6));
               

            listCitoyens.add(citoyen);
            }
            return listCitoyens;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
 }
public void validercitoyen(int i){
        String requete = "update citoyens set confirmation=? where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,"1");
            ps.setInt(2, i);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        
}}
public void updateCitoyen( Citoyens c){
        String requete = "update citoyen set login=?, CIN=?, Nom=?, prenom=?, DateNaissance=?, sexe=?, telephone=?, email=?, pwd=? where CIN="+c.getCin();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getLogin());
            ps.setInt(2, c.getCin());
            ps.setString(3, c.getNom());
            ps.setString(4, c.getPrenom());
            ps.setDate(5, c.getDateNaissance());
            ps.setString(6, c.getSexe());
            ps.setInt(7, c.getTelephone());
            ps.setString(8, c.getEmail());
            ps.setString(9, c.getPwd());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }

    }

 public  boolean authentification_citoyen(String a,String b)
        {    
        Citoyens ok;
        ok= findByData(a,b);
        if(ok.getConfirmation()==0){ 
        return false;}
        return true;
}

 public Citoyens findByData(String login,String pwd){
     Citoyens c = new Citoyens();
     PreparedStatement ps;
     String   requete = "select login,pwd,confirmation from citoyens where login=?  and pwd=? ";
 
     
        try {
            try {
              ps = MyConnection.getInstance().prepareStatement(requete);
            } catch (Exception ex) {
            System.out.println("erreur lors ");
            return null;
        }
            ps.setString(1, login);
            ps.setString(2, pwd);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                c.setLogin(resultat.getString(1));
                c.setPwd(resultat.getString(2));
                c.setConfirmation(resultat.getInt(3));
            }
            return c;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
 
 public Citoyens finduser(String login,String pwd){
     Citoyens p = new Citoyens();
     PreparedStatement ps;
     String 
     requete = "select * from citoyens where login=?  and pwd=? ";
 
     
        try {
            try {
              ps = MyConnection.getInstance().prepareStatement(requete);
            } catch (Exception ex) {
            System.out.println("erreur lors ");
            return null;
        }
            ps.setString(1, login);
            ps.setString(2, pwd);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                 
                p.setLogin(resultat.getString(1));
                p.setSecurite(resultat.getString(2));
                p.setPwd(resultat.getString(3));
                p.setCin(resultat.getInt(4));
                p.setNom(resultat.getString(5));
                p.setPrenom(resultat.getString(6));
                p.setDateNaissance(resultat.getDate(7));
                p.setSexe(resultat.getString(8));
                p.setEmail(resultat.getString(9));
                p.setTelephone(resultat.getInt(10));
                p.setType_question(resultat.getString(11));
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
public boolean desactive(int a){
        String requete = "update citoyens set confirmation=0 where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, a);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
            return false;
        }
     }
 public   boolean test(String a)
        {    
       
        return  findBylogin(a);
        
        }
  public boolean findBylogin(String login){
      String   requete = "select *  from citoyens where login=? ";
         try 
         {
            PreparedStatement   ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,login);            
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {return true;}
            return false;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return false;
        }
    }
   public   boolean testMail(String a,int b)
        {    
        Citoyens ok;
        ok= findByMail(a);
        if(a.equals(ok.getEmail()))
           return true;
        return false;
        }
 public   String test(String a,int b)
        {    
        Citoyens ok;
        ok= findByMail(a);
        if(a.equals(ok.getEmail())) {
                return(ok.getType_question());
            }
        return null;
        }
   public Citoyens findByMail(String email){
     Citoyens p = new Citoyens();
     PreparedStatement ps;
     String   requete = "select email,login,type_question from citoyens where email=? ";
          try {
            try {
              ps = MyConnection.getInstance().prepareStatement(requete);
            } catch (Exception ex) {
            System.out.println("erreur lors ");
            return null;
        }
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                p.setEmail(resultat.getString(1));
                p.setLogin(resultat.getString(2));
                p.setType_question(resultat.getString(3));
                
                
            }
 
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
   public void insert(String pseudo,String nom,String prenom,String mail,String mdp,int tel,int cin,Date date,String questsecutite,String type,String sex  ){

        String requete = "insert into citoyens values (?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, pseudo);
            ps.setString(2, questsecutite);
            ps.setString(3, mdp);
            ps.setInt(4,cin );
            ps.setString(5, nom);
            ps.setString(6, prenom);
            ps.setDate(7, date);
            ps.setString(8, sex);
            ps.setString(9, mail);
            ps.setInt(10, tel);
            ps.setString(11, type);

            ps.executeUpdate();
              JOptionPane.showMessageDialog(null, "Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "erreur lors de l'insertion "+ex.getMessage());
        }
    }
   
    public List<String> DisplayAllDepots (){
        List<String> listedepots = new ArrayList<String>();
        String requete = "select type_question  from quest";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
 try {
            while(resultat.next())
            {
                listedepots.add(resultat.getString(1));
            }
            } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  "+ex.getMessage());
            return null;
        }
            return listedepots;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement   "+ex.getMessage());
            return null;
        }}
    public boolean findByCode(String login,String ch){
      String   requete = "select *  from citoyens where  email=? and securite=? ";
         try 
         {
            PreparedStatement   ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,login);
            ps.setString(2,ch);
             ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {return true;}
            return false;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return false;
        }
    } 
     public boolean updateMdp(String  ch,String a){
        String requete = "update citoyens set pwd=? where securite=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a);
            ps.setString(2,ch);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
            return false;
        }
     }
}

    
    

