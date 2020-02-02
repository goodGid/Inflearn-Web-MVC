package goodgid.gidhub;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class Person1Converter {

    @Component
    public static class StringToPersonConverter implements Converter<String, Person1> {
        @Override
        public Person1 convert(String s) {
            System.out.println("[Person`1` Converter] StringToPersonConverter Working");
            Person1 person1 = new Person1();
            person1.setIsConvert(true);
            return person1;
        }
    }

    @Component
    public static class PersonToStringConvert implements Converter<Person1, String> {
        @Override
        public String convert(Person1 person1) {
            return person1.getName();
        }
    }

}