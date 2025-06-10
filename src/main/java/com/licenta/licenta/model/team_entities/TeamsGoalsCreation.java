package com.licenta.licenta.model.team_entities;

import com.licenta.licenta.model.BaseTeamStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teams_goals_creation")
public class TeamsGoalsCreation extends BaseTeamStats {

    @Id
    private Integer rk;

    private Integer sca;
    private Double sca90;

    @Column(name = "sca_pass_live")
    private Integer scaPassLive;

    @Column(name = "sca_pass_dead")
    private Integer scaPassDead;

    @Column(name = "sca_to")
    private Integer scaTo;

    @Column(name = "sca_sh")
    private Integer scaSh;

    @Column(name = "sca_fld")
    private Integer scaFld;

    @Column(name = "sca_def")
    private Integer scaDef;

    private Integer gca;
    private Double gca90;

    @Column(name = "gca_pass_live")
    private Integer gcaPassLive;

    @Column(name = "gca_pass_dead")
    private Integer gcaPassDead;

    @Column(name = "gca_to")
    private Integer gcaTo;

    @Column(name = "gca_sh")
    private Integer gcaSh;

    @Column(name = "gca_fld")
    private Integer gcaFld;

    @Column(name = "gca_def")
    private Integer gcaDef;
}