package com.example.demo.handler;

import com.example.demo.dao.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.model.PersonExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private PersonMapper personMapper;

    @PostMapping("/person")
    @ResponseBody
    public Person createReport(){
        Person person = new Person();
        person.setAge(10);
        person.setName("haha");
        int insert = personMapper.insert(person);
        return person;
    }

    @GetMapping("/person")
    @ResponseBody
    public List<Person> getReports(){
        return personMapper.selectByExample(new PersonExample());
    }
}
