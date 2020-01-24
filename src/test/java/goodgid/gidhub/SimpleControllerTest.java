package goodgid.gidhub;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SimpleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(print())
                .andExpect(content().string("hello"));
    }

    @Test
    public void defaultStatic() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/index.html"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(Matchers.containsString("hello index")));
    }

    @Test
    public void customStatic() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/mobile/index.html"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(Matchers.containsString("hello mobile")))
                    .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }

}