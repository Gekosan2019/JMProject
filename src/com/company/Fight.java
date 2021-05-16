package com.company;

import java.util.Scanner;

public class Fight {

    private String[][] area;

    Fight(String[][] area) {
        this.area = area;
    }


    // Ввод координаты и затем проверка её координат
    public boolean inputBax(int d, Area player) {
        if (d == 0) {
            System.out.println();
            System.out.println("The game starts!");
            System.out.println();
            player.outputArea();
            System.out.println();
            System.out.println("Take a shot!");
            System.out.println();
            Scanner in = new Scanner(System.in);
            String koord = in.nextLine();
            if (koord.length() == 2) {
              return baxArea2(player, koord);
            } else {
              return baxArea3(player, koord);
            }
        } else {
            System.out.println();
            Scanner in = new Scanner(System.in);
            String koord = in.nextLine();
            if (koord.length() == 2) {
                return baxArea2(player, koord);
            } else {
                return baxArea3(player, koord);
            }
        }
    }

    // Именно сам выстрел, если длина строки 2
    public boolean baxArea2(Area player, String koord) {
        if ((int) koord.charAt(0) - 64 < 11 && Integer.parseInt(String.valueOf(koord.charAt(1))) < 11) {
            if (area[(int) koord.charAt(0) - 64][Integer.parseInt(String.valueOf(koord.charAt(1)))] == "O") {
                area[(int) koord.charAt(0) - 64][Integer.parseInt(String.valueOf(koord.charAt(1)))] = "X";
                System.out.println();
                player.outputArea();
                System.out.println();
                System.out.println("You hit a ship!");
                return false;
            } else {
                area[(int) koord.charAt(0) - 64][Integer.parseInt(String.valueOf(koord.charAt(1)))] = "M";
                System.out.println();
                player.outputArea();
                System.out.println();
                System.out.println("You missed!");
                return false;
            }
        } else {
            System.out.println();
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return true;
        }
    }

    //Именно сам выстрел, если длина строки 3
    public boolean baxArea3(Area player, String koord) {
        if ((int) koord.charAt(0) - 64 < 11 && Integer.parseInt(String.valueOf(koord.charAt(1)) + String.valueOf(koord.charAt(2))) < 11) {
            if (area[(int) koord.charAt(0) - 64][Integer.parseInt(String.valueOf(koord.charAt(1)) + String.valueOf(koord.charAt(2)))] == "O") {
                area[(int) koord.charAt(0) - 64][Integer.parseInt(String.valueOf(koord.charAt(1)) + String.valueOf(koord.charAt(2)))] = "X";
                System.out.println();
                player.outputArea();
                System.out.println();
                System.out.println("You hit a ship!");
                return false;
            } else {
                area[(int) koord.charAt(0) - 64][Integer.parseInt(String.valueOf(koord.charAt(1)) + String.valueOf(koord.charAt(2)))] = "M";
                System.out.println();
                player.outputArea();
                System.out.println();
                System.out.println("You missed!");
                return false;
            }
        } else {
            System.out.println();
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return true;
        }
    }
}
