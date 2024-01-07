package com.pbo.rendi;
import java.util.*;
import java.text.*;

public class views {
public static Scanner input = new Scanner(System.in);
    
    public static void getAllData()
  {
    //  pesan header
    System.out.println("\n::: DATA BARANG :::");
    // data semua barangnya
    System.out.println(config.getAllData());
    System.out.print("\n");
  }
  public static void addData()
  {
    Date HariSekarang = new Date();
    Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan Nomor Faktur: ");
            String invoiceNumber = scanner.nextLine();

            System.out.print("Masukkan Nama Pelanggan: ");
            String customerName = scanner.nextLine();

            System.out.print("Masukkan No Handphone: ");
            String NoHP = scanner.nextLine();

            System.out.print("Masukkan Alamat: ");
            String alamat = scanner.nextLine();

            System.out.print("Masukkan Nama Smartphone: ");
            String itemName = scanner.nextLine();

            System.out.print("Masukkan Merek Smartphone: ");
            String merek = scanner.nextLine();

            System.out.print("Masukkan Harga Smartphone: ");
            int price = scanner.nextInt();

            System.out.print("Masukkan Jumlah Barang: ");
            int quantity = scanner.nextInt();


            faktur invoice = new faktur(invoiceNumber, customerName, NoHP, alamat, itemName, price, merek, quantity);
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
            System.out.println();  
            System.out.println("============MINIMARKET============");
            System.out.println("Tanggal \t\t: " + ft.format(HariSekarang));
            System.out.println("Waktu\t\t\t: " + format.format(HariSekarang));
            System.out.println("Nomor Faktur\t\t: " + invoice.getInvoiceNumber());
            System.out.println("==========Data Pelanggan==========");
            System.out.println("Nama Pelanggan\t\t: " + invoice.getCustomerName());
            System.out.println("No Handphone\t\t: " + invoice.getnoHP());
            System.out.println("Alamat\t\t\t: " + invoice.getAddress());
            System.out.println("============Data Barang============");
            System.out.println("Nama Barang\t\t: " + invoice.getSmartphoneName());
            System.out.println("Harga Barang\t\t: " + invoice.getPrice());
            System.out.println("Berat Barang\t\t: " + invoice.getMerek());
            System.out.println("Jumlah Barang\t\t: " + invoice.getQuantity());
            System.out.println("Total Bayar\t\t: " + invoice.calculateTotal());


    if (config.addData(invoiceNumber, customerName, itemName, merek, price,  quantity, NoHP, alamat) ){
      System.out.println("Data Barang berhasil ditambahkan!!");
      views.getAllData();
    }else{
      System.out.println("Data Barang gagal ditambahkan!!");
    }
    
  }  

  public static void deleteData()
  {
    System.out.println("\n:::DELETE DATA BARANG :::");
    System.out.print("Masukkan ID Barang : ");
    int invoiceNumber = input.nextInt();

    if( config.deleteData(invoiceNumber) ){
      System.out.println("Data Barang Berhasil Dihapus!!");
      getAllData();
    }else{
      System.out.println("Data Barang Gagal Dihapus!!");
    }

  }

  public static void updateData()
  {
    System.out.println("\n::: UPDATE DATA BARANG :::");
    System.out.print("Masukkan No Faktur : ");
    int invoiceNumber = input.nextInt();
    System.out.println("\nGanti Data Barang\n");
    System.out.print("Nama Barang (Kosongkan jika tidak ingin mengganti datanya) : ");
    String itemName = input.nextLine();
    itemName = input.nextLine();

    System.out.print("Banyak Barang (isi 0 jika tidak ingin merubah data) : ");
    int quantity = input.nextInt();
    
    System.out.print("Harga Barang (isi 0 jika tidak ingin merubah data) : ");
    int price = input.nextInt();
    
    System.out.print("Merek Barang (Kosongkan jika tidak ingin mengganti datanya) : ");
    String merek = input.nextLine();
    merek = input.nextLine();

    if( config.updateData(invoiceNumber, itemName, merek, quantity, price) ){
      System.out.println("Data barang berhasil dirubah!!");
      views.getAllData();
    }else{
      System.out.println("Data barang gagal dirubah!!");
    }
    
  }
  
}
