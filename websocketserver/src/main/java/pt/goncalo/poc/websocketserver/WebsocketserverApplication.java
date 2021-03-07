package pt.goncalo.poc.websocketserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class WebsocketserverApplication {



	public static void main(String[] args) {
		log.info("MAIN_WebsocketserverApplication");
		SpringApplication.run(WebsocketserverApplication.class, args);
	}

}
