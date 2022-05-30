package by.it.kameisha.jd02_01;

import by.it.kameisha.jd01_14.Util;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
    private final Shop shop;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        int number = 0;

        List<CustomerWorker> customerWorkerList = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            PriceListRepository priceListRepository = new PriceListRepository();
            int countCustomersPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < countCustomersPerSecond; i++) {
                Customer customer = new Customer(++number);

                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
                customerWorkerList.add(customerWorker);
                Timer.sleep(1000);
            }
        }
        for (CustomerWorker customerWorker : customerWorkerList) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(shop + " closed");
    }
}
