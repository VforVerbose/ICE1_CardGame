/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Ali Alabdali (Student ID: 991711377) 09/23/2025
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        //hand of 7 cards
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        // make random cards
        for (int i = 0; i < magicHand.length; i++) {
            //insert code to ask the user for Card value and suit, create their card
             // and search magicHand here
            int randomValue = random.nextInt(13) + 1;
            int suitIndex = random.nextInt(Card.SUITS.length);

            Card c = new Card();
            c.setValue(randomValue);
            c.setSuit(Card.SUITS[suitIndex]);

            magicHand[i] = c;
        }
        
        // Add a hard-coded lucky card. This was edited directly in github
        Card luckyCard = new Card();
        luckyCard.setValue(13);
        luckyCard.setSuit("Spades");
        magicHand[6] = luckyCard;

        
        // search magicHand here
        System.out.println("Pick a card, any card!");
        System.out.print("Enter the card's number (1-13): ");
        int userValue = input.nextInt();
        input.nextLine();
        System.out.print("Enter the card's suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = input.nextLine();
        
       //Then report the result here
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true; // card found here
                break; 
            }
        }
        //Then report the result here
        if (found) {
            System.out.println("Nice, Card is in magic hand");
        } else {
            System.out.println("Card isn't in magic hand");
        }
        
        input.close();
    }
}
