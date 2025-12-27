package com.jobportal.model;

public class Job {
    private int jobId;
    private String title;
    private String companyName;
    private int requiredExperience;
    private String status;

    public Job(int jobId, String title, String companyName, int requiredExperience) {
        this.jobId = jobId;
        this.title = title;
        this.companyName = companyName;
        this.requiredExperience = requiredExperience;
        this.status = "OPEN";
    }

    public int getJobId() {
        return jobId;
    }

    public String getStatus() {
        return status;
    }

    public void closeJob() {
        status = "CLOSED";
    }

    public boolean equals(Object obj) {
        Job job = (Job) obj;
        return this.jobId == job.jobId;
    }

    public int hashCode() {
        return jobId;
    }

    public String toString() {
        return jobId + "  " + title + "  " + companyName + "  Exp: " + requiredExperience + "  " + status;
    }
}
