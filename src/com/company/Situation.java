package com.company;

import java.util.Scanner;

/**
 * Created by denis on 01.11.16.
 */

public class Situation {
    public String text;
    public Variant[] variants;


    Situation(String Text,int Variants){
        text = Text;
        variants = new Variant[Variants];
    }

    public void chooseVariant(Scanner sc,  Kingdom k){
        int f = sc.nextInt()-1;
        k.Army += this.variants[f].dArmy;
        k.Gold += this.variants[f].dGold;
        k.Population += this.variants[f].dPopulation;
        k.Sat += this.variants[f].dSat;
        k.Age += this.variants[f].dAge;
    }



}

