package goodgid.gidhub;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class Person2Converter {

    @Component
    public static class StringToPersonConverter implements Converter<String, Person2> {
        @Override
        public Person2 convert(String s) {
            System.out.println("[Person`2` Converter] StringToPersonConverter Working");
            Person2 person2 = new Person2();
            person2.setIsConvert(true);
            return person2;
        }
    }

    @Component
    public static class PersonToStringConvert implements Converter<Person2, String> {
        @Override
        public String convert(Person2 person2) {
            return person2.getName();
        }
    }
}