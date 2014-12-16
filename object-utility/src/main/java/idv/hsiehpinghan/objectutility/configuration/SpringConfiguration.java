package idv.hsiehpinghan.objectutility.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("objectUtilitySpringConfiguration")
@ComponentScan(basePackages = { "idv.hsiehpinghan.objectutility.utility" })
public class SpringConfiguration {
}
