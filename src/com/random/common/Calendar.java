package com.random.common;

import java.util.ArrayList;

/**
 * Created by nvk3d on 16.05.17.
 */
public class Calendar {
    private int year = 0;
    private int countMonth = 0;
    private int currMonth = 0;
    private int[] needleDays;
    private int[] noLeapYearNum = {31,28,31,30,31,30,31,31,30,31,30,31};
    private int[] leapYearNum = {31,29,31,30,31,30,31,31,30,31,30,31};

    public Calendar(int year, int countMonth, int currMonth) {
        this.year = year;
        this.countMonth = countMonth;
        this.currMonth = currMonth;
        this.needleDays = new int[this.countMonth];
    }

    public int getYear() {
        return this.year;
    }

    public int getCurrMonth() {
        return this.currMonth;
    }

    public int getCountMonth() {
        return this.countMonth;
    }

    /**
     * Метод выдает массив количества
     * дней с текущего
     *
     * @return int[]
     */
    public int[] getNeedleDays() {
        int tmpYear = this.year;
        // Проверяем инициализацию месяца
        if (this.currMonth != 0) {
            int tmp = (this.currMonth - 1) % 12;
            for (int i = 0; i < this.countMonth; i++) {
                this.needleDays[i] = this.checkLeapYear() ? this.leapYearNum[tmp] : this.noLeapYearNum[tmp];
                tmp = (tmp + 1) % 12;
                // Первый месяц, те год уже закончился
                if (tmp == 0) this.year++;
            }
        }
        this.year = tmpYear;
        return this.needleDays;
    }

    private boolean checkLeapYear() {
        return (this.year % 4 == 0 && this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0);
    }
}
