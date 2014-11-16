package kpavlov.jsonweb.dao;

import kpavlov.jsonweb.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> list() {
        return jdbcTemplate.query("select * from ITEMS", (rs, rowNum) -> {
            final int id = rs.getInt("ID");
            final String name = rs.getString("NAME");
            final String description = rs.getString("DESCRIPTION");
            return new Item(id, name, description);
        });
    }
}
