/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entities.Citoyens;
import Entities.Personne;
import Entities.Responsable;
import Entities.Reclamation;
import Util.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Karray
 */
public class ReclamationDAO  {


  


      public List<Reclamation> findRecByDomain(String domaine){

             List<Reclamation> listeRec = new ArrayList<Reclamation>();
             String requete = "select * from reclamation  where domaine=?";
                  try {
                         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                         ps.setString(1, domaine);
                         ResultSet resultat = ps.executeQuery();
                       while (resultat.next())
                           {Reclamation rec= new Reclamation();
                             rec.setIdRec(resultat.getInt(1));
                             rec.setType(resultat.getString(2));
                             rec.setDomaine(resultat.getString(3));
                             rec.setCategorie(resultat.getString(4));
                             rec.setEtatrec(resultat.getString(5));
                             rec.setCritere(resultat.getString(6));
                             rec.setCin_citoyen(resultat.getInt(7));
                             rec.setCin_responsable(resultat.getInt(8));
                            listeRec.add(rec);
               
                            }
            return listeRec;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }

       
    }

       public List<Reclamation> DisplayAllReclamation (){


        List<Reclamation> listeRec = new ArrayList<Reclamation>();

        String requete = "select * from reclamation";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           
            while(resultat.next()){
               Reclamation Rec =new Reclamation();
               Rec.setIdRec(resultat.getInt(1));
               Rec.setType(resultat.getString(2));
               Rec.setDomaine(resultat.getString(3)); 
               Rec.setCategorie(resultat.getString(4));
               Rec.setEtatrec(resultat.getString(5));
               Rec.setCritere(resultat.getString(6));
               Rec.setCin_citoyen(resultat.getInt(7));
               Rec.setCin_responsable(resultat.getInt(8));
                
                listeRec.add(Rec);
               
            }
            return listeRec;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            return null;
        }
    }
       
       
//        public void updateReclamation( Reclamation rc){
//        String requete = "update reponse_rec set reponse=? where etat_rec ='non traite'";
//        try {
//            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
//            ps.setString(1, rc.getReponse());
//            ps.executeUpdate();
//            System.out.println("Mise à jour effectuée avec succès");
//        } catch (SQLException ex) {
//           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
//        }
//
//    }
  
       
    public ResultSet findData(int cin){
      PreparedStatement ps;
     String 
     requete = "select Domaine,Categories,sujet,contenu,etat_Rec,Cin_citoyen from reclamation where Cin_citoyen=? ";
 
     
        try {
            try {
              ps = MyConnection.getInstance().prepareStatement(requete);
            } catch (Exception ex) {
            System.out.println("erreur lors ");
            return null;
        }
            ps.setInt(1, cin);
            
            ResultSet resultat = ps.executeQuery();
           
            return resultat;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }      
    
    public   boolean insertReclamation(String contenu, String categorie, String domaine, String Etat, int cin,String sujet) {
        String requete = "insert into reclamation(Domaine,Categories,sujet,contenu,etat_Rec,Cin_citoyen) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, domaine );
            ps.setString(2,categorie  );
            ps.setString(3,sujet  );
            ps.setString(4,contenu  );
            ps.setString(5, Etat);
            ps.setInt(6,cin );
            ps.executeUpdate();
               return true;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "erreur lors de l'insertion "+ex.getMessage());
        }
        return false;
     }
    
     
    
}
