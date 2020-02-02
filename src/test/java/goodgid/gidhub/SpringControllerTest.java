package goodgid.gidhub;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void requestBody_GetPerson() throws Exception {
        Person1 person1 = new Person1();
        person1.setAge1_Long(1L);
        person1.setName("goodgid");

        String jsonString = objectMapper.writeValueAsString(person1);

        mockMvc.perform(MockMvcRequestBuilders.get("/request/body")
                                              .contentType(MediaType.APPLICATION_JSON_UTF8)
                                              .accept(MediaType.APPLICATION_JSON_UTF8)
                                              .content(jsonString))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string(jsonString));
    }

    @Test
    public void modelAttribute_QueryString() throws Exception {
        Person1 person1 = new Person1();
        person1.setAge1_Long(1L);
        person1.setName("goodgid");
        String jsonString = objectMapper.writeValueAsString(person1);

        mockMvc.perform(MockMvcRequestBuilders.get(
                "/model/attribute?name=goodgid&age1_Long=1&age2_Long=2")
                                              .contentType(MediaType.APPLICATION_JSON_UTF8)
                                              .accept(MediaType.APPLICATION_JSON_UTF8))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string(jsonString));
    }

    @Test
    public void modelAttribute_Param() throws Exception {
        Person1 person1 = new Person1();
        person1.setAge1_Long(1L);
        person1.setName("goodgid");
        String jsonString = objectMapper.writeValueAsString(person1);

        mockMvc.perform(MockMvcRequestBuilders.get("/model/attribute")
                                              .param("name", "goodgid")
                                              .param("age1_Long", "1")
                                              .param("age2_Long", "2")
                                              .param("age3_String", "3")
                                              .param("age4_String", "4")
                                              .contentType(MediaType.APPLICATION_JSON_UTF8)
                                              .accept(MediaType.APPLICATION_JSON_UTF8))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string(jsonString));
    }


// ---------------------------------------------------------------------------------------------------------------------------------


    @Test
    public void pathVariable_Name() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/goodgid"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void pathVariable_Name_Model_Attribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/goodgid/model/attribute"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void pathVariable_Name2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/2/goodgid"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void pathVariable_Name2_Model_Attribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/2/goodgid/model/attribute"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void pathVariable_Age_Name() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/10/goodgid"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void pathVariable_Age_Name_Model_Attribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/10/goodgid/model/attribute"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void pathVariable_Age_Name_Model_Attribute_2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/path/variable/10/goodgid/model/attribute/2"))
               .andDo(print())
               .andExpect(status().isOk());
    }




// ---------------------------------------------------------------------------------------------------------------------------------


    @Test
    public void requestParam_Age___Param_Contains_age() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age")
                                              .param("name", "goodgid")
                                              .param("age", "1"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void requestParam_Age___Param_Contains_age1_Long() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age")
                                              .param("name", "goodgid")
                                              .param("age1_Long", "1"))
               .andDo(print())
               .andExpect(status().isOk());
    }


    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void requestParam_Age1_Long___Param_Contains_age() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age1_Long")
                                              .param("name", "goodgid")
                                              .param("age", "1"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void requestParam_Age1_Long___Param_Contains_age1_Long() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age1_Long")
                                              .param("name", "goodgid")
                                              .param("age1_Long", "1"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void requestParam_Age_Not_Converter___Param_Contains_age() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age/not/converter")
                                              .param("name", "goodgid")
                                              .param("age", "1"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void requestParam_Age_Not_Converter___Param_Contains_age3_String() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age3_String/not/converter")
                                              .param("name", "goodgid")
                                              .param("age3_String", "3"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void requestParam_Not_Request_Param_Annotation___Param_Contains_ALL() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/not/request/param/annotation")
                                              .param("name", "goodgid")
                                              .param("age1_Long", "1")
                                              .param("age2_Long", "2")
                                              .param("age3_String", "3")
                                              .param("age4_String", "4"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void requestParam_Age1_Long_Name___Param_Contains_ALL() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age1_Long/name")
                                              .param("name", "goodgid")
                                              .param("age1_Long", "1")
                                              .param("age2_Long", "2"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void requestParam_Age1_Long_Name_Binding_Result___Param_Contains_ALL() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/request/param/age1_Long/name/binding/result")
                                              .param("name", "goodgid")
                                              .param("age1_Long", "1")
                                              .param("age2_Long", "2"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    ////////////////////////////////////////////////////////////////////////////////////
}