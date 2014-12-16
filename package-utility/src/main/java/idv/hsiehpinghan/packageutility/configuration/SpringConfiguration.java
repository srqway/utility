package idv.hsiehpinghan.packageutility.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "idv.hsiehpinghan.packageutility.utility" })
public class SpringConfiguration {
}