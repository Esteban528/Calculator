package com.estebandev;

import com.estebandev.core.Calculate;
import com.estebandev.core.Instructions;
import com.estebandev.core.Parser;
import com.estebandev.ui.Display;

public class App {
  public static void main(String[] args) {
    // System.out.println(Parser.parse("18*40"));

    Display.add("JavaCalculator V0.1");
    Display.add("jumpline");
    while (true) {
      String expresion = Display.scan();

      Display.add(expresion);
      Instructions operation = Parser.parse(expresion);
      Display.add(Calculate.run(operation));
      // Display.add("jumpline");
    }
  }
}
