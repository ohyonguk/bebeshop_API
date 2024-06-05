package com.bebe.spring;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;


@SpringBootApplication
public class HomeController {
	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, args);
	}

	@Bean
	Hibernate5JakartaModule hibernate5Module(){
		Hibernate5JakartaModule hibernate5JakartaModule = new Hibernate5JakartaModule();
		hibernate5JakartaModule.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true);
		return hibernate5JakartaModule;
	}
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 *
		 * String formattedDate = dateFormat.format(date);
		 *
		 * model.addAttribute("serverTime", formattedDate);
		 */
		return "redirect:/index/index";

	}
	

}
