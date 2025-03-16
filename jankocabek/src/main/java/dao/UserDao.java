package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;
import entity.User;


public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String FIND_USER_QUERY =
            "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE  id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USER_QUERY =
            "SELECT * FROM users";

    public User create(User user) {
        try (Connection connection = DbUtil.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassHash());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public User findById(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(FIND_USER_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public void update(User user) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER_QUERY);
            ps.setInt(4, user.getId());
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassHash());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public boolean delete(int userId) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(DELETE_USER_QUERY);
            ps.setInt(1, userId);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    public List<User> findAll() {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_USER_QUERY);
            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getInt(1),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
