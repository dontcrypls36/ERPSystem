package ru.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.erp.model.User;
import ru.erp.service.UserService;
import ru.erp.service.UserServiceImpl;

@Component
public class MainClass {

    @Autowired
    private UserService service;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        //System.out.println(Arrays.asList(context.getBeanDefinitionNames()).toString());
        UserService srv = (UserService)context.getBean(UserServiceImpl.class);

        User u = new User(100000, "John", "McKeanly", "email@email.com", "IT", "Programmer", "jmck", "123");

        srv.save(u);

        User u2 = srv.get(u.getId());

        u.setSurname("Smith");
        //srv.save(u);

        srv.delete(u.getId());
    }
}
