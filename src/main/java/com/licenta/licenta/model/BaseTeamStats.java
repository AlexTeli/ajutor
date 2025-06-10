package com.licenta.licenta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseTeamStats {
    private String squad;

    @Column(name = "col_90s")
    private Double col90s;
}