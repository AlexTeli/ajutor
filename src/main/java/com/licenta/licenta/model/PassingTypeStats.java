package com.licenta.licenta.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class PassingTypeStats extends BaseStats {
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
