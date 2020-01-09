package goodgid.gidhub;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new PersonFormatter());
//        registry.addConverter(new PersonConverter.StringToPersonConverter());
//        registry.addConverter(new PersonConverter.PersonToStringConvert());
    }


}





