package com.licenta.licenta.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class SummaryStats extends BaseStats {
    private Integer gls;
    private Integer ast;
    private Integer pk;
    private Integer pkatt;
    private Integer sh;
    private Integer sot;
    private Integer crdy;
    private Integer crdr;
    private Integer touches;
    private Integer tkl;
    private Integer interceptions;
    private Integer blocks;
    private Double xg;
    private Double npxg;
    private Double xag;
    private Integer sca;
    private Integer gca;
    private Integer cmp;
    private Integer att;
    private Double cmpPct;
    private Integer prgp;
    private Integer carries;
    private Integer prgc;
    private Integer attTakeon;
    private Integer succTakeon;
}
