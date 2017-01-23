package com.company;

import java.util.Scanner;

/**
 * Created by denis on 01.11.16.
 */
public class Story {
    public Situation situations[] = new Situation[6];
    //**                  Variant(int Gold, int Population, int Sat, int Army,int Age)
    Story(){
        situations[0] = new Situation("Вот, указ о постройке крепости на севере. Соизволите подписать? (1-Да)(2-Нет)",2);
          situations[0].variants[0] = new Variant(-10,0,0,15,1);
          situations[0].variants[1] = new Variant(0,0,0,-2,0);
        situations[1] = new Situation("Мы схватили заговорщиков, они распространяли книги о вреде монархии для государства. Что с ними делать? \n" +
                " (1-Казнить)(2-Отправить в темницу)(3-Поддержать прогрессивные идеи монетой)",3);
          situations[1].variants[0] = new Variant(0,-1,-5,0,0);
          situations[1].variants[1] = new Variant(0,1,-2,0,1);
          situations[1].variants[2] = new Variant(-10,0,7,0,0);
        situations[2] = new Situation("Наш военный советник рекомендует напасть на Н-ское королевство. Он утверждает, что их армия очень слаба.\n" +
                " (1 - Отказаться)(2 - Послать элитные части)(3 - Собрать армию добровольцев)  ",3);
          situations[2].variants[0] = new Variant(0,0,0,0,0);
          situations[2].variants[1] = new Variant(20,0,5,-15,1);
          situations[2].variants[2] = new Variant(10,-20,-5,0,2);
        situations[3] = new Situation("Проект по перестройке столицы, изволите подписать? \n " +
                "(1-Да)(2-Нет)(3-Внести удешевляющие правки)",3);
          situations[3].variants[0] = new Variant(-40,30,30,5,3);
          situations[3].variants[1] = new Variant(0,0,-3,0,0);
          situations[3].variants[2] = new Variant(-20,15,15,0,2);
        situations[4] = new Situation("Заморский торговец предлагает заключить договор о покупке у нас древесины, что скажете?\n" +
                "(1 - Подписать)(2 - Отказаться)(3 - Поторговаться)(4 - Казнить)",4);
          situations[4].variants[0] = new Variant(25,0,0,0,1);
          situations[4].variants[1] = new Variant(0,0,0,0,0);
          situations[4].variants[2] = new Variant(35,0,0,0,1);
          situations[4].variants[3] = new Variant(0,0,0,-9999,0);
        //**                  Variant(int Gold, int Population, int Sat, int Army,int Age)
        situations[5] = new Situation("Алхимик по прозванию Мутный просит у вас денег на исследования. Он говорит :'Передай государю, что после нахождения формулы философского камня все окупится втрое!' \n" +
                "(1 - Поддержать 'науку')(2 - Пускай работает в темнице) ",2);
          situations[5].variants[0] = new Variant(-100,0,0,0,1);
          situations[5].variants[1] = new Variant(0,-1,0,0,3);
        //situations[5] = new Situation("",);
          //situations[5].variants[0] = new Variant(0,1,0,4);
    }

    public void newStory(){
        Situation s;
        int k;
        for (int i = 0; i < this.situations.length ; i++) {
            k = (int)(Math.random()*(this.situations.length-1));
            s = this.situations[k];
            this.situations[k] = this.situations[i];
            this.situations[i] = s;
        }
    }

    public void newKing(King k){
        k.Gold = (int)(100* Math.random());
        k.Age = (int)(10 + (20*Math.random()));
        k.Population = (int)(100*Math.random());
        k.Army = (int)(k.Population/6+(k.Population/2*Math.random()));
        k.Sat = (int)(30 *Math.random());
    }

    public void chooseVariant(Scanner sc, Situation s, King k){
        int f = sc.nextInt()-1;
        k.Army += s.variants[f].dArmy;
        k.Gold += s.variants[f].dGold;
        k.Population += s.variants[f].dPopulation;
        k.Sat += s.variants[f].dSat;
        k.Age += s.variants[f].dAge;
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


