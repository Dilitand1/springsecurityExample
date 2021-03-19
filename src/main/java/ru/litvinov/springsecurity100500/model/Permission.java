package ru.litvinov.springsecurity100500.model;

public enum Permission {
    DEVELOPERS_READ("developers:read"),DEVELOPERS_WRITE("developers:write");

    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}