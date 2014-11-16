package kpavlov.jsonweb.controller;

import kpavlov.jsonweb.domain.Item;
import kpavlov.jsonweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v.1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    List<Item> list() {
        return itemService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Item get(@PathVariable("id") int id) {
        return itemService.get(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    Item getNewItem() {
        return itemService.create();
    }
}
