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
public abstract class Personne {
  
    protected String pwd;
    protected int cin;
    protected String nom;
    protected String prenom;
    protected Date dateNaissance;
    protected String sexe;
    protected String email;
    protected int telephone;
    protected int confirmation;

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
     
      public Personne() {
    }

    public Personne(String pwd, int cin, String nom, String prenom, Date dateNaissance, String email, int telephone,String sexe) {
        this.pwd = pwd;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
        this.sexe=sexe;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Personne{" + "pwd=" + pwd + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", email=" + email + ", telephone=" + telephone + '}';
    }

  

    

  
 
    
   
    
}
