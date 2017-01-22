package com.company;
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



}

