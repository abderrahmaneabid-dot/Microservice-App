package com.abdo.msclient.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString
public class Client {
    @Id @GeneratedValue
    private Long id_client;
    private String first_name;
    private String last_name;
    private String email;
}
