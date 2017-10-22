import Util.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class PieChartEtatRecANDDomain extends JFrame{
    DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;            //Panel
    public PieChartEtatRecANDDomain() {
         try 
         {double a = 0;
         double b=0;
         double c=0;
             String requete="select count(*) from reclamation where etat_Rec='en cours' and domaine=''";
         String requete1="select count(*) from reclamation where etat_Rec='traiter' and domaine =''";
         String requete2="select count(*) from reclamation where etat_Rec='non traiter' and domaine=''";
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             while(resultat.next())
        {
   a= resultat.getDouble(1);
        }
            ResultSet resultat1 = statement.executeQuery(requete1);
               while(resultat1.next())
        {
   b= resultat1.getDouble(1);
        }
ResultSet resultat2 = statement.executeQuery(requete2);        
          while(resultat2.next())
        {
  c= resultat2.getDouble(1);
        }
        
        dataset = new DefaultPieDataset();
        
//Statique
        dataset.setValue("en cours",a );
        dataset.setValue("traite",b );
        dataset.setValue("non traite",c );
       // dataset.setValue("Info", new Double(60.0));
graphe = ChartFactory.createPieChart3D("Les reclamation selon leurs etat: ", dataset,true ,true ,false);
        cp = new ChartPanel(graphe);
        this.add(cp);
         }  catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
            
        }
    }
	 public static void main (String args[]){
        PieChartEtatRecANDDomain pchart = new PieChartEtatRecANDDomain();
        pchart.setVisible(true);

    }
}

