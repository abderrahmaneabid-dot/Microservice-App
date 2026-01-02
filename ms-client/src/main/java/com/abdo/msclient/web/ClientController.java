package com.abdo.msclient.web;


import com.abdo.msclient.Repos.ClientRepository;
import com.abdo.msclient.config.GlobalConfig;
import com.abdo.msclient.config.TestParam;
import com.abdo.msclient.entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClientController {
    public ClientController(ClientRepository clientRepository , GlobalConfig globalConfig , TestParam testParam) {
        this.globalConfig = globalConfig;
        this.testParam = testParam;
        this.clientRepository = clientRepository;
    }

    ClientRepository clientRepository;
    GlobalConfig globalConfig;
    TestParam testParam;

    @GetMapping("/configs")
    public GlobalConfig getGlobalConfig(){
        return globalConfig;
    }

    @GetMapping("/testparams")
    public TestParam getTestParams(){
        return testParam;
    }


    @GetMapping("/clients")
    List<Client> Allclients(){
        return clientRepository.findAll();
    }



    @GetMapping("/clients/{id}")
    Client getClientById(@PathVariable Long id){
        return clientRepository.findById(id).orElse(null);
    }

    @PostMapping("/clients")
    Client saveClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{id}")
    Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client cl = clientRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(client, cl);
        return clientRepository.save(client);
    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

}
