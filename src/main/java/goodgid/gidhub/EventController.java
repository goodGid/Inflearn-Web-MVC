package goodgid.gidhub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/hello/{name}")
    public String events(@PathVariable("name") Person person){
        return "hello " + person.getName();
    }

}
