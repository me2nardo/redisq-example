package org.github.me2nardo.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by leo on 20.12.16.
 */
public class Campaign implements Serializable {
    private Long id;
    private double longittude;
    private double lattitude;
    private int radius;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLongittude() {
        return longittude;
    }

    public void setLongittude(double longittude) {
        this.longittude = longittude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", longittude=" + longittude +
                ", lattitude=" + lattitude +
                ", radius=" + radius +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
