/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CitoyensDAO;
import Entities.Citoyens;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Houssem Eddine
 */
public class MyTableModel1 extends AbstractTableModel {

    List<Citoyens> listCitoyen = new ArrayList<Citoyens>();
    String []header = {"login","CIN","Nom","Prenom","email","telephone"};

    public MyTableModel1() { //remplissage de la liste des stocks
        listCitoyen=new CitoyensDAO().DisplayAlcitoyen();
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listCitoyen.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_Stock
                return listCitoyen.get(rowIndex).getLogin();
            case 1://colonne type_vetement
                return listCitoyen.get(rowIndex).getCin();
            case 2://listcCitoyenses quantité
                return listCitoyen.get(rowIndex).getNom();
            case 3://colonne adresse depot
                return listCitoyen.get(rowIndex).getPrenom();
                 case 4://colonne adresse depot
                return listCitoyen.get(rowIndex).getEmail();
                      case 5://colonne adresse depot
                return listCitoyen.get(rowIndex).getTelephone();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    

}
