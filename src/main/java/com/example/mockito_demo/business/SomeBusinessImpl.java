package com.example.mockito_demo.business;

public class SomeBusinessImpl {
    private DataService dataService;
    
    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findGreatest() {
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;
    }
}

interface DataService {
    int[] retrieveAllData();
}