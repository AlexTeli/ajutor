package com.licenta.licenta.model.player_entities;

import com.licenta.licenta.model.BaseStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players_time")
public class PlayersTime extends BaseStats {

    @Id
    private Integer rk;

    private Integer age;
    private Integer born;
    private Integer mp;

    @Column(name = "\"min\"")  // Quoted because min is reserved keyword
    private Integer min;

    @Column(name = "min_per_mp")
    private Double minPerMp;

    @Column(name = "min_pct")
    private Double minPct;

    @Column(name = "col_90s")
    private Double col90s;

    private Integer starts;

    @Column(name = "min_per_start")
    private Double minPerStart;

    private Integer compl;
    private Integer subs;

    @Column(name = "min_per_sub")
    private Double minPerSub;

    private Integer unsub;
    private Double ppm;

    @Column(name = "on_g")
    private Integer onG;

    @Column(name = "on_ga")
    private Integer onGa;

    @Column(name = "plus_minus")
    private Integer plusMinus;

    @Column(name = "plus_minus_90")
    private Double plusMinus90;

    @Column(name = "on_off")
    private Double onOff;

    @Column(name = "on_xg")
    private Double onXg;

    @Column(name = "on_xga")
    private Double onXga;

    @Column(name = "xg_plus_minus")
    private Double xgPlusMinus;

    @Column(name = "xg_plus_minus_90")
    private Double xgPlusMinus90;

    @Column(name = "xg_on_off")
    private Double xgOnOff;

    private String nation;

    @Column(name = "pos")
    private String pos;
}