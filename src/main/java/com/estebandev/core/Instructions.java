package com.estebandev.core;

import java.util.Arrays;

public class Instructions {
  public double[] numbers = { 0, 0 };
  private Operations operation;

  public Instructions(int a, int b, Operations operation) {
    this.numbers[0] = a;
    this.numbers[1] = b;
    this.operation = operation;
  }

  public Instructions() {

  }

  public void setOperation(Operations operations) {
    this.operation = operations;
  }

  public void setNumbers(double a, double b) {
    this.numbers[0] = a;
    this.numbers[1] = b;
  }

  public double[] getNumbers() {
    return this.numbers;
  }

  public Operations getOperations() {
    return this.operation;
  }

  @Override
  public String toString() {
    return "Instructions{" +
        "numbers=" + Arrays.toString(numbers) +
        ", operation=" + operation +
        '}';
  }
}
