package com.licenta.licenta.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class PassingStats extends BaseStats {
    private Integer cmp;
    private Integer att;

    @Column(name = "cmp_pct")
    private Double cmpPct;

    @Column(name = "tot_dist")
    private Integer totDist;

    @Column(name = "prg_dist")
    private Integer prgDist;

    private Integer cmpShort;
    private Integer attShort;

    @Column(name = "cmp_pct_short")  // Seems to be a typo in your CSV
    private Double cmpPctShort;

    private Integer cmpMedium;
    private Integer attMedium;
    private Double cmpPctMedium;

    private Integer cmpLong;
    private Integer attLong;
    private Double cmpPctLong;

    private Integer ast;
    private Double xag;
    private Double xa;
    private Integer kp;
    private Integer finalThird;
    private Integer ppa;
    private Integer crspa;
    private Integer prgp;
}
