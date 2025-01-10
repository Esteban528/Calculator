package com.estebandev.core;

import com.estebandev.ui.*;

public class Calculate {

  public static String run(Instructions instructions) {
    double result = 0;

    switch (instructions.getOperations()) {
      case ADD:
        result = instructions.getNumbers()[0] + instructions.getNumbers()[1];

        break;
      case SUBSTRACT:
        result = (instructions.getNumbers()[0] - instructions.getNumbers()[1]);

        break;
      case MULTIPLY:
        result = instructions.getNumbers()[0] * instructions.getNumbers()[1];

        break;
      case DIVIDE:
        if (instructions.getNumbers()[1] != 0)
          result = instructions.getNumbers()[0] / instructions.getNumbers()[1];
        else
          return "Undefined";

        break;
      case SQRT:
        if (instructions.getNumbers()[1] > 0)
          result = Math.sqrt(instructions.getNumbers()[0]);
        else
          return "Undefined";

        break;
      case POTENCY:
          result = Math.pow(instructions.getNumbers()[0], instructions.getNumbers()[1]);

        break;
    }
    return Double.toString(result);
  }

  static double divide(Double a, Double b) {

    return a/b;
  }
}
