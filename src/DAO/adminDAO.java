/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import Entities.admin;
import Util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Doct
 */
public class adminDAO {
    
    public  boolean authentification_admin(String a,String b)
        {    
        admin ok;
        ok= findByData(a,b);
        return a.equals(ok.getLogin())&& b.equals(ok.getPwd());       
        }
      public admin findByData(String login,String pwd){
     admin p = new admin();
     PreparedStatement ps;
     String 
      requete = "select login,pwd from admin where login=?  and pwd=? ";
     
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
                p.setPwd(resultat.getString(2));
 
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }}
}
