package com.licenta.licenta.model;

public enum Role {
    USER,        // Can view stats and comparisons
    TEAM_MANAGER, // Manages one team, needs approval
    ADMIN        // Approves team managers
}