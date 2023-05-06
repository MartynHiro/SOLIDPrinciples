import Interfaces.Calculator;
import Interfaces.PurchasesList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//мапа для хранения товаров нашего магазина
        Map<String, Integer> products = new HashMap<>();

        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

//выводим информацию по нашему магазину
        PurchasesList purchasesList = startingMessage(products);

//создаем калькулятор для расчетов
        Calculator sumCalculator = CalculatorForPurchases.getInstance(products, purchasesList);

//пользовательский ввод
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите два слова: название товара и количество. Или end");

                String line = scanner.nextLine();

                if ("end".equals(line)) break;

                String[] parts = line.split(" ");

                String product = parts[0];

                int count = Integer.parseInt(parts[1]);

                purchasesList.addPurchase(product, count);
            }
        } catch (RuntimeException e) {
            System.out.println("Неверный ввод");
        }
//выводим все расчеты, основанные на пользовательском вводе на экран
        sumCalculator.calculate();
    }

    private static PurchasesList startingMessage(Map<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");

        products.forEach((key, value) -> System.out.println(key + " за " + value + " руб./шт."));

        //мапа продуктов уже определена, так что создаем хранилище для покупок на ее основе, если его еще нет
        return PurchasesListImpl.getInstance(products);
    }
}
