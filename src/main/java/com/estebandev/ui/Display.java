package com.estebandev.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
  static ArrayList<String> log = new ArrayList<>();
  static int maxChars = 40;
  static Scanner scanner = new Scanner(System.in);

  public static void add(String message, boolean show) {
    log.add(message);

    if (show) {
      show();
    }
  }

  public static void add(String message) {
    add(message, true);
  }

  public static String scan() {
    System.out.print("| >: ");
    String result = scanner.nextLine();
    return result;
  }

  public static void show() {
    cleanTerminal();

    printMarginW();

    log.forEach(message -> {
      System.out.print("|");

      if (message == "jumpline") {
        printMarginW();
      } else {
        double interval = (maxChars * 0.5);
        interval -= (message.length() / 2);

        for (int i = 1; i < (interval); i++) {
          System.out.print(" ");
        }

        System.out.print(message);

        for (int i = 1; i < (interval); i++) {
          System.out.print(" ");
        }

      }
      System.out.println("|");
    });

    printMarginW();
  }

  static void printMarginW() {
    System.out.println("\n|");
    for (int i = 0; i < maxChars; i++) {
      System.out.print("-");
    }
    System.out.print("|\n");
  }

  static void cleanTerminal() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
