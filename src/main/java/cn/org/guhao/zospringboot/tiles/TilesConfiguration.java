package cn.org.guhao.zospringboot.tiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * @author guhao
 * refer to the following website url:
 * http://spring.io/blog/2012/10/30/spring-mvc-from-jsp-and-tiles-to-thymeleaf/
 */
@Configuration
public class TilesConfiguration {

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        final ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setViewNames(new String[] {"*"});
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE);
        resolver.setCache(false);
        return resolver;
    }
	
    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] { "classpath:templates/tiles.xml" });
        return configurer;
    }
    
    @Bean 
    public ServletContextTemplateResolver templateResolver() {
    	ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("templates");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
}