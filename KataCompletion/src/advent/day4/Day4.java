package advent.day4;

/*--- Day 4: Scratchcards ---
The gondola takes you up. Strangely, though, the ground doesn't seem to be coming with you; you're not climbing a mountain. As the circle of Snow Island recedes below you, an entire new landmass suddenly appears above you! The gondola carries you to the surface of the new island and lurches into the station.

As you exit the gondola, the first thing you notice is that the air here is much warmer than it was on Snow Island. It's also quite humid. Is this where the water source is?

The next thing you notice is an Elf sitting on the floor across the station in what seems to be a pile of colorful square cards.

"Oh! Hello!" The Elf excitedly runs over to you. "How may I be of service?" You ask about water sources.

"I'm not sure; I just operate the gondola lift. That does sound like something we'd have, though - this is Island Island, after all! I bet the gardener would know. He's on a different island, though - er, the small kind surrounded by water, not the floating kind. We really need to come up with a better naming scheme. Tell you what: if you can help me with something quick, I'll let you borrow my boat and you can go visit the gardener. I got all these scratchcards as a gift, but I can't figure out what I've won."

The Elf leads you over to the pile of colorful cards. There, you discover dozens of scratchcards, all with their opaque covering already scratched off. Picking one up, it looks like each card has two lists of numbers separated by a vertical bar (|): a list of winning numbers and then a list of numbers you have. You organize the information into a table (your puzzle input).

As far as the Elf has been able to figure out, you have to figure out which of the numbers you have appear in the list of winning numbers. The first match makes the card worth one point and each match after the first doubles the point value of that card.

For example:

Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
In the above example, card 1 has five winning numbers (41, 48, 83, 86, and 17) and eight numbers you have (83, 86, 6, 31, 17, 9, 48, and 53). Of the numbers you have, four of them (48, 83, 17, and 86) are winning numbers! That means card 1 is worth 8 points (1 for the first match, then doubled three times for each of the three matches after the first).

Card 2 has two winning numbers (32 and 61), so it is worth 2 points.
Card 3 has two winning numbers (1 and 21), so it is worth 2 points.
Card 4 has one winning number (84), so it is worth 1 point.
Card 5 has no winning numbers, so it is worth no points.
Card 6 has no winning numbers, so it is worth no points.
So, in this example, the Elf's pile of scratchcards is worth 13 points.

Take a seat in the large pile of colorful cards. How many points are they worth in total?*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    public static int WIN_NUMBERS_SIZE = 10;
    public static int MY_NUMBERS_SIZE = 25;

    public static void main(String[] args) {

        List<String> winningNumbers = new ArrayList<>();
        List<String> myNumbers = new ArrayList<>();
        List<List<String>> tickets = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input/Day4.txt"));
//            BufferedReader br = new BufferedReader(new FileReader("input/Day4short.txt"));
            List<String> lines = br.lines().toList();

            for(int i = 0; i < lines.size(); i++) {
                winningNumbers = Arrays.stream(lines.get(i).substring(9, lines.get(i).indexOf("|")).trim().split("\\s+")).toList();
                myNumbers = Arrays.stream(lines.get(i).substring(lines.get(i).indexOf("|") + 1, lines.get(i).length()).trim().split("\\s+")).toList();
                tickets.add(winningNumbers);
                tickets.add(myNumbers);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        int totalPoints = 0;
        // iterujem zoznam polovic ticketov, ale vzdy len lavu stranu ticketu, teda tu s vitaznymi cislami
        for(int i = 0; i < tickets.size(); i+=2) {
            int ticketPoints = 1;
            for(int j = 0; j < tickets.get(i).size(); j++) {
                if(tickets.get(i+1).contains(tickets.get(i).get(j))) {
                    ticketPoints *= 2;
                }
            }
            if(ticketPoints > 0) {
                totalPoints += ticketPoints / 2;
            }
        }
        System.out.println(totalPoints); // result

        // test/debug
//        for(int i = 0; i < tickets.size(); i++) {
//            if(i % 2 == 0) {
//                System.out.println();
//            } else {
//                System.out.print(" || ");
//            }
//            for(int j = 0; j < tickets.get(i).size(); j++) {
//                System.out.print(tickets.get(i).get(j));
//                if(j < tickets.get(i).size() - 1) {
//                    System.out.print(",");
//                }
//            }
//        }

        // different testing/debuging
//        for(int i = 0; i < tickets.size(); i+=2) {
//            for(int j = 0; j < tickets.get(i).size(); j++) {
//                for(int k = j + 1; k < tickets.get(i).size(); k++) {
//                    if(Objects.equals(tickets.get(i).get(j), tickets.get(i).get(k))) {
//                        System.out.println(("Card ") + (i / 2 + 1));
//                        System.out.println(tickets.get(i).get(j));
//                    }
//                }
//            }
//        }

    }
}
