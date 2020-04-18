package com.example.aop.service;

import com.example.aop.annotation.Loggable;

public class BusinessService {

    @Loggable
    public String getDataFromApi() {
        return new MockedApiService().performSomeTask();
    }

    static class MockedApiService {
        public String performSomeTask() {
            return "MockedData";
        }
    }

}
