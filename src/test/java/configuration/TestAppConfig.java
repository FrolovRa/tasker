package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"dao", "controller", "service"})
@EnableTransactionManagement
@Import({TestDatabaseConfig.class})
public class TestAppConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("app.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
}