package chapterTen;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.Properties;

import org.junit.Test;

public class ChapterTenTest {

    @Test
    public void forInsurance() {
        //should be unknown
        Optional<Person> person = Optional.empty();
        String insurance = ChapterTen.getCarInsuranceName(person);
        assertEquals("Unknown", insurance);
    }
    
    @Test
    public void propertiesTest(){
        Properties props = new Properties();
        props.setProperty("a",  "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
        ChapterTen chapter = new ChapterTen();
        assertEquals(5, chapter.readDuration(props, "a"));
        assertEquals(0, chapter.readDuration(props, "b"));
        assertEquals(0, chapter.readDuration(props, "c"));
        assertEquals(0, chapter.readDuration(props, "d"));
    }
}
