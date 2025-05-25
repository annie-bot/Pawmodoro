package com;

import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private int studyTime;
    private int breakTime;
    private int longBreakTime;
    private Pet pet;
    private LanguageManager lang;

    public PomodoroTimer(int studyTime, int breakTime, int longBreakTime, Pet pet) {
        this.studyTime = studyTime;
        this.breakTime = breakTime;
        this.longBreakTime = longBreakTime;
        this.pet = pet;
        this.lang = pet.getLanguageManager();
    }

    public void startPomodoro() {
        Timer timer = new Timer();
        for (int i = 0; i < 4; i++) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(lang.getMessage("study.finished"));
                    pet.increaseHunger();
                    pet.feed();
                }
            }, studyTime);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(lang.getMessage("pause.time"));
                }
            }, studyTime + breakTime);
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(lang.getMessage("long.pause"));
            }
        }, (studyTime + breakTime) * 4);
    }
}