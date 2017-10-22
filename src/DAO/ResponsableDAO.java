/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Categorie;
import Entities.Domaine;
import Entities.Responsable;
import Util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author A500
 */
public class ResponsableDAO {
    
//--------------------------insertion---------------------------------
    
    public void insertResponsable(Responsable R){
     
   
        String requete = "insert into responsable (CIN,Pwd,Nom,Prenom,EMail,Telephone,DateNaissance,Grade,Categorie,Domaine,Adresse,confirmation) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, R.getCin());
            ps.setString(2, R.getPwd());
            ps.setString(3, R.getNom());
            ps.setString(4, R.getPrenom());
            ps.setString(5, R.getEmail());
            ps.setInt(6, R.getTelephone());
            ps.setDate(7, R.getDateNaissance());
            ps.setString(8, R.getGrade());
            ps.setString(9, R.getCategorie().toString());
            ps.setString(10,R.getDomaineTravail().toString());
            ps.setString(11,R.getAdresse().toString());
            ps.setInt(12,R.getConfirmation());
                    
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
//-------------------------update-----------------      
   
    public void updateDomaineTravailResponsable(Responsable R,String ch){
        String requete = "update responsable set Domaine=? where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, ch);

            ps.setInt(2, R.getCin());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
    
   
       

    

    
    public void updateResponsable(Responsable R){
        String requete = "update responsable set Pwd=?,Nom=?,Prenom=?,EMail=?,Telephone=?,DateNaissance=?,Grade=?,Categorie=?,Domaine=?,Adresse=? where CIN=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           
            ps.setString(1, R.getPwd());
        //System.out.println(R.getPwd());
            ps.setString(2, R.getNom());
        System.out.println(R.getNom());    
            ps.setString(3, R.getPrenom());
            ps.setString(4, R.getEmail());
            ps.setInt(5, R.getTelephone());
            ps.setDate(6, R.getDateNaissance());
            ps.setString(7, R.getGrade());
            ps.setString(8,R.getCategorie().toString());   
        System.out.println(R.getCategorie().toString());
        System.out.println(R.getDomaineTravail().toString());
            ps.setString(9, R.getDomaineTravail().toString());
            ps.setString(10, R.getAdresse());

            ps.setInt(11, R.getCin());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
       
   
//-------------------------------affichage---------------------------------------
    public Responsable findResponsableById(int id){
       Responsable resp = new Responsable();
     String requete = "select * from responsable where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                resp.setCin(resultat.getInt(1));
                resp.setPwd(resultat.getString(2));
                resp.setEmail(resultat.getString(5));
                resp.setNom(resultat.getString(3));
                resp.setPrenom(resultat.getString(4));
                resp.setGrade(resultat.getString(8));
                resp.setAdresse(resultat.getString(11));
                resp.setDateNaissance(resultat.getDate(7));
                resp.setTelephone(resultat.getInt(6));
                if(resultat.getString(9).equals("prive")){resp.setCategorie(Categorie.prive);}
                if(resultat.getString(9).equals("etatique")){resp.setCategorie(Categorie.etatique);}
                if(resultat.getString(9).equals("semiEtatique")){resp.setCategorie(Categorie.semiEtatique);}
                
                if(resultat.getString(10).equals("santé")){resp.setDomaineTravail(Domaine.santé);}
                if(resultat.getString(10).equals("education")){resp.setDomaineTravail(Domaine.education);}
                 if(resultat.getString(10).equals("logement")){resp.setDomaineTravail(Domaine.logement);}
                  if(resultat.getString(10).equals("transport")){resp.setDomaineTravail(Domaine.transport);}
                   if(resultat.getString(10).equals("commerce")){resp.setDomaineTravail(Domaine.commerce);}
                    if(resultat.getString(10).equals("industrie")){resp.setDomaineTravail(Domaine.industrie);}
                     if(resultat.getString(10).equals("agriculture")){resp.setDomaineTravail(Domaine.agriculture);}
                      if(resultat.getString(10).equals("autre")){resp.setDomaineTravail(Domaine.autre);}
              
            }
            return resp;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    
    public Responsable displayResponsableById(int id){
         Responsable resp = new Responsable();
         String requete = "select * from responsable where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                resp.setCin(resultat.getInt(1));
                resp.setPwd(resultat.getString(2));
                resp.setEmail(resultat.getString(5));
                resp.setNom(resultat.getString(3));
                resp.setPrenom(resultat.getString(4));
                resp.setGrade(resultat.getString(8));
                resp.setAdresse(resultat.getString(11));
                resp.setDateNaissance(resultat.getDate(7));
                resp.setTelephone(resultat.getInt(6));
                if(resultat.getString(9).equals("prive")){resp.setCategorie(Categorie.prive);}
                if(resultat.getString(9).equals("etatique")){resp.setCategorie(Categorie.etatique);}
                if(resultat.getString(9).equals("semiEtatique")){resp.setCategorie(Categorie.semiEtatique);}
                if(resultat.getString(10).equals("santé")){resp.setDomaineTravail(Domaine.santé);}
                if(resultat.getString(10).equals("education")){resp.setDomaineTravail(Domaine.education);}
                if(resultat.getString(10).equals("logement")){resp.setDomaineTravail(Domaine.logement);}
                if(resultat.getString(10).equals("transport")){resp.setDomaineTravail(Domaine.transport);}
                if(resultat.getString(10).equals("commerce")){resp.setDomaineTravail(Domaine.commerce);}
                if(resultat.getString(10).equals("industrie")){resp.setDomaineTravail(Domaine.industrie);}
                if(resultat.getString(10).equals("agriculture")){resp.setDomaineTravail(Domaine.agriculture);}
                if(resultat.getString(10).equals("autre")){resp.setDomaineTravail(Domaine.autre);}
              
                resp.setCin(resultat.getInt(12));
            }
            return resp;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
      
    public List<Responsable> DisplayAlLResponsableConf (){


        List<Responsable> listResponsable = new ArrayList<Responsable>();

        String requete = "select Cin,Nom,Prenom,Email,domaine,grade from responsable where confirmation=1";
      
           try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Responsable responsable =new Responsable();
   
               responsable.setCin(resultat.getInt(1));
               responsable.setNom(resultat.getString(2));
               responsable.setPrenom(resultat.getString(3));
               responsable.setEmail(resultat.getString(4));
                if(resultat.getString(9).equals("prive")){responsable.setCategorie(Categorie.prive);}
                if(resultat.getString(9).equals("etatique")){responsable.setCategorie(Categorie.etatique);}
                if(resultat.getString(9).equals("semiEtatique")){responsable.setCategorie(Categorie.semiEtatique);}
                if(resultat.getString(10).equals("santé")){responsable.setDomaineTravail(Domaine.santé);}
                if(resultat.getString(10).equals("education")){responsable.setDomaineTravail(Domaine.education);}
                if(resultat.getString(10).equals("logement")){responsable.setDomaineTravail(Domaine.logement);}
                if(resultat.getString(10).equals("transport")){responsable.setDomaineTravail(Domaine.transport);}
                if(resultat.getString(10).equals("commerce")){responsable.setDomaineTravail(Domaine.commerce);}
                if(resultat.getString(10).equals("industrie")){responsable.setDomaineTravail(Domaine.industrie);}
                if(resultat.getString(10).equals("agriculture")){responsable.setDomaineTravail(Domaine.agriculture);}
                if(resultat.getString(10).equals("autre")){responsable.setDomaineTravail(Domaine.autre);}
               responsable.setGrade(resultat.getString(6));
               
               

            listResponsable.add(responsable);
            }
            return listResponsable;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
 }
    public List<Responsable> DisplayAllResponsableNomConfir (){


        List<Responsable> listResponsable = new ArrayList<Responsable>();

        String requete = "select Cin,Nom,Prenom,Email,domaine,grade from responsable where confirmation=0";
      
           try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Responsable responsable =new Responsable();
          
               responsable.setCin(resultat.getInt(1));
               responsable.setNom(resultat.getString(2));
               responsable.setPrenom(resultat.getString(3));
               responsable.setEmail(resultat.getString(4));
              
                if(resultat.getString(5).equals("santé")){responsable.setDomaineTravail(Domaine.santé);}
                if(resultat.getString(5).equals("education")){responsable.setDomaineTravail(Domaine.education);}
                if(resultat.getString(5).equals("logement")){responsable.setDomaineTravail(Domaine.logement);}
                if(resultat.getString(5).equals("transport")){responsable.setDomaineTravail(Domaine.transport);}
                if(resultat.getString(5).equals("commerce")){responsable.setDomaineTravail(Domaine.commerce);}
                if(resultat.getString(5).equals("industrie")){responsable.setDomaineTravail(Domaine.industrie);}
                if(resultat.getString(5).equals("agriculture")){responsable.setDomaineTravail(Domaine.agriculture);}
                if(resultat.getString(5).equals("autre")){responsable.setDomaineTravail(Domaine.autre);}
               responsable.setGrade(resultat.getString(6));
               

            listResponsable.add(responsable);
            }
            return listResponsable;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
    }
    
    
//-------------------------------delete-------------------
      public void deleteResponsable(int cin){
        String requete = "delete from responsable where CIN=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, cin);
            ps.executeUpdate();
            System.out.println("membre supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
      
      
//--------------------------Vlider confirmation---------------
      
      public void valideResponsable(int i){
        String requete = "update responsable set confirmation=? where CIN=?";
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
      
      
       public boolean authentification_responsable(String a,String b)
        {    
        Responsable ok;
        ok= findByData(a,b);
        if(ok.getConfirmation()==0){  
        return false;}
        return true;
        }
         public Responsable findByData(String login,String pwd){
     Responsable p = new Responsable();
     PreparedStatement ps;
     String   requete = "select EMail,pwd,confirmation from responsable where EMail=?  and pwd=? ";
     
     
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
               
                p.setConfirmation(resultat.getInt(3));
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
}
