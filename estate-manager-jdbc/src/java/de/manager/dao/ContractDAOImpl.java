package de.manager.dao;

import de.manager.entity.Person;
import de.manager.entity.PurchaseContract;
import de.manager.entity.TenancyContract;
import de.manager.util.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    @Qualifier("JDBC_DB2ConnectorImpl")
    private JDBCConnector jdbcConnector;



    @Override
    public void insertPerson(Person person) {
        try {
            Connection connection = jdbcConnector.getConnection();

            String sqlInsertStatement = "INSERT INTO "
                                      + "person(first_name, last_name, address) "
                                      + "VALUES (?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement);
            prepStmt.setString(1, person.getFirstName());
            prepStmt.setString(2, person.getLastName());
            prepStmt.setString(3, person.getAddress());
            prepStmt.executeUpdate();

            System.out.println("INSERT successful: " + person);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean personExist(Person person) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM person "
                                      + "WHERE first_name = '" + person.getFirstName() + "'"
                                      + " AND last_name = '" + person.getLastName() + "'"
                                      + " AND address = '" + person.getAddress()+ "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            System.out.println("READ successful");
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void createPurchaseContract(PurchaseContract purchaseContract) {
        try {
            Connection connection = jdbcConnector.getConnection();

            String sqlInsertStatement = "INSERT INTO "
                                      + "purchase_contract(contract_no, contract_date, place, fk_id_person, fk_id_house, no_of_installments, intrest_rate) "
                                      + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement);
            prepStmt.setString(1, purchaseContract.getContractNumber());
            prepStmt.setDate(2, purchaseContract.getDate());
            prepStmt.setString(3, purchaseContract.getPlace());
            prepStmt.setInt(4, purchaseContract.getPersonID());
            prepStmt.setInt(5, purchaseContract.getHouseID());
            prepStmt.setInt(6, purchaseContract.getNoOfInstallments());
            prepStmt.setInt(7, purchaseContract.getIntrestRate());
            prepStmt.executeUpdate();

            System.out.println("INSERT successful: " + purchaseContract);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTenancyContract(TenancyContract tenancyContract) {
        try {
            Connection connection = jdbcConnector.getConnection();

            String sqlInsertStatement = "INSERT INTO "
                                      + "tenancy_contract(contract_no, contract_date, place, fk_id_person, fk_id_apartment, start_date, duration_days, additional_costs) "
                                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement);
            prepStmt.setString(1, tenancyContract.getContractNumber());
            prepStmt.setDate(2, tenancyContract.getDate());
            prepStmt.setString(3, tenancyContract.getPlace());
            prepStmt.setInt(4, tenancyContract.getPersonID());
            prepStmt.setInt(5, tenancyContract.getApartmentID());
            prepStmt.setDate(6, tenancyContract.getStartDate());
            prepStmt.setInt(7, tenancyContract.getDuration());
            prepStmt.setInt(8, tenancyContract.getAdditionalCosts());
            prepStmt.executeUpdate();

            System.out.println("INSERT successful: " + tenancyContract);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean purchaseContractExist(int personId, int houseId, String contractNumber) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM purchase_contract "
                                      + "WHERE contract_no = '" + contractNumber + "'"
                                      + "   OR fk_id_person = '" + personId + "'"
                                      + "  AND fk_id_house = '" + houseId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            System.out.println("READ successful");
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tenancyContractExist(int personId, int apartmentId, String contractNumber) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM tenancy_contract "
                                      + "WHERE contract_no = '" + contractNumber + "'"
                                      + "   OR fk_id_person = '" + personId + "'"
                                      + "  AND fk_id_apartment = '" + apartmentId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            System.out.println("READ successful");
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<PurchaseContract> getAllPurchaseContracts() {
        try {
            List<PurchaseContract> purchaseContracts = new LinkedList();

            String sqlSelectStatement = "SELECT * "
                                      + "FROM purchase_contract ";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectStatement);

            while (resultSet.next()) {
                int purchaseContractId = resultSet.getInt("id_purchase_contract");
                String contractNumber = resultSet.getString("contract_no");
                Date contractDate = resultSet.getDate("contract_date");
                String place = resultSet.getString("place");
                int personId = resultSet.getInt("fk_id_person");
                int houseId = resultSet.getInt("fk_id_house");
                int noOfInstallments = resultSet.getInt("no_of_installments");
                int intrestRate = resultSet.getInt("intrest_rate");

                purchaseContracts.add(new PurchaseContract(purchaseContractId,
                                                           contractNumber,
                                                           contractDate,
                                                           place,
                                                           personId,
                                                           houseId,
                                                           noOfInstallments,
                                                           intrestRate));
            }
            return purchaseContracts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TenancyContract> getAllTenancyContracts() {
        try {
            List<TenancyContract> tenancyContracts = new LinkedList();

            String sqlSelectStatement = "SELECT * "
                                      + "FROM tenancy_contract ";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectStatement);

            while (resultSet.next()) {
                int tenancyContractId = resultSet.getInt("id_tenancy_contract");
                String contractNumber = resultSet.getString("contract_no");
                Date contractDate = resultSet.getDate("contract_date");
                String place = resultSet.getString("place");
                int personId = resultSet.getInt("fk_id_person");
                int apartmentId = resultSet.getInt("fk_id_apartment");
                Date startDate = resultSet.getDate("start_date");
                int durationDays = resultSet.getInt("duration_days");
                int additionalCosts = resultSet.getInt("additional_costs");

                tenancyContracts.add(new TenancyContract(tenancyContractId,
                                                         contractNumber,
                                                         contractDate,
                                                         place,
                                                         personId,
                                                         apartmentId,
                                                         startDate,
                                                         durationDays,
                                                         additionalCosts));
            }
            return tenancyContracts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
