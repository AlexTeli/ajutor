package com.licenta.licenta.model.team_entities;

import com.licenta.licenta.model.BaseTeamStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "teams_passtype")
public class TeamsPassType extends BaseTeamStats {

    @Id
    private Integer rk;

    private Integer att;
    private Integer live;
    private Integer dead;
    private Integer fk;
    private Integer tb;
    private Integer sw;
    private Integer crs;
    private Integer ti;
    private Integer ck;

    @Column(name = "in_pass")
    private Integer inPass;

    @Column(name = "out_pass")
    private Integer outPass;

    @Column(name = "str_pass")
    private Integer strPass;

    private Integer cmp;
    private Integer off;
    private Integer blocks;
}