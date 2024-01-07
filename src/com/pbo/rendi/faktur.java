package com.pbo.rendi;

class faktur extends smartphone implements transaksi {
    private String invoiceNumber;
    private String customerName;
    private String NoHP;
    private String alamat;

    public faktur(String invoiceNumber, String customerName, String NoHP, String address, String itemName, int price,String berat, int quantity) {
        super(itemName, price, berat, quantity);
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.NoHP = NoHP;
        this.alamat = address;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getnoHP() {
        return NoHP;
    }

    public String getAddress() {
        return alamat;
    }
    
    @Override
    public int calculateTotal() {
        return getPrice() * getQuantity();
    }
}