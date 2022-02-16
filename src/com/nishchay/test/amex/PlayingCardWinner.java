package com.nishchay.test.amex;

public class PlayingCardWinner {

    public static void main(String[] args) {
        String playerACard = "A2T32JKQ";
        String playerBCard = "9TA45TJ4";

        System.out.println("No of wins by player1 - " + noOfWins(playerACard,playerBCard));
    }

    private static int noOfWins(String playerACard, String playerBCard) {
        int wins = 0;
        for (int i = 0; i < playerACard.length(); i++) {
            if(getCardsValue(playerACard.charAt(i)) > getCardsValue(playerBCard.charAt(i)))
                wins++;
        }
        return wins;
    }

    private static int getCardsValue(char card) {
        char[] chars = new char[]{'D', 'D' ,'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' ,'A' };

        int i = 0;
        for (; i < chars.length && chars[i] != card; i++);
        return i;
    }

}
