package com.example.demo.ejercicio21.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Society {
    private String name;
    private static String Advisor = "advisors";
    private static String President = "president";

    private List<Inventor> members = new ArrayList<>();
    private Map<String, Object> officers = new HashMap<>();

    public Inventor getMember(String inventorName){
        return members.stream()
                      .filter(r -> r.getName().equals(inventorName))
                      .findFirst()
                      .orElse(null);
                      
    }

    public boolean isMember(String name){
        Inventor inventor = getMember(name);

        return inventor != null;
    }
}
