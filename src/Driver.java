import java.sql.*;
import java.util.Properties;

public class Driver {
    public static void main(String[] args) {
        try{
            String url = "jdbc:postgresql://localhost:5433/ovchip";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "Baltobobbie@1");
            props.setProperty("ssl", "false");
            Connection conn = DriverManager.getConnection(url, props);
            Statement myStmt = conn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from reiziger") ;
            while (myRs.next()){
                if (myRs.getString("tussenvoegsel") == null){
                    System.out.println(myRs.getString("voorletters") + ' ' + myRs.getString("achternaam") + ' ' + myRs.getString("geboortedatum"));}

                else{
                    System.out.println(myRs.getString("voorletters") + ' ' + myRs.getString("tussenvoegsel")+ ' ' + myRs.getString("achternaam") + ' ' + myRs.getString("geboortedatum"));
                }
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
