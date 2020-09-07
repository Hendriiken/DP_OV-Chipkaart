package DAOPsqlKlassen;

import DAOKlassen.ReizigerDAO;
import Klassen.Reiziger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReizigerDAOPsql implements ReizigerDAO {
    private Connection conn;


    public ReizigerDAOPsql(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean save(Reiziger reiziger) throws SQLException {
        PreparedStatement myStatement = conn.prepareStatement("INSERT INTO reiziger VALUES (?, ?, ?, ?, ?)");

        myStatement.setInt(1, reiziger.getId());
        myStatement.setString(2, reiziger.getVoorletters());
        myStatement.setString(3, reiziger.getTussenvoegsel());
        myStatement.setString(4, reiziger.getAchternaam());
        myStatement.setDate(5, Date.valueOf(reiziger.getGeboortedatum()));

        return myStatement.execute();
    }

    @Override
    public boolean update(Reiziger reiziger) {
        return false;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        return false;
    }

    @Override
    public Reiziger findById(int id) {
        return null;
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {
        return null;
    }

    @Override
    public List<Reiziger> findAll() {
        return null;
    }
}
