package com.nanay.mvc.mvc.controllers;

import com.nanay.mvc.mvc.entities.Item;
import com.nanay.mvc.mvc.repositories.specifications.ItemsSpecs;
import com.nanay.mvc.mvc.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private ItemsService itemsServise;

    @Autowired
    public void setItemsServise(ItemsService itemsServise){
        this.itemsServise = itemsServise;
    }

    @GetMapping
    public String showItemsPage(Model model){
        Specification<Item> filter = Specification.where(null);
        filter.and(ItemsSpecs.costGreaterThanOrEq(30));
        List<Item> resultList = itemsServise.getItemsWithPagingAndFiltering(filter, PageRequest.of(1, 2)).getContent();
        model.addAttribute("items", resultList);
        return "items";
    }
}
