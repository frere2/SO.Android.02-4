package com.example.bredufateczlsoex03.controller;

import java.util.ArrayList;
import java.util.List;

public class NumeroController {
    public String primos(int low, int high) {
        List<Integer> lista = new ArrayList<>();
        while (low < high) {
            boolean flag = false;

            for(int i = 2; i <= low/2; ++i) {
                if(low % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag && low != 0 && low != 1)
                lista.add(low);

            ++low;
        }
        return lista.toString();
    }
}
