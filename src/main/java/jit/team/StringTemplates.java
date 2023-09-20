package jit.team;
//import java.time.Instant;

import java.time.Instant;
import java.time.ZoneId;

import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;


class StringTemplates {

    public static void main(String[] args) {

        //JAVA 16 (records)
//        stringsInOldDays();

        //JAVA 21
//        stringTemplate();
//        stringTemplateOnBlock();
//        stringTemplateSquared();
//        rawTemplate();
        formatTemplate();

    }

    private static void stringsInOldDays() {
        var name = "Wojtek";
        String concatenation = "Możemy to zrobić sklejając imię: " +  name + " i inne dane";

        System.out.println(concatenation);

        String builderem = new StringBuilder()
                .append("Możemy użyć buildera ")
                .append("do podania imienia ")
                .append(name)
                .toString();

        System.out.println(builderem);
    }


    private static void stringTemplate() {
        var name = "Wojtek";
        var template = STR."A teraz można to zrobić tak i podać imię \{name}";

        System.out.println(template);
    }

//    private static void stringTemplateOnBlock() {
//        var name = "Wojtek";
//        var template = STR."""
//            Można też użyć string blocków
//            żeby dodac imię \{name}
//            ale i dynamiczne wartości np czas \{Instant.now()}
//        """;
//
//        System.out.println(template);
//    }


    private static void stringTemplateSquared() {

        var template = STR."""
            Można też użyć tamplate w tamplate \{STR."another template"}
            po co?
            no idea
        """;

        System.out.println(template);

    }

    private static void rawTemplate() {

        var name = "Wojtek";
        StringTemplate template = RAW."A teraz można to zrobić tak i podać imię \{name}";

        System.out.println(template);
//        System.out.println(template.interpolate());
    }

    private static void formatTemplate() {

        var name = "Wojtek";
        var data = Instant.now().atZone(ZoneId.systemDefault());

        System.out.println(STR."Czysta data: \{data}");

        String template = FMT."Używamy formatowanie jak String.format i wyciągamy rok => %tY\{data}";

        System.out.println(template);
    }
}