package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {

  private static int activityQuantity;
  private static int[] activityWeights;
  private static int[] activityGrades;

  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
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
}
