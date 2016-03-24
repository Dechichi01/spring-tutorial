package com.dechichi.spring.web.test.tests;

import com.dechichi.spring.web.DAO.User;
import com.dechichi.spring.web.DAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:com/dechichi/spring/web/test/config/security-context.xml",
        "classpath:com/dechichi/spring/web/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

    @Autowired
    @Qualifier("userDAO")
    private UserDAO usersDao;

    @Autowired
    private DataSource dataSource;

    private User user1 = new User("account1", "password1", "Account1", "email@email.com", true, "ROLE_USER");
    private User user2 = new User("account2", "password2", "Account2", "email@email.com", true, "ROLE_USER");
    private User user3 = new User("account3", "password3", "Account3", "email@email.com", false, "ROLE_USER");
    private User user4 = new User("account4", "password4", "Account4", "email@email.com", true, "ROLE_ADMIN");

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("delete from offers");
        jdbc.execute("delete from users");
    }

    @Test
    public void testCreateRetrieve() {
        usersDao.create(user1);
        List<User> users1 = usersDao.getAllUsers();

        assertEquals("This should return 1 user", 1, users1.size());
        assertEquals("Inserted user should match retrieved", user1, users1.get(0));

        usersDao.create(user2);
        usersDao.create(user3);
        usersDao.create(user4);

        List<User> users2 = usersDao.getAllUsers();

        assertEquals("The number of retrieved users should be 4", 4, users2.size());

    }

    // TODO - Reimplement this
    @Test
    public void testUsers() {

        User user = new User("Account1", "password1", "Accountant", "email@email.com", true, "ROLE_USER");

        usersDao.create(user);

        List<User> users = usersDao.getAllUsers();

        assertEquals("Number of users should be 1", 1, users.size());

        assertTrue("User should exist in the database", usersDao.exists(user.getUsername()));
        assertFalse("Non created user should not exist", usersDao.exists("NonExicste!"));

        assertEquals("Created user should be equal to retrieved user", user, users.get(0));
    }

}