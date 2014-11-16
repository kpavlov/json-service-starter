package kpavlov.jsonweb.service;

import kpavlov.jsonweb.dao.ItemDao;
import kpavlov.jsonweb.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {


    @Autowired
    private ItemDao itemDao;

    @Transactional
    public List<Item> list() {
        return itemDao.list();
    }
}
