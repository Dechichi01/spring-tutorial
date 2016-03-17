package com.dechichi.spring.web.DAO;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gabriel on 17/03/16.
 */
public class OfferRowMapper implements RowMapper<Offer> {
    public Offer mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setAuthority(rs.getString("authority"));
        user.setEmail(rs.getString("email"));
        user.setEnabled(true);
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));

        Offer offer = new Offer();
        offer.setId(rs.getInt("id"));
        offer.setText(rs.getString("text"));
        offer.setUser(user);

        return offer;
    }
}
