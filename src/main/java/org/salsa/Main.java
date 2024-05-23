package org.salsa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih menu: ");
        System.out.println("1. Menghitung jumlah huruf");
        System.out.println("2. Menghitung dan mengurutkan jumlah kata");
        System.out.println("3. Keluar");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                Count.main(args);
                break;
            case 2:
                CountSort.main(args);
                break;
            case 3:
                System.out.println("Keluar dari program");
                break;
            default:
                System.out.println("Pilihan anda salah");

        }
    }
}