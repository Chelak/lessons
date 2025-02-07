package com.celac.jdbc.app.dao.mappers;

import com.celac.jdbc.app.entities.User;
import com.celac.jdbc.app.sql.ResultSetRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scelac
 */
public class UserListRowMapper implements ResultSetRowMapper<List<User>> {
    @Override
    public List<User> mapRow(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
                while (rs.next()) {
                    users.add(
                            new User(
                                    rs.getLong(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4)));
                }
            }
        return users;
    }
}
