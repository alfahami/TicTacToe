package com.ltp.globalsuperstore.repository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.globalsuperstore.Item;

public class StoreRepository {
    
    private List<Item> items = new ArrayList<>();

    public void createItem(Item item) {
        this.items.add(item);
    }

    public void updateItem(int index, Item newItem) {
        this.items.set(index, newItem);
    }

    public Item retrieveItem(int index) {
        return this.items.get(index);
    }

    public void removeItem(int index) {
        this.items.remove(index);
    }

    public List<Item> getItems() {
        return this.items;
    }
}
