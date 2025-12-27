package com.jobportal.model;

public class Admin extends User {
    public Admin(int id, String name){
        super(id, name);
    }
    public void showMenu(){
        System.out.println("Admin Menu");
        System.out.println("1. View All Jobs");
        System.out.println("2. View Applicants Per Job");
    }
}
