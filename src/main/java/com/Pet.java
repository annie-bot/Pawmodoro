package com;

public class Pet {
    private final String name;
    private int hungerLevel;
    private final LanguageManager lang;

    public Pet(String name, LanguageManager lang) {
        this.name = name;
        this.hungerLevel = 0;
        this.lang = lang;
    }

    public void feed() {
        hungerLevel = Math.max(0, hungerLevel - 1);
        System.out.println(lang.getMessage("pet.fed").replace("{name}", name) + " Nível de fome: " + hungerLevel);
    }

    public void increaseHunger() {
        hungerLevel++;
        System.out.println(lang.getMessage("pet.hungry").replace("{name}", name) + " Nível de fome: " + hungerLevel);
    }

    public LanguageManager getLanguageManager() {
        return lang;
    }
}