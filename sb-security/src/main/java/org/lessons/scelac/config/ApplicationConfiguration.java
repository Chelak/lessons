package org.lessons.scelac.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author scelac
 */
@Configuration
@ComponentScan(value = "org.lessons")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
}
