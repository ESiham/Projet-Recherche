package fr.ifsttar.licit.simulator.agents;

/**
 * Agent Type
 * Should be extended by user including all application target agents requirements
 */
public enum AgentType {
    /**
     * Vehicle type has not been set.
     */
    NONE,
    /**
     * Vehicle is an immovable obstacle.
     */
    OBSTACLE,
    /**
     * Standard vehicle.
     */
    VEHICLE,
    /**
     * The vehicle is a floating car, used to gather data about traffic conditions.
     */
    FLOATING_CAR,
    /**
     * Road Side Unit
     */
    RSU
}