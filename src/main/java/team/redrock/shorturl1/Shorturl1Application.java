package team.redrock.shorturl1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jmx.export.annotation.ManagedAttribute;

@ServletComponentScan
@SpringBootApplication
@MapperScan("team.redrock.shorturl1.mapper")

public class Shorturl1Application {

	public static void main(String[] args) {
		SpringApplication.run(Shorturl1Application.class, args);
	}
}
