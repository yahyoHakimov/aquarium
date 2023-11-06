//package org.example;
//
//import java.util.*;
//import java.util.concurrent.*;
//
//class Fish {
//    enum Gender { MALE, FEMALE }
//    private static final Random rand = new Random();
//    private final Gender gender;
//    private final int lifespan;
//
//    public Fish() {
//        this.gender = rand.nextBoolean() ? Gender.MALE : Gender.FEMALE;
//        this.lifespan = rand.nextInt(10) + 1; // lifespan between 1 and 10
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public int getLifespan() {
//        return lifespan;
//    }
//}
//
//class Aquarium {
//    private final List<Fish> fishes = new CopyOnWriteArrayList<>();
//    private final ExecutorService executor = Executors.newCachedThreadPool();
//
//    public void addFish(Fish fish) {
//        fishes.add(fish);
//        executor.execute(() -> {
//            try {
//                Thread.sleep(fish.getLifespan() * 1000);
//                fishes.remove(fish);
//                System.out.println("A " + fish.getGender() + " fish has died.");
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//    }
//
//    public void reproduce() {
//        executor.execute(() -> {
//            while (true) {
//                long males = fishes.stream().filter(f -> f.getGender() == Fish.Gender.MALE).count();
//                long females = fishes.stream().filter(f -> f.getGender() == Fish.Gender.FEMALE).count();
//                if (males > 0 && females > 0) {
//                    addFish(new Fish());
//                    System.out.println("A new fish has been born!");
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        });
//    }
//}
//
//public class Try {
//    public static void main(String[] args) throws InterruptedException {
//        Aquarium aquarium = new Aquarium();
//        Random rand = new Random();
//        int initialMales = rand.nextInt(10);
//        int initialFemales = rand.nextInt(10);
//        for (int i = 0; i < initialMales; i++) {
//            aquarium.addFish(new Fish());
//        }
//        for (int i = 0; i < initialFemales; i++) {
//            aquarium.addFish(new Fish());
//        }
//        aquarium.reproduce();
//    }
//}