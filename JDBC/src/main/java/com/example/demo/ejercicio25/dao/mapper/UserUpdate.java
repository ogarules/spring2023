package com.example.demo.ejercicio25.dao.mapper;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UserUpdate extends SqlUpdate{
     private static final String UPDATE = "UPDATE SPRING_DATA_USER_TBL "
    + "SET USERNAME = ?, "
    + "PASSWORD = ? "
    + "WHERE USER_ID = ?";

    public UserUpdate(DataSource dataSource){
        super(dataSource, UPDATE);

        declareParameter(new SqlParameter("USERNAME", Types.VARCHAR));
        declareParameter(new SqlParameter("PASSWORD", Types.VARCHAR));
        declareParameter(new SqlParameter("USER_ID", Types.INTEGER));

        compile();
    }

    public int execute(Long id, String username, String password){
        return update(username, password, id);
    }
}
