package com.jobportal.model;

public class Company extends User {

    public Company(int id, String name) {
        super(id, name);
    }

    public void showMenu() {
        System.out.println("Company Menu");
        System.out.println("1. Post Job");
        System.out.println("2. Close Job");
    }
}
