package com.dechichi.spring.web.test.tests;

import com.dechichi.spring.web.DAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by gabriel on 16/03/16.
 */

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath*:/../../../web/WEB-INF/config/dao-context.xml",
        "classpath*:/../../../web/WEB-INF/config/security-context.xml",
        "classpath*:/com/dechichi/spring/web/test/config/datasource.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

    @Autowired(required = false)
    private UserDAO userDAO;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {

    }

    @Test
    public void testCreateUser() {
        assertEquals("Random text", 1, 1);

    }

}