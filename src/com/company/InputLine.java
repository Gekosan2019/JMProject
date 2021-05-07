package com.company;

import java.util.Scanner;

public class InputLine {

    private String[] number;
    private String line;
    private int[] arabNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private String[] rimNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private String rezult;

    InputLine () {
        System.out.println("Введите выражение");
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
    }

    // Считываем строку, разбиваем на части по пробелам и заносим в массив
    public void splitLine() {
        number = line.split(" ");
    }

    // В данном методе будем проверять все возможные исключения
    public boolean checkException() throws Exception {
        try {
            // Проверка на необходимое количество элементов в выражении
            if (number.length != 3) {
                System.out.println("Ошибка ввода. Выражение должно состоять из 3 частей");
                throw new Exception();
            } else {
                // Проверка  на римские цифры
                int fl = 0;
                for (String num : rimNumber) {
                    if (num.equals(number[0]) || num.equals(number[2])) {
                        fl++;
                    }
                }
                if (fl == 1 && number[0].equals(number[2])) {
                    fl++;
                }
                if (fl != 2 && fl != 0) {
                    System.out.println("Ошибка ввода. Выражение должно полностью состоять из арабских/римских символов. А так же символы должны быть в определённых границах");
                    throw new Exception();
                } else if (fl == 2) {
                    rezult = "RIM";
                } else  if (fl != 2){
                    fl = 0;
                    // Проверка на арабские цифры
                    for (int num : arabNumber) {
                        if (Integer.parseInt(number[0]) == num || Integer.parseInt(number[2]) == num) {
                            fl++;
                        }
                    }
                    if (number[0].equals(number[2])) {
                        fl++;
                    }
                    if (fl != 2) {
                        System.out.println("Ошибка ввода. Выражение должно полностью состоять из арабских/римских символов. А так же символы должны быть в определённых границах");
                        throw new Exception();
                    } else {
                        rezult = "ARAB";
                    }
                }
            }
            // Проверка на операции
            if (number[1].equals("/") || number[1].equals("+") || number[1].equals("-") || number[1].equals("*")) {
                return true;
            } else {
                System.out.println("Ошибка ввода. Введённая операция неосуществима");
                throw new Exception();
            }
        // Ошибка будет возникать, если при проверке на арабские цифры у нас будет происходить преобразования строки в int
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Выражение должно полностью состоять из арабских/римских символов");
            return false;
        } catch (Exception e) {
            return false;
            // Срабатывает, когда у нас у в выражении сочетание арабских и римских символов (Example: X / 2) или когда введена неверная ариф. операция
        }
    }

    // Метод для возвращение значения поля number
    public String[] getNumber() {
        return number;
    }

    public String getRezult() {
        return rezult;
    }
}
