package com.abdo.mscomande.Web;


import com.abdo.mscomande.Feign.OpenFeignClientRest;
import com.abdo.mscomande.Feign.OpenFeignProductRest;
import com.abdo.mscomande.Repos.CommandeRepository;
import com.abdo.mscomande.entities.Commande;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComandeController {
    CommandeRepository commandeRepository;

    OpenFeignClientRest openFeignClientRest;

    OpenFeignProductRest openFeignProductRest;

    public  ComandeController(CommandeRepository commandeRepository, OpenFeignClientRest openFeignClientRest, OpenFeignProductRest openFeignProductRest) {
        this.commandeRepository = commandeRepository;
        this.openFeignClientRest = openFeignClientRest;
        this.openFeignProductRest = openFeignProductRest;
    }

    @GetMapping("/commandes/{id}")
    public Commande getComandeById(@PathVariable Long id) {

        Commande cm = commandeRepository.findById(id).get();
        cm.setClient(openFeignClientRest.getClientById(cm.getId_client()));
        cm.setProduct(openFeignProductRest.getProductById(cm.getId_product()));
        return cm;
    }

    @GetMapping("/commandes")
    public List<Commande> getAllComandes() {
        List<Commande> commandes = commandeRepository.findAll();
        for (Commande cm : commandes) {
            cm.setClient(openFeignClientRest.getClientById(cm.getId_client()));
            cm.setProduct(openFeignProductRest.getProductById(cm.getId_product()));
        }
        return commandes;

    }

}
