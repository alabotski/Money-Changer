package com.moneychanger;

import java.util.Arrays;

public class CoffeeSale {

  private static final int COFFEE_PRICE = 5;

  private static final int[] MONEY_NOMINAL = new int[] {20, 10, 5};
  private static final int[] CASH_DESK = new int[] {0, 0, 0};

  public static void main(String[] args) {
    int[] queue1 = new int[] {5, 10, 5, 20};
    System.out.println("Can sell coffee [" + Arrays.toString(queue1) + "] = " + coffeeSale(queue1));

    int[] queue2 = new int[] {10, 5};
    System.out.println("Can sell coffee [" + Arrays.toString(queue2) + "] = " + coffeeSale(queue2));

    int[] queue3 = new int[] {5, 10, 5, 20, 10};
    System.out.println("Can sell coffee [" + Arrays.toString(queue3) + "] = " + coffeeSale(queue3));
  }

  private static boolean coffeeSale(int[] queue) {
    resetCashDeskToZero();

    for (int i = 0; i < queue.length; i++) {
      pay(queue[i]);
      if (!exchangeMoney(queue[i] - COFFEE_PRICE)) {
        return false;
      }
    }
    return true;
  }

  private static void resetCashDeskToZero() {
    for (int i = 0; i < CASH_DESK.length; i++) {
      CASH_DESK[i] = 0;
    }
  }

  private static void pay(int sum) {
    for (int i = 0; i < MONEY_NOMINAL.length; i++) {
      if (MONEY_NOMINAL[i] / sum == 1) {
        CASH_DESK[i]++;
      }
    }
  }

  private static boolean exchangeMoney(int sum) {
    if (sum <= 0) {
      return true;
    }

    for (int i = 0; i < MONEY_NOMINAL.length; ++i) {
      int count = sum / MONEY_NOMINAL[i];
      if (count > CASH_DESK[i]) {
        count = CASH_DESK[i];
      }
      CASH_DESK[i] -= count;
      sum -= MONEY_NOMINAL[i] * count;
    }
    return !(sum > 0);
  }
}
