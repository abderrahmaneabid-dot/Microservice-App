package com.abdo.mscomande.Feign;

import com.abdo.mscomande.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-CLIENT")
public interface OpenFeignClientRest {
    @GetMapping("/clients/{id}")
    Client getClientById(@PathVariable("id") Long id);

    @GetMapping("/clients")
    List<Client> getAllClients();
}
