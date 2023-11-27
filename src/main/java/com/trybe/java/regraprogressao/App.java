package com.trybe.java.regraprogressao;

import java.util.Locale;
import java.util.Scanner;

/**
 * App.
 */
public class App {

  private static int activityQuantity;
  private static int[] activityWeights;
  private static int[] activityGrades;

  /**
   * Metodo para obter a quantidade de atividades.
   */
  public static void registerActivity(Scanner scanner) {
    System.out.println("Digite a quantidade de atividades para cadastrar: ");
    String input = scanner.nextLine();

    activityQuantity = Integer.parseInt(input);
    String[] activityNames = new String[activityQuantity];
    activityWeights = new int[activityQuantity];
    activityGrades = new int[activityQuantity];

    for (int i = 1; i <= activityQuantity; i += 1) {
      System.out.println("Digite o nome da atividade " + i + ":");
      String name = scanner.nextLine();
      activityNames[i - 1] = name;

      System.out.println("Digite o peso da atividade " + i + ":");
      String weight = scanner.nextLine();
      activityWeights[i - 1] = Integer.parseInt(weight);

      System.out.println("Digite a nota obtida para " + activityNames[i - 1] + ":");
      String grade = scanner.nextLine();
      activityGrades[i - 1] = Integer.parseInt(grade);
    }
  }

  /**
   * Metodo para obter a soma dos pesos das atividades.
   */
  public static int getSumOfWeights() {
    int sum = 0;
    for (int i = 0; i < activityQuantity; i += 1) {
      sum += activityWeights[i];
    }

    return sum;
  }

  /**
   * Metodo para obter nota final.
   */
  public static void getFinalGrade() {
    int result = 0;
    for (int i = 0; i < activityQuantity; i += 1) {
      result += activityWeights[i] * activityGrades[i];
    }

    float finalGrade = result / 100.0f;
    if (finalGrade >= 85.0f) {
      System.out.printf(Locale.US, "Parabéns! Você alcançou %.1f%%!"
          + "E temos o prazer de informar que você obteve aprovação!%n", finalGrade);
    } else {
      System.out.printf(Locale.US, "Lamentamos informar que, "
          + "com base na sua pontuação alcançada neste período, "
          + "%.1f%%, "
          + "você não atingiu a pontuação mínima necessária para sua aprovação.%n", finalGrade);
    }
  }

  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    registerActivity(scanner);

    int sumOfWeights = getSumOfWeights();
    if (sumOfWeights != 100) {
      System.out.println("A soma dos pesos é diferente de 100!");
      return;
    }

    getFinalGrade();

    scanner.close();
  }
}
