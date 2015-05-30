package cn.org.guhao.zospringboot.tiles;

import org.springframework.context.annotation.Configuration;

/**
 * @author guhao
 * refer to the following website url:
 * http://spring.io/blog/2012/10/30/spring-mvc-from-jsp-and-tiles-to-thymeleaf/
 */
@Configuration
public class TilesConfiguration {

	/*
    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] { "WEB-INF/tiles/tiles.xml" });
        return configurer;
    }
    
//    @Bean
//    public SpringResourceTemplateResolver springTemplateResolver(){
//    	SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//    	resolver.setPrefix("/WEB-INF/templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setCacheable(false);
//        return resolver;
//    }
    
    @Bean 
    public ServletContextTemplateResolver templateResolver() {
    	ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/templates/");
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
    */
    
}