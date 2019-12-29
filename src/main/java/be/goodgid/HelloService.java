package be.goodgid;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getName(){
        return "goodgid";
    }
}
