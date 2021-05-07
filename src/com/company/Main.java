package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        // Создаём объект класса InputLine. В нём мы вводим строку и присваиваем её закрытому полю line
        InputLine objLine = new InputLine();
        // Разбиваем строку по пробелом и отправляем в массив строк
        objLine.splitLine();
        // Проверка на всевозможные ошибки, которые могут возникнуть на первом этапе
        if (objLine.checkException()) {
            // Если программа не завершила работу, то создаём объект класса Calculate c параметром в виде массива строк, который нам вернёт метод getNumber
            Calculate calculate = new Calculate(objLine.getNumber(), objLine.getRezult());
            // Определяем какая операция будет выполнена и в этом же методе и запустим метод, ей соответствующий. А он нам выведет ответ или выдаст ошибку
            calculate.isOperation();
        }
    }
}
