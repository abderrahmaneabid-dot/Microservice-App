package com.abdo.mscomande.Model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private Long id_client;
    private String first_name;
    private String last_name;
    private String email;

    //
}
