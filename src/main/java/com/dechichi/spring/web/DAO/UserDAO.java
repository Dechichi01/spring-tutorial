package com.dechichi.spring.web.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by gabriel on 10/03/16.
 */

@Repository
@Transactional
@Component("userDAO")
public class UserDAO {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        session().save(user);
    }

    public boolean exists(String username) {
        Criteria crit = session().createCriteria(User.class);
        crit.add(Restrictions.idEq(username));
        User user = (User)crit.uniqueResult();
        return user != null;
    }

    @SuppressWarnings("JpaQlInspection")
    public List<User> getAllUsers() {
        return session().createQuery("from User").list();
        //return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
    }

}
