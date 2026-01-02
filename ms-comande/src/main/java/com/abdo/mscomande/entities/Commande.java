package com.abdo.mscomande.entities;

import com.abdo.mscomande.Model.Client;
import com.abdo.mscomande.Model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id_commande;
    private Long id_client;
    private Long id_product;
    private int quantity;
    @Transient
    private Product product;
    @Transient
    private Client client;
    //
}
