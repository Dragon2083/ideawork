package com.example.lagyuihotle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lagyuihotle.dao")
public class LagyuihotleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagyuihotleApplication.class, args);
    }

}
