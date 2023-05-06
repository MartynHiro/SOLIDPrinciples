import Interfaces.Calculator;
import Interfaces.Purchase;
import Interfaces.PurchasesList;

import java.util.Map;

public class CalculatorForPurchases implements Calculator {

    private final Map<String, Integer> prices;
    private final PurchasesList purchases;
    private static CalculatorForPurchases instance;


    private CalculatorForPurchases(Map<String, Integer> prices, PurchasesList purchases) {
        this.prices = prices;
        this.purchases = purchases;
    }

    //проверяем есть ли уже объект такого калькулятора, если нет, то создаем новый
    public static CalculatorForPurchases getInstance(Map<String, Integer> products, PurchasesList purchases) {
        if (instance == null) {
            instance = new CalculatorForPurchases(products, purchases);
        }
        return instance;
    }

    //расчеты по каждому товару, а так же общая сумма покупок
    @Override
    public void calculate() {

        Purchase[] list = purchases.getPurchases();

        long totalSum = 0;

        System.out.println("КОРЗИНА:");

        for (Purchase purchase : list) {

            if (purchase == null) continue;

            int count = purchase.getCount();
            String title = purchase.getTitle();
            int sumOfOneProduct = count * prices.get(title);

            System.out.println("\t" + title + " " + count + " шт. в сумме " + sumOfOneProduct + " руб.");

            totalSum += sumOfOneProduct;
        }
        System.out.println("ИТОГО: " + totalSum);
    }
}
