package az.pashabank.tt.mscity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCityApplication.class, args);
    }

}
