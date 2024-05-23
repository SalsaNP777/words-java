package org.salsa;

import java.util.*;

public class CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;

        System.out.print("Masukkan jumlah kata: ");
        int numOfWords = scanner.nextInt();
        scanner.nextLine();

        List<String> strArray = new ArrayList<>();

        for (int i = 0; i < numOfWords; i++) {
            System.out.print("Masukkan kata ke-" + (i + 1) + ": ");
            strArray.add(scanner.nextLine());
        }

        result = countSort(strArray);
        System.out.println(result);

        System.out.println("Hitung lagi? (ya / tidak)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("ya")) {
            main(args);
        } else {
            System.out.println("Keluar dari program");
        }

        scanner.close();
    }

    public static String countSort(List<String> strArray) {
        // Membuat HashMap untuk menghitung jumlah huruf (character)
        Map<Character, Integer> charCount = new HashMap<>();

        // Iterasi setiap kata (String) pada array untuk menghitung jumlah huruf
        for (String str : strArray) {
            for (char c : str.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        // Urutkan berdasarkan jumlah huruf, lalu urutkan berdasarkan alphabet
        List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charCount.entrySet());
        sortedChars.sort((c1, c2) -> {
            // Membandingkan huruf berdasarkan jumlah kemunculannya, lalu urutkan dari yang terbesar ke terkecil
            int compare = c2.getValue().compareTo(c1.getValue());
            if (compare == 0) {
                // Jika jumlah huruf sama, bandingkan huruf berdasarkan alphabet, lalu urutkan secara ascending
                return c1.getKey().compareTo(c2.getKey());
            }
            return compare;
        });

        // Cetak hasil
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedChars) {
            result.append(entry.getKey());
        }

        return result.toString();
    }
}
