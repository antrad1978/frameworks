package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping("/")
    @ResponseBody
    public String hello()
    {
        return "Hello!";
    }

    @RequestMapping("/customers")
    public List<Customer> customers() {
        List<Customer> results=new ArrayList<>();
        repository.findAll().forEach(customer -> {results.add(customer);});
        return results;
    }

    @RequestMapping("/search")
    public List<Customer> greeting(@RequestParam(value="name", defaultValue="") String name) {
        List<Customer> results=new ArrayList<>();
        repository.findByLastNameContains(name).forEach(customer -> {results.add(customer);});
        return results;
    }
}
