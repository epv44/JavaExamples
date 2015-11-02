package chapterTen;

import java.util.Optional;

public class ChapterTen {

    public static String getCarInsuranceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

}
