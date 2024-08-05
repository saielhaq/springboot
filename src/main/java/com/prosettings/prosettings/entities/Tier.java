package com.prosettings.prosettings.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long tierId;
    private String tierName;
    private String tierDescription;

    @OneToMany (mappedBy = "tier")
    private List<Player> players;


}
