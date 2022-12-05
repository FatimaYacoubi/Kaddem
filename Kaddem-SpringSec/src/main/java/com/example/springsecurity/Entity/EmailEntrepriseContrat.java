package com.example.springsecurity.Entity;
// Importing required classes

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Annotations
@Entity
@Table( name ="EmailEntrepriseContrat")
@Getter
@Setter
public class EmailEntrepriseContrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
