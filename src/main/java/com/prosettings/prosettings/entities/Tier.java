package com.prosettings.prosettings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long tierId;
    private String tierName;
    private String tierDescription;

    @OneToMany (mappedBy = "tier")
    @JsonIgnore
    private List<Player> players;

    public Tier(){
        super();
    }

    public Tier(String tierName, String tierDescription, List<Player> players) {
        this.tierName = tierName;
        this.tierDescription = tierDescription;
        this.players = players;
    }

    public Long getTierId() {
        return tierId;
    }

    public void setTierId(Long tierId) {
        this.tierId = tierId;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public String getTierDescription() {
        return tierDescription;
    }

    public void setTierDescription(String tierDescription) {
        this.tierDescription = tierDescription;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
