package com.licenta.licenta.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class MiscStats extends BaseStats {
    private Integer crdy;
    private Integer crdr;
    private Integer doubleYellow;
    private Integer fls;
    private Integer fld;
    private Integer off;
    private Integer crs;
    private Integer interceptions;
    private Integer tklw;
    private Integer pkWon;
    private Integer pkConceded;
    private Integer ownGoals;
    private Integer recoveries;
    private Integer won;
    private Integer lost;

    private Double duelWinPct;
}
