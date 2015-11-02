package chapterTen;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class ChapterTenTest {

    @Test
    public void forInsurance() {
        //should be unknown
        Optional<Person> person = Optional.empty();
        String insurance = ChapterTen.getCarInsuranceName(person);
        assertEquals("Unknown", insurance);
    }

}
