package com.pbo.rendi;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;
import java.sql.ResultSet;

public class config {
  //config untuk koneksi dan interaksi dengan database

  private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost:3307/faktur";
  private static final String USER = "root";
  private static final String PASS = "";

  private static Connection connect;
  private static Statement statement;
  private static ResultSet resultData;

  
  public static void connection()
  
  {
    try {
      
      Class.forName(JDBC_DRIVER);

      
      connect = DriverManager.getConnection(DB_URL, USER, PASS);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  
public static boolean addData( String invoiceNumber, String customerName, String itemName, String merek, int price, int quantity, String NoHP, String alamat )
  {
    config.connection();
    boolean data = false;

    try {

      statement = connect.createStatement();

      String query = "INSERT INTO transaksi VALUES ('" + invoiceNumber + "', '" + customerName + "', '" + NoHP + "', '" + alamat + "', '" + itemName + "', '" + merek + "', " + price + ", " + quantity + ")";



      if( !statement.execute(query) ){
        data = true;
      }

      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static LinkedList<String> getAllData()
  {
    config.connection();

    LinkedList<String> data = new LinkedList<>();

    try {


      statement = connect.createStatement();


      String query = "SELECT no_faktur, nama_smartphone,harga_smartphone,merek_smartphone FROM transaksi";

      resultData = statement.executeQuery(query);

      while( resultData.next() ){
        String rowData = "no_faktur : " + resultData.getInt("no_faktur")
                        + "| Nama Barang : " + resultData.getString("nama_smartphone")
                        + "| Harga : " + resultData.getString("harga_smartphone")
                        + "| Merek : " + resultData.getString("merek_smartphone") + "\n";
                data.add(rowData);
      }
      

      statement.close();
      connect.close();


    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;

  }


public static boolean deleteData( int invoiceNumber )
  {
    connection();
    boolean data = false;

    try {
      
      statement = connect.createStatement();

      String query = "DELETE FROM transaksi WHERE no_faktur = " + invoiceNumber;

      if( !statement.execute(query) ){
        data = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }



public static boolean updateData( int invoiceNumber, String itemName,String merek, int quantity, int price )
  {

    config.connection();
    boolean data = false;

    try {

      statement = connect.createStatement();

      String queryCek = "SELECT * FROM transaksi WHERE no_faktur = " + invoiceNumber;

      resultData = statement.executeQuery(queryCek);

      String namaCek = ""; String merekCek = "";
      int stokCek = 0, hargaCek = 0;

      while( resultData.next() ){
        namaCek = resultData.getString("nama_smartphone");
        stokCek = resultData.getInt("jumlah_barang");
        hargaCek = resultData.getInt("harga_smartphone");
        merekCek = resultData.getString("merek_smartphone");
      }

      if( !itemName.equalsIgnoreCase("") ){
        namaCek = itemName;
      }
      if( quantity != 0 ){
        stokCek = quantity;
      }
      if( price != 0 ){
        hargaCek = price;
      }
      if( !itemName.equalsIgnoreCase("") ){
        merekCek = merek;
      }

      String queryUpdate = "UPDATE transaksi SET nama_smartphone = '" + namaCek + "', jumlah_barang = " + stokCek + ", harga_smartphone = " + hargaCek + ", merek_smartphone = '" + merekCek + "' WHERE no_faktur = '" + invoiceNumber + "'";
      
      if( !statement.execute(queryUpdate) ){
        data = true;
      }else{
        data = false;
      }

      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }


    return data;
  }
}



