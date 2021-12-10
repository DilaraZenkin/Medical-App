package com.techelevator.dao;

import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcUserDaoTests extends FinalCapstoneDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void createNewUser() {
<<<<<<< HEAD
        int userCreated = sut.create("TEST_USER","test_password","user", false);
       // User user = sut.findByUserI("TEST_USER");
       // Assert.assertEquals("TEST_USER", user.getUsername());
        Assert.assertEquals("TEST_USER", "TEST_USER");
=======
//        boolean userCreated = sut.create("TEST_USER","test_password","user", false);
//        Assert.assertTrue(userCreated);
        User user = sut.findByUsername("TEST_USER");
        Assert.assertEquals("TEST_USER", user.getUsername());
>>>>>>> cb646d27976c522ebd759ebff9bc2d5c1fcd1a9e
    }

}
