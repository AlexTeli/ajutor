package com.licenta.licenta.model.player_entities;

import com.licenta.licenta.model.BaseStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players_standard")
public class PlayersSummary extends BaseStats {

    @Id
    private Integer rk;

    private Integer age;
    private Integer born;
    private Integer mp;
    private Integer starts;

    @Column(name = "\"min\"")  // Quoted because min is reserved keyword
    private Integer min;

    @Column(name = "col_90s")
    private Double col90s;

    private Integer gls;
    private Integer ast;

    @Column(name = "g_plus_a")
    private Integer gPlusA;

    @Column(name = "g_minus_pk")
    private Integer gMinusPk;

    private Integer pk;
    private Integer pkatt;
    private Integer crdy;
    private Integer crdr;
    private Double xg;
    private Double npxg;
    private Double xag;

    @Column(name = "npxg_plus_xag")
    private Double npxgPlusXag;

    private Integer prgc;
    private Integer prgp;
    private Integer prgr;

    // Per 90 minutes stats (with _1 suffix)
    @Column(name = "gls_1")
    private Double gls1;

    @Column(name = "ast_1")
    private Double ast1;

    @Column(name = "g_plus_a_1")
    private Double gPlusA1;

    @Column(name = "g_minus_pk_1")
    private Double gMinusPk1;

    @Column(name = "g_plus_a_minus_pk")
    private Double gPlusAMinusPk;

    @Column(name = "xg_1")
    private Double xg1;

    @Column(name = "npxg_1")
    private Double npxg1;

    @Column(name = "xag_1")
    private Double xag1;

    @Column(name = "npxg_plus_xag_1")
    private Double npxgPlusXag1;

    @Column(name = "xg_plus_xag")
    private Double xgPlusXag;

    private String nation;

    @Column(name = "pos")
    private String pos;
}