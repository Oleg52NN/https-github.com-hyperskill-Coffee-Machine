package machine;

import java.util.*;

public class CoffeeMachine {
    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static boolean eXit=true;
    //static int status=1;

    public static void main(String[] args) {

        while (eXit) {
            menu();
        }
    }

    static int tolkoChisloSKlavy(UserInput userInput){
        boolean ind;
        while(true) {
            ind = userInput.hasFillMenu();
            if (ind) {
                return userInput.fillMenu();
            }
            else {
                userInput.mainMenu();
                System.out.println("Введите число!");

            }
        }
    }

    static int menu(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scan = new Scanner(System.in);
        UserInput userInput = new UserInput(scan);
        String s=userInput.mainMenu(); //"";
      //  if(status==1){s= }


        int vibor=-1;
        while (vibor==-1)
        {
            vibor=chegoNado(s);
        }
        switch(vibor) {
            case 0: {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                buy(userInput.buyMenu());
                return 0;
            }
            case 1: {
                fill(userInput);
                return 1;
            }
            case 2: {
                take();
                return 2;
            }
            case 3:{
                printStatus();
                break; }
            case 4:{
                eXit=false;
            }

        }
        return -1;

    }


    static void printStatus(){

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println("");
    }


    static void cofe(int sort) {
        if(cups==0){
            System.out.println("Sorry, not enough cups!");
            return;
        }
        switch(sort)
        {
            case 1: {
                if(water<250){
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if(coffee<16){
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }
                water-=250;
                coffee-=16;
                --cups;
                money+=4;
                break;
            }

            case 2: {
                if(water<350){
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if(coffee<20){
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }
                if(milk<75){
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                water-=350;
                coffee-=20;
                milk-=75;
                --cups;
                money+=7;
                break;
            }
            case 3: {
                if(water<200){
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if(coffee<12){
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }
                if(milk<100){
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                water-=200;
                coffee-=12;
                milk-=100;
                --cups;
                money+=6;
                break;
            }
        }
        System.out.println("I have enough resources, making you a coffee!");
    }

    static void  buy(String s){

        switch(s) {
            case "1":
                cofe(1);

                break;
            case "2":
                cofe(2);

                break;
            case "3":
                cofe(3);

                break;
            case "back":
                return;
            default:

                break;

        }
    }
    static void  fill(UserInput userInput){
        System.out.println("Write how many ml of water do you want to add:");
        water+=tolkoChisloSKlavy(userInput);
        System.out.println("Write how many ml of milk do you want to add");
        milk+=tolkoChisloSKlavy(userInput);
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee+=tolkoChisloSKlavy(userInput);
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups+=tolkoChisloSKlavy(userInput);
        //printStatus();

    }
    static void  take() {

        System.out.println("I gave you " + money);
        money=0;
        // printStatus();
    }

    static int chegoNado(String s) {                    //Спрашиваем - чего надо? Выход:
        // 0: кофе испить; 1: загрузить воду, кофе, молоко; 2: деньги забрать
        // -1: по клавишам попадать не научился...
        //Scanner scanner=new Scanner(System.in);
        //String s=scanner.nextLine();

        switch(s) {
            case "buy":
                return 0;
            case "fill":
                return 1;
            case "take":
                return 2;
            case "remaining":
                return 3;
            case "exit":
                return 4;
            default:
                return -1;

        }
    }
}


 class UserInput {
    private Scanner scan;

    UserInput(Scanner scan){
        this.scan = scan;
    }

    String mainMenu(){
        return scan.nextLine();
    }

    String buyMenu() {
        return scan.nextLine();
    }

    int fillMenu() {
        return scan.nextInt();
    }
    boolean hasFillMenu() {return scan.hasNextInt();}
}


