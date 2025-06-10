package com.licenta.licenta.model.team_entities;

import com.licenta.licenta.model.BaseTeamStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "teams_misc")
public class TeamsMisc extends BaseTeamStats {

    @Id
    private Integer rk;

    private Integer crdy;
    private Integer crdr;

    @Column(name = "double_yellow")
    private Integer doubleYellow;

    private Integer fls;
    private Integer fld;
    private Integer off;
    private Integer crs;
    private Integer interceptions;
    private Integer tklw;

    @Column(name = "pk_won")
    private Integer pkWon;

    @Column(name = "pk_conceded")
    private Integer pkConceded;

    @Column(name = "own_goals")
    private Integer ownGoals;

    private Integer recoveries;
    private Integer won;
    private Integer lost;

    @Column(name = "duel_win_pct")
    private Double duelWinPct;
}