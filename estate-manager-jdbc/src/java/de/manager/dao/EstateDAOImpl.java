package de.manager.dao;

import de.manager.entity.Apartment;
import de.manager.entity.House;
import de.manager.util.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EstateDAOImpl implements EstateDAO {

    @Autowired
    @Qualifier("JDBC_DB2ConnectorImpl")
    private JDBCConnector jdbcConnector;

    @Override
    public void insertHouse(House house) {
        try {
            Connection connection = jdbcConnector.getConnection();

            String sqlInsertStatement = "INSERT INTO "
                                      + "house(fk_id_estate_agent, city, postal_code, street, street_number, square_area, floors, price, garden) "
                                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement);
            prepStmt.setInt(1, house.getEstateAgentId());
            prepStmt.setString(2, house.getCity());
            prepStmt.setString(3, house.getPostalCode());
            prepStmt.setString(4, house.getStreet());
            prepStmt.setString(5, house.getNumber());
            prepStmt.setString(6, house.getSquareArea());
            prepStmt.setInt(7, house.getFloors());
            prepStmt.setDouble(8, house.getPrice());
            prepStmt.setInt(9, house.getGarden());
            prepStmt.executeUpdate();

            System.out.println("INSERT successful: " + house);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHouse(int houseId) {
        try {
            String sqlDeleteStatement = "DELETE "
                                      + "FROM house "
                                      + "WHERE id_house = '" + houseId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDeleteStatement);

            System.out.println("DELETE successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHouse(House house) {

        Map<String, String> attributes = new HashMap<>();

        attributes.put("city", house.getCity());
        attributes.put("postal_code", house.getPostalCode());
        attributes.put("street", house.getStreet());
        attributes.put("street_number", house.getNumber());
        attributes.put("square_area", house.getSquareArea());
        attributes.put("floors", String.valueOf(house.getFloors()));
        attributes.put("price", String.valueOf(house.getPrice()));
        attributes.put("garden", String.valueOf(house.getGarden()));

        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();

            if(!value.isEmpty()) {

                try {
                    String sqlUpdateStatement = "UPDATE house "
                                              + "SET " + key + " = '" + value + "' "
                                              + "WHERE id_house = '"+ house.getId() + "'";

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
    public void insertApartment(Apartment apartment) {
        try {
            Connection connection = jdbcConnector.getConnection();

            String sqlInsertStatement = "INSERT INTO "
                                      + "apartment(fk_id_estate_agent, city, postal_code, street, street_number, square_area, floor, rent, rooms, balcony, built_in_kitchen) "
                                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(sqlInsertStatement);
            prepStmt.setInt(1, apartment.getEstateAgentId());
            prepStmt.setString(2, apartment.getCity());
            prepStmt.setString(3, apartment.getPostalCode());
            prepStmt.setString(4, apartment.getStreet());
            prepStmt.setString(5, apartment.getNumber());
            prepStmt.setString(6, apartment.getSquareArea());
            prepStmt.setInt(7, apartment.getFloor());
            prepStmt.setDouble(8, apartment.getRent());
            prepStmt.setInt(9, apartment.getRoom());
            prepStmt.setInt(10, apartment.getBalcony());
            prepStmt.setInt(11, apartment.getKitchen());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteApartment(int apartmentId) {
        try {
            String sqlDeleteStatement = "DELETE "
                                      + "FROM apartment "
                                      + "WHERE id_apartment = '" + apartmentId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDeleteStatement);

            System.out.println("DELETE successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateApartment(Apartment apartment) {
        Map<String, String> attributes = new HashMap<>();

        attributes.put("city", apartment.getCity());
        attributes.put("postal_code", apartment.getPostalCode());
        attributes.put("street", apartment.getStreet());
        attributes.put("street_number", apartment.getNumber());
        attributes.put("square_area", apartment.getSquareArea());
        attributes.put("floor", String.valueOf(apartment.getFloor()));
        attributes.put("rent", String.valueOf(apartment.getRent()));
        attributes.put("rooms", String.valueOf(apartment.getRoom()));
        attributes.put("balcony", String.valueOf(apartment.getBalcony()));
        attributes.put("built_in_kitchen", String.valueOf(apartment.getKitchen()));

        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();

            if(!value.isEmpty()) {

                try {
                    String sqlUpdateStatement = "UPDATE apartment "
                                              + "SET " + key + " = '" + value + "' "
                                              + "WHERE id_apartment = '"+ apartment.getId() + "'";

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
    public boolean estateAgentMaintainHouse(int estateAgentId, int houseId) {
        try {
            String sqlSelectStatement = "SELECT * "
                    + "FROM house "
                    + "WHERE id_house = '" + houseId + "'"
                    + "  AND fk_id_estate_agent = '" + estateAgentId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean estateAgentMaintainApartment(int estateAgentId, int apartmentId) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM apartment "
                                      + "WHERE id_apartment = '" + apartmentId + "'"
                                      + "  AND fk_id_estate_agent = '" + estateAgentId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public House getHouse(int houseId, int estateAgentId) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM house "
                                      + "WHERE id_house = '" + houseId + "'"
                                      + "  AND fk_id_estate_agent = '" + estateAgentId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            if(resultSet.next()) {
                House house = new House();
                house.setId(resultSet.getInt("id_house"));
                house.setEstateAgentId(resultSet.getInt("fk_id_estate_agent"));
                house.setCity(resultSet.getString("city"));
                house.setPostalCode(resultSet.getString("postal_code"));
                house.setStreet(resultSet.getString("street"));
                house.setNumber(resultSet.getString("street_number"));
                house.setSquareArea(resultSet.getString("square_area"));
                house.setFloors(resultSet.getInt("floors"));
                house.setPrice(resultSet.getDouble("price"));
                house.setGarden(resultSet.getInt("garden"));
                return house;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Apartment getApartment(int apartmentId, int estateAgentId) {
        try {
            String sqlSelectStatement = "SELECT * "
                                      + "FROM apartment "
                                      + "WHERE id_apartment = '" + apartmentId + "'"
                                      + "  AND fk_id_estate_agent = '" + estateAgentId + "'";

            Connection connection = jdbcConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sqlSelectStatement);

            if(resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(resultSet.getInt("id_apartment"));
                apartment.setEstateAgentId(resultSet.getInt("fk_id_estate_agent"));
                apartment.setCity(resultSet.getString("city"));
                apartment.setPostalCode(resultSet.getString("postal_code"));
                apartment.setStreet(resultSet.getString("street"));
                apartment.setNumber(resultSet.getString("street_number"));
                apartment.setSquareArea(resultSet.getString("square_area"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setRent(resultSet.getDouble("rent"));
                apartment.setRoom(resultSet.getInt("rooms"));
                apartment.setBalcony(resultSet.getInt("balcony"));
                apartment.setKitchen(resultSet.getInt("built_in_kitchen"));
                return apartment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}