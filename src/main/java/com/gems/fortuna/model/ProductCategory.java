package com.gems.fortuna.model;

import java.util.ArrayList;
import java.util.List;

public enum ProductCategory {
    EARPHONE("Earphone"),CHARGER_TOAD("Charger Toad"),BACKUP_BATTERY("Backup Battery"),MOUSE("Mouse"),KEYBOARD(
            "Keyboard"),BLUETOOTH_SPEAKER("Bluetooth Speaker");

    private final String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static List<ProductCategory> getCategories() {
        List<ProductCategory> categories = new ArrayList<>();
        categories.add(EARPHONE);
        categories.add(CHARGER_TOAD);
        categories.add(BACKUP_BATTERY);
        categories.add(MOUSE);
        categories.add(KEYBOARD);
        categories.add(BLUETOOTH_SPEAKER);
        return categories;
    }
}
