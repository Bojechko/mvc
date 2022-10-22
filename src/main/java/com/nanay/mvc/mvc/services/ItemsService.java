package com.nanay.mvc.mvc.services;

import com.nanay.mvc.mvc.entities.Item;
import com.nanay.mvc.mvc.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Page<Item> getItemsWithPagingAndFiltering(Specification<Item> specification, Pageable pageable){
        return itemRepository.findAll(specification, pageable);
    }
}
