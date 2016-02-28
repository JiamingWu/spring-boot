package hello.config;

import javax.servlet.Filter;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyFilter {

    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(someFilter());
        registration.addUrlPatterns("*.jsp");
        registration.setName("someFilter");
        return registration;
    }
    
    @Bean(name = "someFilter")
    public Filter someFilter() {
        return new ConfigurableSiteMeshFilter();
    }
    
}
