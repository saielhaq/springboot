package com.prosettings.prosettings.entities;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long playerId;
    private String playerName;
    private String nationality;
    private String team;
    private Double sens;
    private int dpi;

    @ManyToOne
    private Tier tier;

    public Player(){
        super();
    }

    public Player(Double sens, String team, String nationality, String playerName, int dpi) {
        super();
        this.sens = sens;
        this.team = team;
        this.nationality = nationality;
        this.playerName = playerName;
        this.dpi = dpi;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getSens() {
        return sens;
    }

    public void setSens(Double sens) {
        this.sens = sens;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", team='" + team + '\'' +
                ", sens=" + sens +
                ", dpi=" + dpi +
                ", tier=" + tier +
                '}';
    }
}
