package com.company;

public class Calculate {

    private String[] number;
    private String rezult;
    private String[] arabNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI",  "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
            "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV",
            "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV",
            "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII","LVIII",
            "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
            "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII",
            "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    Calculate(String[] number, String rezult) {
        this.number = number;
        this.rezult = rezult;
    }

    public void isOperation() {
        switch (number[1]){
            case "+" :
                plus();
                break;
            case "-":
                minus();
                break;
            case "*":
                multi();
                break;
            case "/":
                share();
                break;
            default:
                break;
        }
    }

    public void plus() {
        if (rezult.equals("ARAB")) {
            System.out.println(Integer.parseInt(number[0]) + Integer.parseInt(number[2]));
        } else {
            int x = 0;
            int y = 0;
            for(int i = 0; i < arabNumber.length; ++i) {
                if (number[0].equals(arabNumber[i]) && number[0].equals(number[2])) {
                    x = i + 1;
                    y = i;
                    break;
                } else if (number[0].equals(arabNumber[i]) && x == 0) {
                    x = i + 1;
                } else if (number[2].equals(arabNumber[i])) {
                    y = i;
                }
            }
            System.out.println(arabNumber[x + y]);
        }
    }

    public void minus() {
        if (rezult.equals("ARAB")) {
            System.out.println(Integer.parseInt(number[0]) - Integer.parseInt(number[2]));
        } else {
            int x = 0;
            int y = 0;
            if (number[0].equals(number[2])) {
                for (int i = 0; i < arabNumber.length; ++i) {
                    if (number[0].equals(arabNumber[i])) {
                        System.out.println("Результат равен 0, правда у римлян нет 0 :(");
                        break;
                    }
                }
            } else {
                for (int i = 0; i < arabNumber.length; ++i) {
                    if (number[0].equals(arabNumber[i])) {
                        x = i + 1;
                    } else if (number[2].equals(arabNumber[i])) {
                        y = i + 1;
                    }
                }
                if (x > y) {
                    System.out.println(arabNumber[x - y - 1]);
                } else {
                    System.out.println("Ой, кажется римляне не знаю что такое отрицательные числа :(");
                }
                }
        }
    }

    public void multi() {
        if (rezult.equals("ARAB")) {
            System.out.println(Integer.parseInt(number[0]) * Integer.parseInt(number[2]));
        } else {
            int x = 0;
            int y = 0;
            if (number[0].equals(number[2])) {
                for (int i = 0; i < arabNumber.length; ++i) {
                    if (number[0].equals(arabNumber[i])) {
                        System.out.println(arabNumber[(i + 1) * (i + 1) - 1]);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < arabNumber.length; ++i) {
                    if (number[0].equals(arabNumber[i])) {
                        x = i + 1;
                    } else if (number[2].equals(arabNumber[i])) {
                        y = i + 1;
                    }
                }
                System.out.println(arabNumber[x * y - 1]);
            }
        }
    }

    public void share() {
        if (rezult.equals("ARAB")) {
            System.out.println((double)Integer.parseInt(number[0]) / Integer.parseInt(number[2]));
        } else {
            int x = 0;
            int y = 0;
            if (number[0].equals(number[2])) {
                System.out.println("I");
            } else {
                for (int i = 0; i < arabNumber.length; ++i) {
                    if (number[0].equals(arabNumber[i])) {
                        x = i + 1;
                    } else if (number[2].equals(arabNumber[i])) {
                        y = i + 1;
                    }
                }
                if (x > y) {
                    System.out.println(arabNumber[x / y - 1]);
                } else {
                    System.out.println("Ой, кажется римляне не знают что такое дроби и нецелые числа ^_^");
                }
            }
        }
    }

}
