package com.licenta.licenta.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class PossessionStats extends BaseStats{


    private Integer touches;
    @Column(name = "def_pen")
    private Integer defPen;

    @Column(name = "def_3rd")
    private Integer defThird;

    @Column(name = "mid_3rd")
    private Integer midThird;

    @Column(name = "att_3rd")
    private Integer attThird;

    @Column(name = "att_pen")
    private Integer attPen;

    private Integer live;

    @Column(name = "att_takeon")
    private Integer attTakeon;

    @Column(name = "succ_takeon")
    private Integer succTakeon;

    @Column(name = "succ_pct")
    private Double succPct;

    private Integer tkld;

    @Column(name = "tkld_pct")
    private Double tkldPct;

    private Integer carries;

    @Column(name = "tot_dist")
    private Integer totDist;

    @Column(name = "prg_dist")
    private Integer prgDist;

    private Integer prgc;

    @Column(name = "final_3rd")
    private Integer finalThird;

    private Integer cpa;
    private Integer mis;
    private Integer dis;
    private Integer rec;
    private Integer prgr;

}
