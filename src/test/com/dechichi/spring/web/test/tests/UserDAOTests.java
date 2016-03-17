package com.dechichi.spring.web.test.tests;

import com.dechichi.spring.web.DAO.User;
import com.dechichi.spring.web.DAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:com/dechichi/spring/web/test/config/dao-context.xml",
        "classpath:com/dechichi/spring/web/test/config/security-context.xml",
        "classpath:com/dechichi/spring/web/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

    @Autowired
    private UserDAO usersDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("delete from users");
    }

    @Test
    public void testCreateUser() {
        User user = new User("johnwpurcell", "John Purcell", "hellothere", "john@caveofprogramming.com", true, "user");

        assertTrue("User creation should return true", usersDao.create(user));

        List<User> users = usersDao.getAllUsers();

        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User should exist.", usersDao.exists(user.getUsername()));

        assertEquals("Created user should be identical to retrieved user", user, users.get(0));
    }

}