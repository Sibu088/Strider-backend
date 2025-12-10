package com.example.striderbackend.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private double distanceKm;
    private int durationMinutes;
    private LocalDate date;

    public Activity() {}

    public Activity(UUID id, String title, String description, double distanceKm, int durationMinutes, LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.distanceKm = distanceKm;
        this.durationMinutes = durationMinutes;
        this.date = date;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }
    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
