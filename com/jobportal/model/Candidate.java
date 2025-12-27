package com.jobportal.model;

public class Candidate extends User {

    public Candidate(int id, String name) {
        super(id, name);
    }

    public void showMenu() {
        System.out.println("Candidate Menu");
        System.out.println("1. View Jobs");
        System.out.println("2. Apply Job");
    }
}
