package com.abdo.mscomande;

import com.abdo.mscomande.Feign.OpenFeignClientRest;
import com.abdo.mscomande.Feign.OpenFeignProductRest;
import com.abdo.mscomande.Model.Client;
import com.abdo.mscomande.Model.Product;
import com.abdo.mscomande.Repos.CommandeRepository;
import com.abdo.mscomande.entities.Commande;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class MsComandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsComandeApplication.class, args);
    }
    @Bean
    CommandLineRunner init(CommandeRepository commandeRepository, OpenFeignClientRest openFeignClientRest, OpenFeignProductRest openFeignProductRest) {
        return args -> {
            // si on utilise controller par defaut il faut utiliser collection au lieu de list puis .getContent() car dans openfein on a utiliser PagedModel
            List<Client> clients = openFeignClientRest.getAllClients();
            List<Product> products = openFeignProductRest.getAllProducts();

            System.out.println("Application de gestion des commandes démarrée...");
            for (Client client : clients) {
                for (Product product : products) {

                    Commande commande = Commande.builder()
                            .id_client(client.getId_client())
                            .id_product(product.getId_product())
                            .quantity((int) (Math.random() * 10) + 1)
                            .build();
                    commandeRepository.save(commande);

                }
            }
        };
    }

}
