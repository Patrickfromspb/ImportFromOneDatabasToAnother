

package com.company;



import com.company.db.Job;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.TimeZone;

/**
 * Точка входа в приложение. Подробнее
 * <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html"
 * >74.1 Create a deployable war file</a>.
 */


@SpringBootApplication
public class Application {


    protected Application() {
    }


    public static void main(final String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
        Job job =context.getBean(Job.class);
        job.init();
        job.saveToFile("User","output.json");
        job.readFromFile("output.json");
        job.saveToFile("User2","output2.json");
    }

}
