package com.in28minutes.learnspringframework.sample.enterprise.flow.data;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataService {
    public List<Integer> retrieveData() {
        return Arrays.asList(12,34,56,78,90);
    }
}
