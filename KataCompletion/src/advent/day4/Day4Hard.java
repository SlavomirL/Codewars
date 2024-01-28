package advent.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day4Hard {

    public static void main(String[] args) {

        List<String> winningNumbers = new ArrayList<>();
        List<String> myNumbers = new ArrayList<>();
        List<List<String>> tickets = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input/Day4.txt"));
//            BufferedReader br = new BufferedReader(new FileReader("input/Day4short.txt"));

            List<String> lines = br.lines().toList();
            for (int i = 0; i < lines.size(); i++) {
                winningNumbers = Arrays.stream(lines.get(i).substring(9, lines.get(i).indexOf("|")).trim().split("\\s+")).toList();
                myNumbers = Arrays.stream(lines.get(i).substring(lines.get(i).indexOf("|") + 1, lines.get(i).length()).trim().split("\\s+")).toList();
                tickets.add(winningNumbers);
                tickets.add(myNumbers);
            }


            int totalCards = 0;
            int particularCardQty = 0;
            Map<Integer, Integer> cardsQtyMap = new HashMap<>();
            // vytvoril si si mapu kart kde key je cislo karty a value je pocet ks kolko ich mam. na zaciatku mam z kazdej 1 ks
            for (int i = 1; i <= lines.size(); i++) {
                cardsQtyMap.put(i, 1);
            }

            for (int i = 0; i < tickets.size(); i += 2) { // iterujes kazdy riadok, teda kazdy ticket..kazdy ticket ma lavu a pravu stranu, preto je tam +2
                int ticketPoints = 0;
                for (int j = 0; j < tickets.get(i).size(); j++) {
                    if (tickets.get(i + 1).contains(tickets.get(i).get(j))) {
                        // ak sa na pravej strane nachadza cislo z lavej strany, ticketPoints sa zvysi
                        ticketPoints++;
                    }
                }
                // kazdy ticketPoint ti prida jednu kartu z nasledujucich cisel..teda napr. ticket point 3, ak sme na karte 5, prida jednu kartu do karty 6, jednu do karty 7 a jednu do karty 8
                for (int k = 1; k <= ticketPoints; k++) {
                    if (i / 2 + 1 + k <= cardsQtyMap.size()) { // mapu zacinam od 1 narozdiel od klasickeho indexovania od 0, preto je tam +1. zaroven nechces zacinat od prvej karty v hashmape, lebo pridavas az do dalsej..preto +k
                        cardsQtyMap.put(i / 2 + 1 + k, cardsQtyMap.get(i / 2 + 1 + k) + cardsQtyMap.get(i / 2 + 1)); // v hashmape na indexe ktory je nasledujuci oproti sucasnej karte navys jeho hodnotu a pocet kariet na indexe ktory prave riesis
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : cardsQtyMap.entrySet()) {
                totalCards += entry.getValue();
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }
            System.out.println(totalCards);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
