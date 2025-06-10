package com.licenta.licenta.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class DefenseStats extends BaseStats {

    private Integer tkl;
    private Integer tklw;

    @Column(name = "def_3rd")
    private Integer defThird;

    @Column(name = "mid_3rd")
    private Integer midThird;

    @Column(name = "att_3rd")
    private Integer attThird;

    @Column(name = "tkl_vs_drib")
    private Integer tklVsDrib;

    @Column(name = "att_vs_drib")
    private Integer attVsDrib;

    @Column(name = "tkl_pct")
    private Double tklPct;

    private Integer lost;
    private Integer blocks;
    private Integer sh;

    @Column(name = "pass_block")
    private Integer passBlock;

    private Integer interceptions;

    @Column(name = "tkl_plus_int")
    private Integer tklPlusInt;

    private Integer clr;
    private Integer err;
}
