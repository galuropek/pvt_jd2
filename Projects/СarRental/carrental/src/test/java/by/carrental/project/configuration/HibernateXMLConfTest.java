package by.carrental.project.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:hibernate5configuration-test.xml"})
@ComponentScan(basePackages = {"by.carrental.project.dao"})
public class HibernateXMLConfTest {
}
