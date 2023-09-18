package jit.team;

import java.time.Instant;
import java.util.Arrays;

class SwitchPatternMatching {

    public static void main(String[] args) {
        // JAVA 7
//        switchInJava7("dog");
//        switchInJava7("a cat");
//        switchInJava7(""); //need of break
//        switchInJava7(null); // NPE for null

        // JAVA 14
//        switchInJava14("dog");
//        switchInJava14("a cat");
//        switchInJava14(null); // NPE for null

        // JAVA 21
//        switchNull(null);
//        switchCanHandleDifferentTypes();
//        switchOverSealedClass(new Cat());
//        switchOverSealedClass(new Dog());
//        switchWithConditions("Dog");
//        switchWithConditions("Cat");

//        whenExtravaganza();
    }

    private static void whenExtravaganza() {
        class When {
            boolean when() {
                System.out.println("It's alive!");
                return true;
            }
        }
        var input = new When();
        switch (input) {
            case When when when when.when() -> when.when();
            default -> System.out.println("default");
        }
    }

    private static void switchWithConditions(final String animal) {
        var effect = switch (animal) {
            case String s when s.equals("Dog") -> "It'a dog";
            case String s when s.startsWith("Ca") -> "It's a ca*!";
            default -> String.format("Received [%s]%n", animal);
        };

        System.out.println(effect);
    }

    private static void switchNull(final String input) {
        var effect = switch (input) {
            case null -> "It was null";
            case "dog" -> "a doggy!";
            case "" -> "EMPTY";
            default -> String.format("Received [%s]%n", input);
        };

        System.out.println(effect);
    }

    private static void switchInJava7(String input) {
        switch (input) {
            case "dog":
                System.out.println("a doggy!");
                break;
            case "":
                System.out.println("EMPTY");
            default:
                System.out.printf("Received [%s]%n", input);
        }
    }

    private static void switchInJava14(String input) {
        var effect = switch (input) {
            case "dog" -> "a doggy!";
            case "" -> "EMPTY";
            default -> String.format("Received [%s]%n", input);
        };

        System.out.println(effect);
    }

    private static void switchCanHandleDifferentTypes() {
        switchOverClasses("hallo");
        switchOverClasses(42);
        switchOverClasses(42L);
        switchOverClasses(Instant.now());
        switchOverClasses(new double[]{5d, 7d, 73d});
    }

    private static void switchOverClasses(Object obj) {
        var res = switch (obj) {
            case String string -> "You're a String: " + string;
            case Integer integer -> "You're an Integer: " + integer;
            case Long aLong -> "You're a Long: " + aLong;
            case double[] doubleArray -> "You're a double array: " + Arrays.toString(doubleArray);
            case Instant instant -> "You're instant " + instant;
            default -> "You're something else, " + obj.getClass().getCanonicalName() + ": " + obj;
        };
        System.out.println(res);
    }

    private static void switchOverSealedClass(Animal obj) {
        var res = switch (obj) {
            case Dog dog -> "You're a dog: " + dog;
            case Cat cat -> "You're a cat: " + cat;
        };
        System.out.println(res);
    }
}


sealed interface Animal permits Cat, Dog {}

final class Cat implements Animal {}
final class Dog implements Animal {}