package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int numMaleFish = random.nextInt(50) + 1; // Random baliqlar soni
        int numFemaleFish = random.nextInt(50) + 1; // Random urg'ochi ayollar soni

        List<Thread> fishThreads = new ArrayList<>();
        List<Fish> fishList = new ArrayList<>();

        System.out.println("Aquariumda " + numFemaleFish + " ta ayol va " + numMaleFish + " ta erkak baliqlar bor.");

        for (int i = 0; i < numMaleFish; i++) {
            int lifetime = random.nextInt(30) + 10; // Random hayot vaqti erkak uchun
            Fish fish = new Fish("Erkak", lifetime, fishList);
            fishThreads.add(fish);
            fish.start();
        }
        for (int i = 0; i < numFemaleFish; i++) {
            int lifetime = random.nextInt(30) + 10; // Random hayot vaqti ayol uchun
            Fish fish = new Fish("Ayol", lifetime, fishList);
            fishThreads.add(fish);
            fish.start();
        }

        try {
            for (Thread thread : fishThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}


