package kpavlov.jsonweb.dao;

import kpavlov.jsonweb.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, rowNum) -> {
        final int id = rs.getInt("ID");
        final String name = rs.getString("NAME");
        final String description = rs.getString("DESCRIPTION");
        return new Item(id, name, description);
    };

    public List<Item> list() {
        return jdbcTemplate.query("select * from ITEMS", ITEM_ROW_MAPPER);
    }

    public Item get(int id) {
        return jdbcTemplate.queryForObject("select * from ITEMS WHERE ID=?", ITEM_ROW_MAPPER, id);
    }
}
