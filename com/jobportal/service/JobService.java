package com.jobportal.service;

import com.jobportal.model.Job;
import java.util.*;

public class JobService {

    private Collection<Job> jobs = new ArrayList<>();
    private Collection<String> applications = new ArrayList<>();

    public void addJob(Job job) {
        for (Job j : jobs) {
            if (j.getJobId() == job.getJobId()) {
                throw new RuntimeException("Job ID already exists!");
            }
        }
        jobs.add(job);
        System.out.println("Job added successfully.");
    }

    public void viewJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
            return;
        }
        for (Job job : jobs) {
            System.out.println(job);
        }
    }

    public void closeJob(int jobId) {
        for (Job job : jobs) {
            if (job.getJobId() == jobId) {
                job.closeJob();
                System.out.println("Job closed successfully.");
                return;
            }
        }
        System.out.println("Job not found.");
    }

    public void applyJob(int jobId, int candidateId) {
        for (Job job : jobs) {
            if (job.getJobId() == jobId) {

                if (job.getStatus().equals("CLOSED")) {
                    System.out.println("Cannot apply for closed job.");
                    return;
                }

                String key = candidateId + "-" + jobId;
                if (applications.contains(key)) {
                    System.out.println("Already applied for this job.");
                    return;
                }

                applications.add(key);
                System.out.println("Applied successfully.");
                return;
            }
        }
        System.out.println("Job not found.");
    }
    public void viewApplicantsPerJob(int jobId) {
        boolean found = false;

        for (String app : applications) {
            String[] parts = app.split("-");
            int appliedJobId = Integer.parseInt(parts[1]);

            if (appliedJobId == jobId) {
                System.out.println("Candidate ID: " + parts[0]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applicants for this job.");
        }
    }

}
