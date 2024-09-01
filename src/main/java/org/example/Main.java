package org.example;

import org.example.fieldParser.CronParser;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the cron-expression.");
        Scanner scanner = new Scanner(System.in);
        String cronExpression = scanner.nextLine();
        CronParser cronParser = new CronParser();
        cronParser.parseExpression(cronExpression);
        cronParser.viewExpandedExpression();
    }
}