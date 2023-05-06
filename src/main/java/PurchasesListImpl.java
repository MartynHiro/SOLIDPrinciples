import Interfaces.Purchase;
import Interfaces.PurchasesList;

import java.util.Map;

public class PurchasesListImpl implements PurchasesList {
    private final PurchaseImpl[] purchases;
    private static PurchasesListImpl instance;

    private PurchasesListImpl(Map<String, Integer> products) {
        //создаем массив покупок по длине мапы наших товаров
        this.purchases = new PurchaseImpl[products.size()];
    }

    //проверяем есть ли уже объект нашего хранилища, если нет то создаем новое
    public static PurchasesListImpl getInstance(Map<String, Integer> products) {
        if (instance == null) {
            instance = new PurchasesListImpl(products);
        }
        return instance;
    }

    //добавление покупки в наше хранилище
    @Override
    public void addPurchase(String title, int count) {
        var purchaseBuilder = new PurchaseBuilder();

        for (int i = 0; i < purchases.length; i++) {

            if (purchases[i] == null) {
                purchases[i] = purchaseBuilder
                        .setCount(count)
                        .setTitle(title)
                        .build();
                return;
            }

            if (purchases[i].getTitle().equals(title)) {
                purchases[i].setCount(purchases[i].getCount() + count);
                return;
            }
        }
    }

    @Override
    public Purchase[] getPurchases() {
        return purchases;
    }
}
