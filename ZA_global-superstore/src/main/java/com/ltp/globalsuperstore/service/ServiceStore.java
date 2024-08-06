package com.ltp.globalsuperstore.service;

import java.util.Date;
import java.util.List;

import com.ltp.globalsuperstore.Item;

public interface ServiceStore {

    public void createItem(Item item);
    public void updateItem(int index, Item item);
    public Item retrievItem(int index);
    public void deleteItem(int index);
    public List<Item> getItems();
    public int getIndexFromId(String id);
    public String SetStatus(Item item);
    public boolean within5Days(Date newDate, Date oldDate);
    public Item getItemById(String id);

    
} 
