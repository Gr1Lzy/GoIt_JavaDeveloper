package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxSalaryCountWorker> maxSalaryCountWorkers = new DatabaseQueryService().findMaxSalaryWorkers();
        List<YoungestAndOldestWorker> youngestAndOldestWorkers = new DatabaseQueryService().findYoungestAndOldestWorkers();
        List<ProjectPrice> projectPrices = new DatabaseQueryService().getProjectPrices();
        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProjects();
        System.out.println(maxProjectCountClients);
        System.out.println(maxSalaryCountWorkers);
        System.out.println(youngestAndOldestWorkers);
        System.out.println(projectPrices);
        System.out.println(longestProjects);
    }
}