package com.random.models;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by nvk3d on 16.05.17.
 */

public class Clients {
    private int minHumans = 0;
    private int maxHumans = 0;
    private int minVisits = 0;
    private int maxVisits = 0;

    public Clients() {
    }

    public Clients(int minHumans, int maxHumans, int minVisits, int maxVisits) {
        this.minHumans = minHumans;
        this.maxHumans = maxHumans;
        this.minVisits = minVisits;
        this.maxVisits = maxVisits;
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
     * Возвращает случайное число
     * посещений
     *
     * @return countClients
     */
    public int getRandomVisits() {
        Random rand = new Random();
        return rand.nextInt(this.maxVisits - this.minVisits + 1) + this.minVisits;
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

    /**
     * Инициализация посещений (пользовательская)
     */
    public void initVisits() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, введите наименьшее число посещений (включая 0): ");
        this.minVisits = sc.nextInt();
        System.out.print("Пожалуйста, введите наибольшее число посещений (включая 0): ");
        this.maxVisits = sc.nextInt();
        System.out.println();
    }

    public int getMinHumans() {
        return this.minHumans;
    }

    public int getMaxHumans() {
        return this.maxHumans;
    }

    public int getMinVisits() {
        return this.minVisits;
    }

    public int getMaxVisits() {
        return this.maxVisits;
    }

}
