package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required = false) String name) {
    	
    	System.out.println("xxxx");
    	
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    
    
    @RequestMapping(value = "/tests", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseBody
    public Person getPerson(@RequestBody Person ps) {
    	Person p = new Person();
    	p.setName(ps.getName());
    	return p;
    }
}
