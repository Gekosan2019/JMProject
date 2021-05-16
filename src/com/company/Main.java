package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Area player1 = new Area();
        int[] ship = {5, 4, 3, 2};
        int x = 0;
        player1.buildArea();
        player1.inputKoordAndCheck(ship[0], x);
        player1.inputKoordAndCheck(ship[1], x);
        player1.inputKoordAndCheck(ship[2],x);
        x = 1;
        player1.inputKoordAndCheck(ship[2], x);
        player1.inputKoordAndCheck(ship[3], x);
        Fight fight = new Fight(player1.getArea());
        boolean fl = true;
        int d = 0;
        while (fl) {
            fl = fight.inputBax(d, player1);
            d++;
        }
    }
}