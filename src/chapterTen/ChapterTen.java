package chapterTen;

import java.util.Optional;
import java.util.Properties;
public class ChapterTen {

    public static String getCarInsuranceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
    //don't need to worry about performance boost from
    //use of primitive streams (OptionalInt) because optional can only have a single value
    public static Optional<Integer> stringToInt(String s){
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    
    public int readDuration(Properties props, String name){   
        String value = props.getProperty(name);
        if(value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0){
                    return i;
                }
            }catch (NumberFormatException nfe){}
        }
        return 0;
    }
    
    public int readDurationWithOptional(Properties props, String name){
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(ChapterTen::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }
}
