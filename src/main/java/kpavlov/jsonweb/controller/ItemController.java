package kpavlov.jsonweb.controller;

import kpavlov.jsonweb.domain.Item;
import kpavlov.jsonweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v.1/item")
public class ItemController {

    @Autowired
    private ItemService listService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Item> list() {
        return listService.list();
    }
}
