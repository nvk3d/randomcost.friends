package com.random.models;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by nvk3d on 16.05.17.
 */

public class Clients {
    private int minHumans = 0;
    private int maxHumans = 0;

    public Clients() {
    }

    public Clients(int minHumans, int maxHumans) {
        this.minHumans = minHumans;
        this.maxHumans = maxHumans;
    }

    /**
     * Возвращает случайное число
     * посетителей
     *
     * @return countClients
     */
    public int getRandomClients() {
        Random rand = new Random();
        return rand.nextInt(this.maxHumans - this.minHumans + 1) + this.minHumans;
    }

    /**
     * Инициализация клиентов (пользовательская)
     */
    public void initClients() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, введите наименьшее число посетителей (включая 0): ");
        this.minHumans = sc.nextInt();
        System.out.print("Пожалуйста, введите наибольшее число посетителей (включая 0): ");
        this.maxHumans = sc.nextInt();
    }

    public int getMinHumans() {
        return this.minHumans;
    }

    public int getMaxHumans() {
        return this.maxHumans;
    }

}
