package com.dechichi.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import com.dechichi.spring.web.DAO.OffersDAO;
import com.dechichi.spring.web.DAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dechichi.spring.web.DAO.Offer;
import com.dechichi.spring.web.DAO.OffersDAO;
import com.dechichi.spring.web.DAO.User;
import com.dechichi.spring.web.DAO.UserDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/dechichi/spring/web/test/config/dao-context.xml",
		"classpath:com/dechichi/spring/web/test/config/security-context.xml",
		"classpath:com/dechichi/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDAOTests {

	@Autowired
	private OffersDAO offersDao;

	@Autowired
	private UserDAO usersDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateUser() {

		User user = new User("johnwpurcell", "John Purcell", "hellothere",
				"john@caveofprogramming.com", true, "user");

		assertTrue("User creation should return true", usersDao.create(user));

		Offer offer = new Offer(user, "This is a test offer.");

		assertTrue("Offer creation should return true", offersDao.create(offer));

		List<Offer> offers = offersDao.getOffers();

		assertEquals("Should be one offer in database.", 1, offers.size());

		assertEquals("Retrieved offer should match created offer.", offer,
				offers.get(0));

		// Get the offer with ID filled in.
		offer = offers.get(0);

		offer.setText("Updated offer text.");
		assertTrue("Offer update should return true", offersDao.update(offer));

		Offer updated = offersDao.getOffer(offer.getId());

		assertEquals("Updated offer should match retrieved updated offer",
				offer, updated);

		offersDao.delete(offer.getId());

		List<Offer> empty = offersDao.getOffers();

		assertEquals("Offers lists should be empty.", 0, empty.size());
	}

}