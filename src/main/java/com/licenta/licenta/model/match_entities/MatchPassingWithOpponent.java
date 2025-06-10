package com.licenta.licenta.model.match_entities;

import com.licenta.licenta.model.PassingStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "match_passing_with_opponent")
public class MatchPassingWithOpponent extends PassingStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_match")
    private Integer matchId;

    private String opponent;

    @Column(name = "venue")
    private String venue;
    private String result;

}
