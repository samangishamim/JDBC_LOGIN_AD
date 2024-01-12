package repository;

import model.Address;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public int registerUser(User user) throws SQLException {
//        Connection connection = jdbcConnection.getConnection();

        String addUser = "INSERT INTO users(first_name, last_name,national_id, username, password) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getNationalCode());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.setString(5, user.getPassword());

        int result = preparedStatement.executeUpdate();
        return result;
    }

    public User findByUsername(String username) throws SQLException {
//        Connection connection = jdbcConnection.getConnection();

        String findUser = "SELECT * FROM users WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastname = resultSet.getString("last_name");
            String nationalId = resultSet.getString("national_id");
            String fetchUsername = resultSet.getString("username");
            String password = resultSet.getString("password");
            User user = new User(id, firstName, lastname, nationalId, fetchUsername, password);
            return user;
        } else
            return null;
    }

    public int addUserAddress(Address address) throws SQLException {
        String addAddress = "insert into address(country, province, city, street, alley, number, user_id) values (?,?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(addAddress);
        ps.setString(1, address.getCountry());
        ps.setString(2, address.getProvince());
        ps.setString(3, address.getCity());
        ps.setString(4, address.getStreet());
        ps.setString(5, address.getAlley());
        ps.setInt(6, address.getNumber());
        ps.setInt(7, address.getUser_id());

        int result = ps.executeUpdate();
        return result;

    }
}
