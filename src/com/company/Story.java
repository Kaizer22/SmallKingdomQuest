package com.company;

import java.util.Scanner;

/**
 * Created by denis on 01.11.16.
 */
public class Story {
    public Situation situations[] = new Situation[1];
    //**                  (String Text,int Options)**
    Story(){
        situations[0] = new Situation("EREEEE",2);
          situations[0].variants[0] = new Variant(0,1,0,4);
    }

    public void newKing(King k){
        k.Gold = (int)(100* Math.random());
        k.Age = (int)(10 + (20*Math.random()));
        k.Population = (int)(100*Math.random());
        k.Army = (int)(k.Population/2*Math.random());
        k.Sat = (int)(30 *Math.random());
    }

    public void chooseVariant(Scanner sc, Situation s, King k){
        int f = sc.nextInt();
        k.Army += s.variants[f].dArmy;
        k.Gold += s.variants[f].dGold;
        k.Population += s.variants[f].dPopulation;
        k.Sat += s.variants[f].dSat;
    }

    public int End(King k){
        if (k.Gold <= 0){
            return 1;
        }else if(k.Sat <= 0){
            return 2;
        }else if(k.Population < 10){
            return 3;
        }else if(k.Age >= (40+(20*Math.random()))){
            return 4;
        }else if(k.Army < k.Population/6){
            return 5;
        }else
            return 0;
    }
}


