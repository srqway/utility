package idv.hsiehpinghan.classutility.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("classUtilitySpringConfiguration")
@ComponentScan(basePackages = { "idv.hsiehpinghan.classutility.utility" })
public class SpringConfiguration {
}