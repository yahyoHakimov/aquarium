package org.example;

import java.util.List;
import java.util.Random;

public class Fish extends Thread {
    private static int fishCount = 0;
    private int fishId;
    private String gender;
    private int lifetime;

    private List<Fish> fishList;


    public Fish(String gender, int lifetime, List<Fish> fishList) {
        this.fishId = ++fishCount;
        this.lifetime = lifetime;
        this.gender = gender;
        this.fishList = fishList;
    }

    public Fish() {}


    @Override
    public void run() {
        int counter = 0;
        Random random = new Random();
        while (this.lifetime > 0) {
            try {
                Thread.sleep(100); //1 sec thread to'xtat
                lifetime--;

                if (random.nextDouble() < 0.1) {
                    int nasl = random.nextInt(2); // 0 - erkak, 1 - ayol
                    Fish newFish = new Fish(nasl == 0 ? "Erkak" : "Ayol", random.nextInt(30) + 10, fishList);
                    fishList.add(newFish);
                    counter++;
                    System.out.println(newFish.fishId+ " - yangi baliq tug'ildi");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fishList.remove(this);
        System.out.println(fishId + " - " + gender + " baliq o'ldi");



    }

}

