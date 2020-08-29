package com.shaikhalvee.ui.endpoint;

import com.shaikhalvee.ui.model.Greetings;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("http://localhost:4200")
@RestController
public class ResourceController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/greeting")
	public Greetings greeting(@RequestParam(value = "name", defaultValue = "Shaikh") String name) {
		return new Greetings(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greetings-cors")
	public Greetings greetingWithJavaConfig(
			@RequestParam(required=false, defaultValue="World") String name) {
		System.out.println("==== in greeting ====");
		return new Greetings(counter.incrementAndGet(), String.format(template, name));
	}
}
