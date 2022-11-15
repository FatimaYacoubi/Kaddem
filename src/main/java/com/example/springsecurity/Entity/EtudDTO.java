package com.example.springsecurity.Entity;


import lombok.Data;

import java.util.Date;

@Data
public class EtudDTO {
    private String nom;
    private String prenom;
    private Contrat contrat;
    private Date dateDebutContrat;
    private Date dateFinContrat;
}
