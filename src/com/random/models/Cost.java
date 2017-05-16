package com.random.models;

import java.util.Scanner;

/**
 * Created by nvk3d on 16.05.17.
 */
public class Cost {
    private Clients clients;
    private int[] needleDays;
    private int[] totalCost;
    private int[] prices;
    private int startMonth;
    private Day[] days;

    public Cost(int[] needleDays, int startMonth) {
        this.needleDays = needleDays;
        this.totalCost = new int[this.needleDays.length];
        this.startMonth = startMonth;
        this.writeDays();
    }

    /**
     * Подсчет и вывод общей стоимости
     *
     * @return int[]
     */
    public int[] countUpTotalCost(boolean print) {
        this.initPrices();
        this.clients.initVisits();
        this.pushTotalCost();

        if (!print) return this.totalCost;

        for (int i = 0; i < this.totalCost.length; i++) {
            System.out.println(this.totalCost[i]);
        }

        return this.totalCost;
    }


    /**
     * Статистика по дням
     *
     * @param print
     * @return Day[]
     */
    public Day[] getDaysInfo(boolean print) {
        if (!print) return this.days;

        int k = 0;  // для итого
        for (int i = 0; i < this.days.length; i++) {
            if (i > 0 && this.days[i].date < this.days[i-1].date) {
                System.out.println("Итого: " + this.totalCost[k] + " руб.");
                System.out.println();
                k++;
            }
            if (i == 0 || (i > 0 && this.days[i].date < this.days[i-1].date)) {
                System.out.println(this.getMonthByString(this.days[i].month));
            }
            System.out.print("" + this.days[i].date+" " + this.days[i].month
                    + ", клиентов: " + this.days[i].clients
                    + ", квестов: " + this.days[i].visits
                    + ", доход: " + this.days[i].cost + " руб.");
            if (i == this.days.length - 1) {
                System.out.println("\nИтого: " + this.totalCost[k] + " руб.");
            }
            System.out.println();
        }

        return this.days;
    }

    /**
     * Инициализация массива цен
     * за количество человек
     */
    public void initPrices() {
        Scanner sc = new Scanner(System.in);
        if (this.clients == null) {
            this.clients = new Clients();
            this.clients.initClients();
        }

        this.prices = new int[clients.getMaxHumans() + 1];
        int client = clients.getMinHumans();

        for (int i = 0; i <= clients.getMaxHumans(); i++) {
            System.out.print("Пожалуйста, введите стоимость за "
                    + client + " " + this.getRightHuman(client) + ": ");
            prices[i] = sc.nextInt();
            client++;
        }
    }

    public int getTotalCost(boolean print) {
        int sum = 0;
        for (int i = 0; i < this.totalCost.length; i++) {
            sum += this.totalCost[i];
        }
        if (print) System.out.println("Общий доход: " + sum + " руб.");
        return sum;
    }

    /**
     * Заполнение итоговых
     * цен
     */
    private void pushTotalCost() {
        int index = 0;

        for (int i = 0; i < this.needleDays.length; i++) {
            int sum = 0;

            // Берем случайных клиентов и считаем доход за день
            // Количество посещений также случайное
            for (int j = 0; j < this.needleDays[i]; j++) {

                // Передвигаем указатель на месяц вперед
                if (j == 0 && i != 0) index += this.needleDays[i - 1];

                // Случайный клиент и случайное кол-во посещений
                int val, visit = clients.getRandomVisits();

                // Подсчет клиентов за visit посещений
                for (int k = 0; k < visit; k++) {
                    while ((val = clients.getRandomClients()) == 0);
                    sum += this.prices[val];

                    // Заполняем поля дней
                    this.days[j + index].cost += this.prices[val];
                    this.days[j + index].clients += val;
                }

                //  Инициализация
                this.days[i].clients = this.days[i].visits == 0 ? 0 : this.days[i].clients;
                this.days[j + index].visits = visit;
                this.days[j + index].date = j + 1;
                this.days[j + index].month = this.getMonthByInt(
                        (this.startMonth + i) > 12 ? (this.startMonth + i) % 12 : this.startMonth + i);
            }
            this.totalCost[i] = sum;
        }
    }

    /**
     * Правильное склоение
     */
    private String getRightHuman(int val) {
        if (val == 1) return "человека";
        if (val == 0 || val >= 2 && val <= 9) return "человек";
        return "";
    }

    /**
     * Инициализация дней
     */
    private void writeDays() {
        // Иницализация дней
        int sum = 0;
        for (int i = 0; i < this.needleDays.length; i++) sum += this.needleDays[i];
        this.days = new Day[sum];

        int index = 0;
        for (int i = 0; i < this.needleDays.length; i++) {
            for (int j = 0; j < this.needleDays[i]; j++) {
                if (j == 0 && i != 0) index += this.needleDays[i - 1];
                this.days[j + index] = new Day();
            }
        }
    }

    private String getMonthByInt(int month) {
        switch (month) {
            case 1: return "января";
            case 2: return "февраля";
            case 3: return "марта";
            case 4: return "апреля";
            case 5: return "мая";
            case 6: return "июня";
            case 7: return "июля";
            case 8: return "августа";
            case 9: return "сентября";
            case 10: return "октября";
            case 11: return "ноября";
            case 12: return "декабря";
            default: return "";
        }
    }

    private String getMonthByString(String month) {
        switch (month) {
            case "января": return "Январь";
            case "февраля": return "Февраль";
            case "марта": return "Март";
            case "апреля": return "Апрель";
            case "мая": return "Май";
            case "июня": return "Июнь";
            case "июля": return "Июль";
            case "августа": return "Август";
            case "сентября": return "Сентябрь";
            case "октября": return "Октябрь";
            case "ноября": return "Ноябрь";
            case "декабря": return "Декабрь";
            default: return "";
        }
    }
}
