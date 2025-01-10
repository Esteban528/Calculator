package com.estebandev.core;

import java.util.HashMap;

import com.estebandev.ui.Display;

public class Parser {
  public static Instructions parse(String instructLine) {
    char[] instructLineChar = instructLine.toCharArray();
    boolean[] numStatus = { false, false };
    Instructions instructions = new Instructions(0, 0, Operations.ADD);
    StringBuilder canva = new StringBuilder("");

    if (instructLine.toLowerCase().equals("exit")) {
      System.exit(1);
    }

    for (int i = 0; i < instructLineChar.length; i++) {
      char currentChar = instructLineChar[i];

      if (!numStatus[0]) {
        if (currentChar == '+' && i == 0)
          continue;

        if (isConvertible(currentChar) || (currentChar == '-' && canva.isEmpty()) || currentChar == '.') {

          canva.append(currentChar);
        } else {
          numStatus[0] = true;
          instructions.setOperation(parseOperation(currentChar));
          instructions.numbers[0] = Double.parseDouble(canva.toString());
          // System.out.println(instructions.numbers[0]);
          canva = new StringBuilder("");
        }

      } else if (!numStatus[1]) {
        if (isConvertible(currentChar) || currentChar == '.') {
          canva.append(currentChar);
        }
        if (i + 1 >= instructLineChar.length) {
          numStatus[1] = true;
          try {
            instructions.numbers[1] = Double.parseDouble(canva.toString());
          } catch (Exception e) {

          }
          canva = new StringBuilder("");
        }
      }
    }

    return instructions;
  }

  private static boolean isConvertible(char currentChar) {
    boolean isPosible = true;
    try {
      Integer.parseInt(Character.toString(currentChar));
    } catch (Exception e) {
      isPosible = false;
    }
    return isPosible;
  }

  public static Operations parseOperation(char operation) {
    return parseOperation(Character.toString(operation));
  }

  public static Operations parseOperation(String operation) {
    HashMap<String, Operations> operations = new HashMap<>();
    operations.put("+", Operations.ADD);
    operations.put("-", Operations.SUBSTRACT);
    operations.put("*", Operations.MULTIPLY);
    operations.put("/", Operations.DIVIDE);
    operations.put("?", Operations.SQRT);
    operations.put("^", Operations.POTENCY);
    // Display.add("operation:"+operation);

    return operations.get(operation);
  }
}
