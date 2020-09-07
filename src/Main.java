import DAOKlassen.ReizigerDAO;
import Klassen.Reiziger;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5433/ovchip";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "Baltobobbie@1");
            props.setProperty("ssl", "false");
            Connection conn = DriverManager.getConnection(url, props);
            Statement myStmt = conn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from reiziger");
            while (myRs.next()) {
                if (myRs.getString("tussenvoegsel") == null) {
                    System.out.println(myRs.getString("voorletters") + ". " + myRs.getString("achternaam") + " (" + myRs.getString("geboortedatum") + ")");
                } else {
                    System.out.println(myRs.getString("voorletters") + ". " + myRs.getString("tussenvoegsel") + ' ' + myRs.getString("achternaam") + " (" + myRs.getString("geboortedatum") + ")");
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    private static void getConnection() {

    }

    private static void closeConnection() {

    }

    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        // Haal alle reizigers op uit de database
        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        // Maak een nieuwe reiziger aan en persisteer deze in de database
        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");

    }

}