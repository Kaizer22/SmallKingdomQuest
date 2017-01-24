package com.company;

import java.util.Scanner;

/**
 * Created by denis on 01.11.16.
 */
public class Story {
    public Situation situations[] = new Situation[11];
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
                " (1 - Отказаться)(2 - Послать элитные части)(3 - Принудительно собрать армию добровольцев)  ",3);
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
        situations[5] = new Situation("Алхимик по прозванию Мутный просит у вас денег на исследования. Он говорит :'Передай государю, что после нахождения формулы философского камня все окупится втрое!' \n" +
                "(1 - Поддержать 'науку')(2 - Пускай работает в темнице) ",2);
          situations[5].variants[0] = new Variant(-100,0,0,0,1);
          situations[5].variants[1] = new Variant(0,-1,0,0,3);
        situations[6] = new Situation("Неведомая болезнь охватила наше королевство! Врачи ищут лекарство, но все тщетно! Рассудите, что делать? \n" +
                "(1 - Ввести карантин)(2 - Финансировать врачебные исследования)(3 - Помолиться)",3);
          situations[6].variants[0] = new Variant(-5,-30,-5,0,1);
          situations[6].variants[1] = new Variant(-60,5,10,0,5);
          situations[6].variants[2] = new Variant(0,-35,5,0,2);
        situations[7] = new Situation("В столицу хлынули беженцы из соседнего королевства. Что с ними делать? \n" +
                "(1 - Пускай живут у нас)(2 - Поддержать их материально)(3 - Выгнать вон)",3);
         situations[7].variants[0] = new Variant(0,10,-5,0,1);
         situations[7].variants[1] = new Variant(-10,25,-2,0,2);
         situations[7].variants[2] = new Variant(0,-5,5,0,0);
        situations[8] = new Situation("Пекарь из глубинки разработал новый рецепт хлеба, теперь  буханка стоит дешевле. Используем его наработки? \n " +
                "(1 - Да)(2 - Нет)",2);
         situations[8].variants[0] = new Variant(-10,15,20,0,1);
         situations[8].variants[1] = new Variant(0,0,0,0,0);
        situations[9] = new Situation("Оружейное ремесло в провинции К. достигло невероятных высот. Стоит ли нам заказывать оружие для нашей армии у местных оружейников?\n" +
                "(1 - У нас свои поставщики)(2 - Конечно!)(3 - Для Родины пускай делают бесплатно!)",3);
         situations[9].variants[0] = new Variant(0,0,0,-10,1);
         situations[9].variants[1] = new Variant(-30,0,0,25,1);
         situations[9].variants[2] = new Variant(0,0,0,5,4);
        situations[10] = new Situation("Давно не проводились турниры. Велите организовать?(1 - Да)(2 - Нет)(3 - Уменьшите смету вдвое)(4 - Собирайте деньги за посещение) ",4);
         situations[10].variants[0] = new Variant(-50,0,20,5,1);
         situations[10].variants[1] = new Variant(0,0,-20,0,0);
         situations[10].variants[2] = new Variant(-25,0,10,0,2);
         situations[10].variants[3] = new Variant(30,0,-10,0,1);
        //**                  Variant(int Gold, int Population, int Sat, int Army,int Age)
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





    public int End(Kingdom k){
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


