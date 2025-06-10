package com.licenta.licenta.model.player_entities;

import com.licenta.licenta.model.PassingStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players_passing")
public class PlayersPassing extends PassingStats {

    @Id
    private Integer rk;

    @Column(name = "col_90s")  // Fixed: use the actual column name
    private Double col90s;

    private String nation;
    private Integer age;
    private Integer born;

    @Column(name = "Pos")
    private String pos;
}