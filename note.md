
 
## 11 스프링 MVC 동작 원리 마무리

- 191231 (Tue)

- DispatcherServlet 등록하는법 

1. 지금까지 강의에서 해오던 방식
    - web.xml로 등록
    
2. 이번 강의에서 사용할 방식
    - web.xml을 삭제한다.
    - WebApplication을 만든다.
        - Reference : be.goodgid.WebApplication
    - WebApplication에 Java로 DispatcherServlet을 등록한다.
    