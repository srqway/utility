package idv.hsiehpinghan.datatypeutility.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("dataTypeUtilitySpringConfiguration")
@ComponentScan(basePackages = { "idv.hsiehpinghan.datatypeutility.utility" })
public class SpringConfiguration {
}
