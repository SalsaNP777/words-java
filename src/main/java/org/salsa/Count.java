package org.salsa;

import java.util.*;

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Masukkan kata: ");
        input = scanner.nextLine();
        System.out.println(countLetters(input));

        System.out.println("Hitung lagi? (ya / tidak)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("ya")) {
            main(args);
        } else {
            System.out.println("Keluar dari program");
        }

        scanner.close();
    }

    public static String countLetters(String input) {
        // Convert string menjadi huruf kecil
        input = input.toLowerCase().replaceAll("[^a-z]", "");

        // Simpan jumlah huruf kedalam hashmap
        Map<Character, Integer> letterCount = new HashMap<>();

        // Iterasi setiap kata (String) pada array untuk menghitung jumlah huruf
        for (char c : input.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        // Cetak hasil
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            result.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
        }

        return result.toString();
    }
}
