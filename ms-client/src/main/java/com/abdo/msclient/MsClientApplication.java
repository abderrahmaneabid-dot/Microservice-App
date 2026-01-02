package com.abdo.msclient;

import com.abdo.msclient.Repos.ClientRepository;
import com.abdo.msclient.config.GlobalConfig;
import com.abdo.msclient.config.TestParam;
import com.abdo.msclient.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class , TestParam.class})
public class MsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsClientApplication.class, args);
    }
    @Bean
    CommandLineRunner init(ClientRepository clientRepository) {
        return args -> {
            // You can add initialization code here if needed
            Client c1 = Client.builder()
                    .first_name("Abid Abdo")
                    .last_name("Abderrahmane")
                    .email("A@gmail.com")
                    .build();
            clientRepository.save(c1);

            Client c2 = Client.builder()
                    .first_name("John")
                    .last_name("Doe")
                    .email("j@gmail.com")
                    .build();
            clientRepository.save(c2);

            List<Client> clients = clientRepository.findAll();
            clients.forEach(c -> {
                System.out.println(c);
            });
        };


    }
}
