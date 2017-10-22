


import DAO.CitoyensDAO;
import DAO.ReclamationDAO;
import DAO.ResponsableDAO;
import Entities.Reclamation;


import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ss
 */
public class ConsultaionRecTableModel extends AbstractTableModel{
List<Reclamation> monstock;
String[] entete={"IdRec","Type","Domaine","Categorie","EtatRec","Critere","CinCitoyen","CitResponsable"};
ConsultaionRecTableModel ()
{
 monstock= new ReclamationDAO().DisplayAllReclamation();   
}
        public int getRowCount() {
     return monstock.size();
    }

    public int getColumnCount() {
       return entete.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
      switch (columnIndex){
          case 0:
              return monstock.get(rowIndex).getIdRec();
          case 1:
              return monstock.get(rowIndex).getType();
                  case 2:
              return monstock.get(rowIndex).getDomaine();
               case 3:
              return monstock.get(rowIndex).getCategorie();
                   case 4:
              return monstock.get(rowIndex).getEtatrec();
          case 5:
              return monstock.get(rowIndex).getCritere();
                  case 6:
              return monstock.get(rowIndex).getCin_citoyen();
               case 7:
              return monstock.get(rowIndex).getCin_responsable();
               default:
                   throw new IllegalArgumentException();
              
                
              
    } }
    public String getColumnName(int column)
    {
        return  entete[column];
    }
    
}
