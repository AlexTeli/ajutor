package com.licenta.licenta.model.match_entities;

import com.licenta.licenta.model.MiscStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "match_misc_with_opponent")
public class MatchMiscWithOpponent extends MiscStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // PRIMARY KEY, you need to add this column in your DB too

    @Column(name = "id_match")
    private Integer matchId;

    private String opponent;

    @Column(name = "venue")
    private String venue;
    private String result;

}
