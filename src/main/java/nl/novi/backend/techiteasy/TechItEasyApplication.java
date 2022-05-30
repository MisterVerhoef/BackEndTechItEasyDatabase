package nl.novi.backend.techiteasy;

import nl.novi.backend.techiteasy.Models.Television;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechItEasyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechItEasyApplication.class, args);
    }


    Television television = new Television(1L, "4k", "Sony","55RX", 1.200, 55., 120., "OLED", "A+", true, true, true, true, true, true, 23,5 );

}
