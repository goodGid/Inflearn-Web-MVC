package goodgid.gidhub;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

public class CleanCode {

    @GetMapping("/events")
    @ResponseBody
    public String hello(Model model, SessionStatus sessionStatus) {
        sessionStatus.isComplete(); // false
        sessionStatus.setComplete();
        sessionStatus.isComplete(); // true
        return "hello";
    }

}
