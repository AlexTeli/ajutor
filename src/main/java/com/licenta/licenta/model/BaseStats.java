package com.licenta.licenta.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class BaseStats {

    private String player;
    private String squad;


}
