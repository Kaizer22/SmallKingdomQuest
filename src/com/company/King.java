package com.company;

import java.util.Scanner;

/**
 * Created by denis on 01.11.16.
 */
public class King {
    public int Gold = 50;
    public int Population = 0;
    public int Sat = 0;
    public int Army = 0;
    public int Age = 0;
    public String kingName;
    public String countryName;



    King(String name) {
        kingName = name;
    }

    public void countryName(String name){
        countryName = name;

    }

}
