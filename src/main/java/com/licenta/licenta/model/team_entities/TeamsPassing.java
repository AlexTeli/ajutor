package com.licenta.licenta.model.team_entities;

import com.licenta.licenta.model.BaseTeamStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teams_passing")
public class TeamsPassing extends BaseTeamStats {

    @Id
    private Integer rk;

    private Integer cmp;
    private Integer att;

    @Column(name = "cmp_pct")
    private Double cmpPct;

    @Column(name = "tot_dist")
    private Integer totDist;

    @Column(name = "prg_dist")
    private Integer prgDist;

    @Column(name = "cmp_short")
    private Integer cmpShort;

    @Column(name = "att_short")
    private Integer attShort;

    @Column(name = "cmp_pct_short")
    private Double cmpPctShort;

    @Column(name = "cmp_medium")
    private Integer cmpMedium;

    @Column(name = "att_medium")
    private Integer attMedium;

    @Column(name = "cmp_pct_medium")
    private Double cmpPctMedium;

    @Column(name = "cmp_long")
    private Integer cmpLong;

    @Column(name = "att_long")
    private Integer attLong;

    @Column(name = "cmp_pct_long")
    private Double cmpPctLong;

    private Integer ast;
    private Double xag;
    private Double xa;

    @Column(name = "a_minus_xag")
    private Double aMinusXag;

    private Integer kp;

    @Column(name = "final_third")
    private Integer finalThird;

    private Integer ppa;
    private Integer crspa;
    private Integer prgp;
}