package com.jobportal.main;

import com.jobportal.model.*;
import com.jobportal.service.JobService;
import java.util.*;

public class JobPortalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JobService service = new JobService();
        int choice;
        do{

        System.out.println("\n*** Job Portal System ***\n");
        System.out.println("1. Admin");
        System.out.println("2. Company");
        System.out.println("3. Candidate");
        System.out.println("4. Exit");

        choice = sc.nextInt();

        try {
            switch (choice) {

                case 1:
                    Admin admin = new Admin(1, "Admin");
                    admin.showMenu();
                    int adminChoice = sc.nextInt();
                    if (adminChoice == 1) {
                        service.viewJobs();
                    }
                    else if (adminChoice == 2) {
                        System.out.println("Enter Job ID:");
                        int jobId = sc.nextInt();
                        service.viewApplicantsPerJob(jobId);
                    }
                    else {
                        System.out.println("Invalid option");
                    }
                    break;

                case 2:
                    Company company = new Company(2, "RN Pvt Ltd");
                    company.showMenu();
                    int compChoice = sc.nextInt();

                    if (compChoice == 1) { 
                        System.out.println("Enter Job ID:");
                        int jid = sc.nextInt();
                        System.out.println("Enter Job Title:");
                        String title = sc.next();
                        System.out.println("Enter Required Experience:");
                        int exp = sc.nextInt();
                        service.addJob(new Job(jid, title, company.getName(), exp));
                    }
                    else if (compChoice == 2) { 
                        System.out.println("Enter Job ID to close:");
                        int closeId = sc.nextInt();
                        service.closeJob(closeId);
                    }
                    else {
                        System.out.println("Invalid option");
                    }
                    
                    break;

                case 3:
                    Candidate candidate = new Candidate(101, "John");
                    candidate.showMenu();
                    int candChoice = sc.nextInt();
                    if (candChoice == 1) {
                        service.viewJobs();
                    }
                    else if (candChoice == 2) {
                        System.out.println("Enter Job ID:");
                        int applyId = sc.nextInt();
                        service.applyJob(applyId, candidate.getId());
                    }
                    else {
                        System.out.println("Invalid option");
                    }
                    break;
                case 4:
                    System.out.println("Thank you! Exiting Job Portal.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }while (choice != 4);
    }
}
