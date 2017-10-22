/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author A500
 */
public class Responsable extends Personne {
   private  Domaine domaineTravail;
   private Categorie categorie;
   private  String adresse;
   private  String grade;
 
  

    public Responsable() {
    }

    public Responsable(Domaine domaineTravail, Categorie categorie, String adresse, String grade, String pwd, int cin, String nom, String prenom, Date dateNaissance, String email, int telephone,String sexe) {
        super(pwd, cin, nom, prenom, dateNaissance, email, telephone,sexe);
        this.domaineTravail = domaineTravail;
        this.categorie = categorie;
        this.adresse = adresse;
        this.grade = grade;
       confirmation=0;
        
    }

    public Domaine getDomaineTravail() {
        return domaineTravail;
    }

    public void setDomaineTravail(Domaine domaineTravail) {
        this.domaineTravail = domaineTravail;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Responsable{" + "domaineTravail=" + domaineTravail + ", categorie=" + categorie + ", adresse=" + adresse + ", grade=" + grade + ", confirmation=" + confirmation + '}';
    }

    
   

    
    


 
    
}
