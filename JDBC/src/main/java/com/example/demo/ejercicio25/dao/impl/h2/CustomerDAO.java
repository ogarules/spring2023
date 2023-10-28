package com.example.demo.ejercicio25.dao.impl.h2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.ejercicio25.dao.ICustomerDAO;
import com.example.demo.ejercicio25.dao.impl.GenericSpringJdbcDAO;
import com.example.demo.ejercicio25.dao.mapper.CustomerRowMapper;
import com.example.demo.ejercicio25.domain.Customer;
import com.example.demo.ejercicio25.domain.User;

@Repository
@Profile({"h2-in-memory", "h2-local"})
public class CustomerDAO extends GenericSpringJdbcDAO<Customer, Long> implements ICustomerDAO {
    
    private static final String INSERT_CUSTOMER = "INSERT INTO SPRING_DATA_CUSTOMER_TBL(NAME,LAST_NAME) VALUES (:name, :lastName)";
    private static final String INSERT_USER = "INSERT INTO SPRING_DATA_USER_TBL(FK_CUSTOMER_ID,USERNAME,PASSWORD) VALUES (:fkCustomerId, :username, :password)";

    private static final String UPDATE_CUSTOMER = "UPDATE SPRING_DATA_CUSTOMER_TBL SET NAME = :name, LAST_NAME = :lastName WHERE CUSTOMER_ID = :customerId";
    private static final String UPDATE_USER = "UPDATE SPRING_DATA_USER_TBL SET USERNAME = :username, PASSWORD = :password WHERE USER_ID = :userId";

    private static final String DELETE_ACCOUNT = "DELETE FROM SPRING_DATA_ACCOUNT_TBL WHERE FK_CUSTOMER_ID = :customerId";
    private static final String DELETE_CUSTOMER = "DELETE FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";
    private static final String DELETE_USER = "DELETE FROM SPRING_DATA_USER_TBL WHERE USER_ID = :userId";

    private static final String SELECT_CUSTOMER = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";
    private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT * FROM SPRING_DATA_USER_TBL WHERE FK_CUSTOMER_ID = :customerId";
    private static final String SELECT_USER_CUSTOMER_WHERE_CUSTOMER_ID = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL, SPRING_DATA_USER_TBL WHERE CUSTOMER_ID = FK_CUSTOMER_ID";

    @Override
    public void insert(Customer entity) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", entity.getName());
        parameterSource.addValue("lastName", entity.getLastName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.namedJdbcTemplate.update(INSERT_CUSTOMER, parameterSource, keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fkCustomerId", entity.getId());
        parameterSource.addValue("username", entity.getUser().getUserName());
        parameterSource.addValue("password", entity.getUser().getPassword());

        keyHolder = new GeneratedKeyHolder();

        this.namedJdbcTemplate.update(INSERT_USER, parameterSource, keyHolder);

        entity.getUser().setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Customer entity) {
        Map<String, Object> mapParameters = new HashMap<>();
        mapParameters.put("name", entity.getName());
        mapParameters.put("lastName", entity.getLastName());
        mapParameters.put("customerId", entity.getId());

        this.namedJdbcTemplate.update(UPDATE_CUSTOMER, mapParameters);

        mapParameters = new HashMap<>();
        mapParameters.put("username", entity.getUser().getUserName());
        mapParameters.put("password", entity.getUser().getPassword());
        mapParameters.put("userId", entity.getUser().getId());

        this.namedJdbcTemplate.update(UPDATE_USER, mapParameters);
    }

    @Override
    public Customer findById(Long id) {
        Customer c = null;

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("customerId", id);

        try {
            c = this.namedJdbcTemplate.queryForObject(SELECT_CUSTOMER, parameterSource, 
            (rs, rowNum) -> {
                Customer customer = new Customer();
                customer.setId(rs.getLong("CUSTOMER_ID"));
                customer.setLastName(rs.getString("LAST_NAME"));
                customer.setName(rs.getString("NAME"));

                return customer;
            });

            User u = this.namedJdbcTemplate.queryForObject(SELECT_USER_WHERE_CUSTOMER_ID, parameterSource, 
            (rs, rowNum) ->{
                User user = new User();

                user.setId(rs.getLong("USER_ID"));
                user.setUserName(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));

                return user;
            });

            u.setCustomer(c);
            c.setUser(u);
        } catch (Exception e) {
            return null;
        }

        return c;
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = this.findById(id);
        return this.delete(customer);
    }

    @Override
    public Customer delete(Customer entity) {
        Map<String, Object> mapParameters = new HashMap<>();
        mapParameters.put("customerId", entity.getId());
        mapParameters.put("userId", entity.getUser().getId());

        this.namedJdbcTemplate.update(DELETE_ACCOUNT, mapParameters);
        this.namedJdbcTemplate.update(DELETE_USER, mapParameters);
        this.namedJdbcTemplate.update(DELETE_CUSTOMER, mapParameters);

        return entity;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        this.namedJdbcTemplate.query(SELECT_USER_CUSTOMER_WHERE_CUSTOMER_ID, new RowCallbackHandler() {
            
            private CustomerRowMapper rowMapper = new CustomerRowMapper();
            private int rowNum;

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                customers.add(rowMapper.mapRow(rs, rowNum++));
            }
        });

        return customers;
    }
}
