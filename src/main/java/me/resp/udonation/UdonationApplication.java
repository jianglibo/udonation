package me.resp.udonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.SpringWebFluxTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.reactive.ThymeleafReactiveViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication
public class UdonationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdonationApplication.class, args);
	}

	// https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-view
	@Bean
	public SpringResourceTemplateResolver templateResolver(ApplicationContext applicationContext) {
		// SpringResourceTemplateResolver automatically integrates with Spring's own
		// resource resolution infrastructure, which is highly recommended.
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("classpath:WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		// HTML is the default value, added here for the sake of clarity.
		templateResolver.setTemplateMode(TemplateMode.HTML);
		// Template cache is true by default. Set to false if you want
		// templates to be automatically updated when modified.
		templateResolver.setCacheable(true);
		return templateResolver;
	}

	@Bean
	public SpringWebFluxTemplateEngine templateEngine(ApplicationContext applicationContext) {
		// SpringTemplateEngine automatically applies SpringStandardDialect and
		// enables Spring's own MessageSource message resolution mechanisms.
		SpringWebFluxTemplateEngine templateEngine = new SpringWebFluxTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver(applicationContext));
		// Enabling the SpringEL compiler with Spring 4.2.4 or newer can
		// speed up execution in most scenarios, but might be incompatible
		// with specific cases when expressions in one template are reused
		// across different data types, so this flag is "false" by default
		// for safer backwards compatibility.
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	@Bean
	public ThymeleafReactiveViewResolver viewResolver(ApplicationContext applicationContext) {
		ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
		viewResolver.setTemplateEngine(templateEngine(applicationContext));
		// NOTE 'order' and 'viewNames' are optional
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] { ".html", ".xhtml" });
		return viewResolver;
	}

}
