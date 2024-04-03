package com.gems.fortuna.security;

import lombok.Getter;

@Getter
public enum UserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    TRANSACTION_READ("transaction:read"),
    TRANSACTION_WRITE("transaction:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

}
