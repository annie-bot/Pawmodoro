package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o idioma / Choose your language (pt/en):");
        String language = scanner.nextLine().equalsIgnoreCase("pt") ? "pt" : "en";

        LanguageManager lang = new LanguageManager(language);

        System.out.println(lang.getMessage("pet.name"));
        String petName = scanner.nextLine();
        Pet pet = new Pet(petName, lang);

        int defaultStudyTime = 25 * 60 * 1000;
        int defaultBreakTime = 5 * 60 * 1000;
        int defaultLongBreakTime = 15 * 60 * 1000;

        System.out.println(lang.getMessage("adjust.time"));
        String adjust = scanner.nextLine();
        if (adjust.equalsIgnoreCase("s") || adjust.equalsIgnoreCase("y")) {
            System.out.println(lang.getMessage("study.time"));
            defaultStudyTime = scanner.nextInt() * 60 * 1000;

            System.out.println(lang.getMessage("break.time"));
            defaultBreakTime = scanner.nextInt() * 60 * 1000;

            System.out.println(lang.getMessage("long.break.time"));
            defaultLongBreakTime = scanner.nextInt() * 60 * 1000;
        }

        PomodoroTimer timer = new PomodoroTimer(defaultStudyTime, defaultBreakTime, defaultLongBreakTime, pet);
        timer.startPomodoro();

        scanner.close();
    }
}