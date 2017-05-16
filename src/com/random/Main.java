package com.random;

import com.random.common.Calendar;
import com.random.models.Cost;
import com.random.models.Day;

import java.util.Scanner;

/**
 * Created by nvk3d 16.05.2017
 *
 * Данная программа предназначена
 * для подсчета доходов
 * от клиентов за определенный
 * срок.
 *
 * Количество клиентов
 * на дню выбирается случайно
 */

public class Main {
    private int[] needleDays;

    public static void main(String[] args) {
	    new Main().start();
    }

    public void start() {
        int [] params = this.initParams();
        Calendar calendar = new Calendar(params[0], params[1], params[2]);
        this.needleDays = calendar.getNeedleDays();
        Cost cost = new Cost(this.needleDays, params[2]);
        cost.countUpTotalCost(false);
        cost.getDaysInfo(true);
        cost.getTotal();
    }

    private int[] initParams() {
        int[] arr = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, введите год: ");
        arr[0] = sc.nextInt();

        System.out.print("Пожалуйста, введите количество месяцев: ");
        arr[1] = sc.nextInt();

        System.out.print("Пожалуйста, введите текущий месяц (номер): ");
        arr[2] = sc.nextInt();

        return arr;
    }

}
