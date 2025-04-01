package dao;

import util.DbUtil;

import java.sql.*;


public class LoginDao {

    private static final String FIND_USER_QUERY =
            "SELECT authentication.password FROM authentication WHERE username = ?";


    public String checkAuth(String userName) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(FIND_USER_QUERY);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if( rs.next()){
                return rs.getString("password");
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
