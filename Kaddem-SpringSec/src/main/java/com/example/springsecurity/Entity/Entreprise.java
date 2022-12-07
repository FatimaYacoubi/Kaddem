package com.example.springsecurity.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;
@Entity
@Table( name ="Entreprise")
@Getter
@Setter
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEntreprise")
    private Integer idEntreprise; // Clé primaire
    private String nomEntreprise;
    private String locEntreprise;
    @Column(nullable=true)
    private float latitude=1;
    @Column(nullable=true)
    private float longitude=1;
    private Integer nbPlaceRest;
    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "EntrepriseContrat")
    private List<Contrat> ListContrats;
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    public int getdistance(float longitude, float latitude)
    { System.out.println(latitude);
        System.out.println(longitude);
        double latDistance = Math.toRadians(latitude - 36.24255502127699);
        double lngDistance = Math.toRadians(longitude - 9.476723745103257);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians( 36.24255502127699))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }

    private int distance = getdistance(longitude,latitude);

}