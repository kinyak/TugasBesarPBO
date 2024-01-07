package com.pbo.rendi;
import java.util.Scanner;
import java.util.Random;

public class app {
    private static Random random = new Random();
    private static StringBuilder captcha = new StringBuilder();
    private static String username = "rendi";
    private static String password = "123";

    public static void main(String[] args) {
        config.connection();

        for (int i = 0; i < 4; i++) {
            char randomChar;
            randomChar = (char) (random.nextInt(26) + 'A');
            captcha.append(randomChar);
        }
        String captchaString = captcha.toString();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Username: ");
        String userName = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String passWord = scanner.nextLine();

        if (userName.equals(username) && passWord.equals(password)) {

            System.out.println(captchaString);
            System.out.print("Masukkan captcha: ");
            String inputCaptcha = scanner.nextLine();

            if (inputCaptcha.equalsIgnoreCase(captchaString)) {
                System.out.println("Otentikasi berhasil. Selamat datang, " + userName + "!\n\n");
                System.out.println("======================================\n" +
                            "Selamat Datang di Toko Smartphone Pak Cik\n" +
                            "======================================\n" +
                            "Kami Menyediakan Berbagai Macam Merek Smartphone\n" +
                            "Silakan Menikmati Berbelanja di Toko Kami\n" +
                            "======================================");
                boolean isRunning = true;

                while (isRunning) {
            
                    System.out.print("\n====== MENU ======\n"
                            + "1. Tambah Penjualan Smartphone\n"
                            + "2. Lihat Daftar Penjualan Smartphone\n"
                            + "3. Hapus Data Penjualan Smartphone\n"
                            + "4. Update Data Penjualan Smartphone\n"
                            + "0. Keluar\n"
                            + "Pilih[1/2/3/4/0] : ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            try {
                                views.addData();
                            } catch (Exception e) {
                                System.err.println("Input tidak valid. Pastikan input sesuai dengan tipe data yang diminta.");
                            } finally {
                                System.out.println("===============Kasir===============");
                                String myString = "Rendi"; 
                                String uppercaseString = myString.toUpperCase();
                                System.out.println("Kasir\t\t\t: " + uppercaseString);
                            }
                            break;
                        case "2":
                            views.getAllData();
                            break;
                        case "3":
                            views.deleteData();
                            break;
                        case "4":
                            views.updateData();
                            break;
                        case "0":
                            System.out.println("Terima Kasih");
                            isRunning = false; // Keluar dari loop
                            break;
                        default:
                            System.out.println("Pilihan salah!!");
                            break;
                    }
                }
            } else {
                System.out.println("Captcha tidak valid. Autentikasi gagal.");
            }
        } else {
            System.out.println("Nama pengguna atau kata sandi tidak valid. Autentikasi gagal.");
        }

        scanner.close(); // Tutup Scanner setelah semua proses selesai
    }
}
