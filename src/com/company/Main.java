package com.company;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Story story = new Story();

        System.out.println("Вот уже 20 лет в государстве нашем смута! Но наконец-то на престоле сильный король! \n" +
                "Лишь на вас народ уповает, государь. Как изволите вас величать?");
        King king = new King(sc.next());
        System.out.println(king.kingName+"! А державу нашу как назовем, что бы окончательно позабыть смутное время?");
        king.countryName(sc.next());
        System.out.println("В добрый путь!");
        System.out.println("========Для выхода введите 10=======");
        int n = 0;
        while (true) {
            story.newKing(king);
            story.newStory();

            while(story.End(king) == 0){
                System.out.println("=======================Сводки====================\n"+
                                   "|==============Королевство: "+king.countryName+" ===============\n"+
                                   "|==============Король: "+king.kingName+" =============\n"+
                                   "|Золото: "+king.Gold+" ==Население: "+king.Population+" ==Армия: "+king.Army+" ==Довольство: "+king.Sat+" ==Возраст: "+king.Age+"==");
                System.out.println(story.situations[n].text);
                story.chooseVariant(sc,story.situations[n],king);
                n++;
                if (n >= story.situations.length){
                    story.newStory();
                    n = 0;
                }
            }

            switch(story.End(king)) {
                case 1:
                    System.out.println("Наша страна обнищала! Уже совсем скоро народу будет нечего есть! Я настоятельно \n" +
                            "рекомендую вам отречься от престола, пока разгневанный народ не вышел на улицы.");
                    break;
                case 2:
                    System.out.println("Народ недоволен! Вы что, не видете этого !? Ваше правление принесло этим людям большие беды!");
                    break;
                case 3:
                    System.out.println("Лоюди умираю или бегут из страны! Скоро вам будет некем править.");
                    break;
                case 5:
                    System.out.println("Другое королевство вторглось на нашу территорию! Нам нечем им ответить - наших войск недостаточно!");
                    break;
                default:
                    System.out.println("Наш славный король умер! Он мог так много успеть сделать для королевства!");
                    break;
            }

            System.out.println("Нам понадобилось несколько лет, чтобы справится с прорблемами прошлого и сейчас на престоле новый монарх!");
            System.out.println("Как вас зовут, ваше величество?");
            king.kingName = sc.next();
            System.out.println("Удачного вам правления, "+king.kingName+", в королевстве "+king.countryName);
        }
    }
}







