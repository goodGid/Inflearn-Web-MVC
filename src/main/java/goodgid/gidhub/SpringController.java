package goodgid.gidhub;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

    @GetMapping("/request/body")
    public Person1 requestBody(@RequestBody Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

// ---------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/model/attribute")
    public Person1 modelAttribute(Person1 person1,
                                  Person2 person2,
                                  Person3 person3,
                                  Person4 person4,
                                  Person5 person5) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());

        System.out.println("Person2.Age : " + person2.getAge2_Long());
        System.out.println("Person2.Name : " + person2.getName());
        System.out.println("Person2.IsConvert : " + person2.getIsConvert());

        System.out.println("Person3.Age : " + person3.getAge3_String());
        System.out.println("Person3.Name : " + person3.getName());
        System.out.println("Person3.IsConvert : " + person3.getIsConvert());

        System.out.println("Person4.Age : " + person4.getAge4_String());
        System.out.println("Person4.Name : " + person4.getName());
        System.out.println("Person4.IsConvert : " + person4.getIsConvert());

        /**
         * 요청 Param에
         * 'age1_Long' 값이 있기 때문에
         * Model Attribute에 의해
         * 자동으로 Data Binding이 이뤄진다.
         */
        System.out.println("Person5.Age : " + person5.getAge1_Long());
        System.out.println("Person5.NickName : " + person5.getNickName());
        System.out.println("Person5.IsConvert : " + person5.getIsConvert());
        return person1;
    }

// ---------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/path/variable/{name}")
    public Person1 pathVariable_Name(@PathVariable("name") Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

    /**
     * @PathVariable를 삭제했다.
     */
    @GetMapping("/path/variable/{name}/model/attribute")
    public Person1 pathVariable_Name_Model_Attribute(Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

    /**
     * { ... } Path에 들어가는 값에 따른 차이를 보기 위해
     * 기존에 {name} - > {name2}로 수정을 하였다.
     */
    @GetMapping("/path/variable/2/{name2}")
    public Person1 pathVariable_Name2(@PathVariable("name2") Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

    /**
     * { ... } Path에 들어가는 값에 따른 차이를 보기 위해
     * 기존에 {name} - > {name2}로 수정을 하였다.
     * 추가적으로
     * @PathVariable 애노테이션을 삭제하였다.
     */
    @GetMapping("/path/variable/2/{name2}/model/attribute")
    public Person1 pathVariable_Name2_Model_Attribute(Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

    @GetMapping("/path/variable/{age}/{name}")
    public Person1 pathVariable_Age_Name(@PathVariable("age") Person1 person1, // age1_Long로 안해도된다.
                                         @PathVariable("name") Person1 person1_2) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());

        System.out.println("Person1_2.Age : " + person1_2.getAge1_Long());
        System.out.println("Person1_2.Name : " + person1_2.getName());
        System.out.println("Person1_2.IsConvert : " + person1_2.getIsConvert());
        return person1;
    }

    @GetMapping("/path/variable/{age}/{name}/model/attribute")
    public Person1 pathVariable_Age_Name_Model_Attribute(Person1 person1,
                                                         Person1 person1_2) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());

        System.out.println("Person1_2.Age : " + person1_2.getAge1_Long());
        System.out.println("Person1_2.Name : " + person1_2.getName());
        System.out.println("Person1_2.IsConvert : " + person1_2.getIsConvert());
        return person1;
    }

    @GetMapping("/path/variable/{age1_Long}/{name}/model/attribute/2")
    public Person1 pathVariable_Age_Name_Model_Attribute(@PathVariable("age1_Long") Person1 person1,
                                                         Person1 person1_2,
                                                         Person2 person2) { // Person1에서 Person2로 변경
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());

        System.out.println("Person1_2.Age : " + person1_2.getAge1_Long());
        System.out.println("Person1_2.Name : " + person1_2.getName());
        System.out.println("Person1_2.IsConvert : " + person1_2.getIsConvert());

        System.out.println("Person2.Age : " + person2.getAge2_Long());
        System.out.println("Person2.Name : " + person2.getName());
        System.out.println("Person2.IsConvert : " + person2.getIsConvert());
        return person1;
    }


// ---------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/request/param/age")
    public Person1 requestParam_Age(@RequestParam(value = "age", required = false) Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }











    @GetMapping("/request/param/age1_Long")
    public Person1 requestParam_Age1_Long(@RequestParam("age1_Long") Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

    @GetMapping("/request/param/age/not/converter")
    public Person3 requestParam_Age_Not_Converter(@RequestParam("age") Person3 person3) {
        System.out.println("Person3.Age : " + person3.getAge3_String());
        System.out.println("Person3.Name : " + person3.getName());
        System.out.println("Person3.IsConvert : " + person3.getIsConvert());
        return person3;
    }

    @GetMapping("/request/param/age3_String/not/converter")
    public Person3 requestParam_Age1_Long_Not_Converter(@RequestParam("age3_String") Person3 person3) {
        System.out.println("Person3.Age : " + person3.getAge3_String());
        System.out.println("Person3.Name : " + person3.getName());
        System.out.println("Person3.IsConvert : " + person3.getIsConvert());
        return person3;
    }

    @GetMapping("/request/param/not/request/param/annotation")
    public Person1 requestParam_Not_Request_Param_Annotation(Person1 person1) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());
        return person1;
    }

    @GetMapping("/request/param/age1_Long/name")
    public Person1 requestParam_Age1_Long_Name(@RequestParam("age1_Long") Person1 person1,
                                               @RequestParam("name") Person1 person1_2,
                                               @RequestParam("name") Person2 person2,
                                               Person2 person2_2) {
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());

        System.out.println("Person1_2.Age : " + person1_2.getAge1_Long());
        System.out.println("Person1_2.Name : " + person1_2.getName());
        System.out.println("Person1_2.IsConvert : " + person1_2.getIsConvert());

        System.out.println("Person2.Age : " + person2.getAge2_Long());
        System.out.println("Person2.Name : " + person2.getName());
        System.out.println("Person2.IsConvert : " + person2.getIsConvert());

        System.out.println("Person2_2.Age : " + person2_2.getAge2_Long());
        System.out.println("Person2_2.Name : " + person2_2.getName());
        System.out.println("Person2_2.IsConvert : " + person2_2.getIsConvert());
        return person1;
    }

    @GetMapping("/request/param/age1_Long/name/binding/result")
    public Person1 requestParam_Age1_Long_Name_Binding_Result(@RequestParam("age1_Long") Person1 person1,
                                                              @RequestParam("name") Person2 person2,
                                                              @RequestParam("name") Person3 person3,
                                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(c -> {
                System.out.println(c);
            });
        }
        System.out.println("Person1.Age : " + person1.getAge1_Long());
        System.out.println("Person1.Name : " + person1.getName());
        System.out.println("Person1.IsConvert : " + person1.getIsConvert());

        System.out.println("Person2.Age : " + person2.getAge2_Long());
        System.out.println("Person2.Name : " + person2.getName());
        System.out.println("Person2.IsConvert : " + person2.getIsConvert());

        System.out.println("Person3.Age : " + person3.getAge3_String());
        System.out.println("Person3.Name : " + person3.getName());
        System.out.println("Person3.IsConvert : " + person3.getIsConvert());

        return person1;
    }

}
