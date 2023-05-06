package Interfaces;

public interface PurchasesList {
    void addPurchase(String title, int count);

    Purchase[] getPurchases();
}
