package jit.team;

import java.time.Instant;
import java.util.Arrays;

class RecordPatternMatching {

    record Dog(Paws paws, Belly belly) {
    }

    record Paws(int feistiness) {
    }

    record Belly(int scrachiness) {
    }

    public static void main(String[] args) {
        var doggy = new Dog(
                new Paws(-1),
                new Belly(9001)
        );
        //JAVA 16 (records)
//        recordsInJava16(doggy);

        //JAVA 21
//        recordsInJava21(doggy);
//        recordsInJava21WithSwitch(doggy); //dominance error first

    }

    private static void recordsInJava16(Object input) {
        if (input instanceof Dog dog) {
            System.out.println("Paws are that feisty: " + dog.paws.feistiness);
            System.out.println("Belly is that prone to mizianko: " + dog.belly.scrachiness);

        }

    }

    private static void recordsInJava21(Object input) {
        if (input instanceof Dog(Paws(int feistyLevel), Belly belly)) {
            System.out.println("Paws are that feisty: " + feistyLevel);
            System.out.println("Belly is that prone to mizianko: " + belly.scrachiness);

        }
    }

//    private static void recordsInJava21WithSwitch(Object input) {
//        switch (input) {
//
//
//            case Dog(Paws paws, Belly belly) -> {
//                System.out.println("Paws are that feisty: " + paws.feistiness);
//                System.out.println("Belly is that prone to mizianko: " + belly.scrachiness);
//            }
//
//            case Dog(Paws(int feistyLevel), Belly belly) when feistyLevel < 0-> {
//                System.out.println("Paws are not feisty at all! It's just a cuddly good-boy");
//                System.out.println("Belly is that prone to mizianko: " + belly.scrachiness);
//            }
//
//            default -> {
//                System.out.println("default doggy style");
//            }
//
//        }
//
//    }


}