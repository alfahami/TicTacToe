package com.ltp.globalsuperstore.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;

public class ServiceStoreImpl implements ServiceStore {

    StoreRepository storeRepository = new StoreRepository();

    @Override
    public void createItem(Item item) {
        this.storeRepository.createItem(item);
    }

    @Override
    public void updateItem(int index, Item item) {
        this.storeRepository.updateItem(index, item);
    }

    @Override
    public Item retrievItem(int index) {
        return this.storeRepository.retrieveItem(index);
    }

    @Override
    public void deleteItem(int index) {
        this.storeRepository.removeItem(index);
    }

    @Override
    public List<Item> getItems() {
        return this.storeRepository.getItems();
    }

    @Override
    public int getIndexFromId(String id) {

        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;

    }

    @Override
    public String SetStatus(Item item) {
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            createItem(item);
        } else if (within5Days(item.getDate(), retrievItem(index).getDate())) {
            updateItem(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }

        return status;
    }

    @Override
    public Item getItemById(String id) {
        int index = getIndexFromId(id);
        return index == Constants.NOT_FOUND ? new Item() : retrievItem(index);
    }

    @Override
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}
