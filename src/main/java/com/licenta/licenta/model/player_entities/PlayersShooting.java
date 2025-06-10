package com.licenta.licenta.model.player_entities;

import com.licenta.licenta.model.BaseStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players_shooting")
public class PlayersShooting extends BaseStats {

    @Id
    private Integer rk;

    private Integer age;
    private Integer born;

    @Column(name = "col_90s")
    private Double col90s;

    private Integer gls;
    private Integer sh;
    private Integer sot;

    @Column(name = "sot_pct")
    private Double sotPct;

    @Column(name = "sh_per_90")
    private Double shPer90;

    @Column(name = "sot_per_90")
    private Double sotPer90;

    @Column(name = "g_per_sh")
    private Double gPerSh;

    @Column(name = "g_per_sot")
    private Double gPerSot;

    @Column(name = "avg_dist")
    private Double avgDist;

    @Column(name = "fk_goals")
    private Integer fkGoals;

    private Integer pk;
    private Integer pkatt;
    private Double xg;
    private Double npxg;

    @Column(name = "npxg_per_sh")
    private Double npxgPerSh;

    @Column(name = "g_minus_xg")
    private Double gMinusXg;

    @Column(name = "npg_minus_xg")
    private Double npgMinusXg;

    private String nation;

    @Column(name = "pos")
    private String pos;
}
