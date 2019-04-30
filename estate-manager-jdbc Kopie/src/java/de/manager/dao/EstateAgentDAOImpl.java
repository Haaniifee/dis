package de.manager.dao;

import de.manager.entity.EstateAgent;
import de.manager.util.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EstateAgentDAOImpl implements EstateAgentDAO {

    @Autowired
    @Qualifier("JDBC_DB2ConnectorImpl")
    private JDBCConnector jdbcConnector;

    @Override
    public int getEstateAgentId(String loginName) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM estate_agent "
                                      + "WHERE login = '" + loginName + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            if(resultSet.next()) {
                return resultSet.getInt("id_estate_agent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void addEstateAgent(EstateAgent estateAgent) {
        try {
            Connection connection = jdbcConnector.getConnection();

            String sqlInsertStatement = "INSERT INTO "
                                      + "estate_agent(first_name, last_name, address, login, password) "
                                      + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, estateAgent.getFirstName());
            prepStmt.setString(2, estateAgent.getLastName());
            prepStmt.setString(3, estateAgent.getAddress());
            prepStmt.setString(4, estateAgent.getLoginName());
            prepStmt.setString(5, estateAgent.getLoginPass());
            prepStmt.executeUpdate();
            ResultSet generatedKeys = prepStmt.getGeneratedKeys();
            if (generatedKeys.next())
            {
               System.out.println(estateAgent.getId());
            }

            System.out.println("INSERT successful: " + estateAgent);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEstateAgent(String loginName) {
        try {
            String sqlDeleteStatement = "DELETE FROM estate_agent "
                                      + "WHERE login = '" + loginName + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDeleteStatement);

            System.out.println("DELETE successful");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEstateAgent(EstateAgent estateAgent) {

        Map<String, String> attributes = new HashMap<>();

        attributes.put("first_name", estateAgent.getFirstName());
        attributes.put("last_name", estateAgent.getLastName());
        attributes.put("address", estateAgent.getAddress());
        attributes.put("password", estateAgent.getLoginPass());

        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();

            if(!value.isEmpty()) {

                try {
                    String sqlUpdateStatement = "UPDATE estate_agent "
                                              + "SET " + key + " = '" + value + "' "
                                              + "WHERE login = '"+ estateAgent.getLoginName() + "'";

                    Connection connection = jdbcConnector.getConnection();
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sqlUpdateStatement);

                    System.out.println("EDIT successful");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean existEstateAgent(String loginName, String loginPassword) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM estate_agent "
                                      + "WHERE login = '" + loginName + "'"
                                      + "  AND password = '" + loginPassword + "'";

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
}
