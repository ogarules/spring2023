package com.example.demo.ejercicio13;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WheelGroup {
    private List<Wheel> wheelList;
}
