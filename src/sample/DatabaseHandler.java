package sample;

import sample.hotel.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String connectionString = "jdbc:mysql://localhost:3306/kursa4?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String login = "root";
    private static final String password = "root";
    private static Connection dbConnection;
    private static boolean initiated = false;
    public static void connect() {
        try {
            dbConnection = DriverManager.getConnection(connectionString, login, password);
            initiated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertClient(Person person) {
        try {
            Statement statement = dbConnection.createStatement();
            statement.execute(
                    String.format("INSERT INTO kursa4.people (firstname, lastname, username, password) VALUE ('%s', '%s', '%s', '%s')",
                            person.getFirstName(), person.getLastName(), person.getUsername(), person.getPassword()));
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Person getPersonByLoginAndPassword(String login, String password) {
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM kursa4.people WHERE username='%s' AND password='%s'", login, password));
            Person c = null;
            if (results.next()) {
                int db_id = results.getInt("id");
                String db_firstname = results.getString("firstname");
                String db_lastname = results.getString("lastname");
                String db_username = results.getString("username");
                String db_password = results.getString("password");
                c = new Person(db_id, db_firstname, db_lastname, db_password, db_username);
            }
            statement.close();
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertOrder(Order order) {
        try {
            Statement statement = dbConnection.createStatement();
            statement.execute(
                    String.format("INSERT INTO kursa4.orders (idperson, apartmentname) VALUE ('%d', '%s')",
                            order.getIdperson(), order.getApartmentname()));
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<OrderHistoryLine> selectAllOrdersExtended() {
        List<OrderHistoryLine> orders = new ArrayList<>();
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery("SELECT orders.id,orders.idperson, apartmentname, firstname, lastname, username FROM kursa4.orders LEFT JOIN people ON orders.idperson=people.id");
            OrderHistoryLine line = null;
            while (results.next()) {
                int db_id = results.getInt("id");
                int db_idperson = results.getInt("idperson");
                String db_firstname = results.getString("firstname");
                String db_lastname = results.getString("lastname");
                String db_username = results.getString("username");
                String db_apartmentname = results.getString("apartmentname");
                line = new OrderHistoryLine(db_id, db_idperson, db_firstname, db_lastname, db_username, db_apartmentname);
                orders.add(line);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static void deleteClient(Person person) {
        try {
            Statement statement = dbConnection.createStatement();
            statement.execute(
                    String.format("DELETE FROM kursa4.people WHERE id='%d'", person.getId()));
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePerson(Person person) {
        if (person.getId() == 0) {
            throw new IllegalArgumentException("Person Is Not In Db");
        }

        try {
            Statement statement = dbConnection.createStatement();
            statement.execute(
                    String.format("UPDATE `kursa4`.`people` SET username='%s', password='%s' WHERE id='%d'",
                            person.getUsername(), person.getPassword(), person.getId()));
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        if (initiated) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
