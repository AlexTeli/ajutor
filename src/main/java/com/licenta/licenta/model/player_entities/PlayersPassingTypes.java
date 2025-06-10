package com.licenta.licenta.model.player_entities;

import com.licenta.licenta.model.PassingTypeStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players_passtype")
public class PlayersPassingTypes extends PassingTypeStats {

    @Id
    private Integer rk;  // Just mark this as @Id in Java

    @Column(name = "col_90s")  // Fixed: use the actual column name
    private Double col90s;

    private String nation;
    private Integer age;
    private Integer born;

    @Column(name = "Pos")
    private String pos;
}