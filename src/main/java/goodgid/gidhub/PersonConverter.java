package goodgid.gidhub;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class PersonConverter  {

    @Component
    public static class StringToPersonConverter implements Converter<String, Person> {
        @Override
        public Person convert(String s) {
            Person person = new Person();
            person.setName(s);
            return person;
        }
    }

    @Component
    public static class PersonToStringConvert implements Converter<Person, String> {
        @Override
        public String convert(Person person) {
            return person.getName();
        }
    }
}
