package com.example.demo_cloud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * This class simply a few time- and date-related properties and can be used
 * to show that a {@code @JsonFormat}-annotated {@code Instant} class
 * throws an exception when sent to an output destination.
 * <br>
 * See <a href="https://github.com/spring-cloud/spring-cloud-stream/issues/2980">https://github.com/spring-cloud/spring-cloud-stream/issues/2980</a>.
 */
public class AnnotatedInstantThrows {

    private String type;

    // This throws; comment the annotation and check without it
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Instant instant;

    // This works
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime zonedDateTime;

    public AnnotatedInstantThrows() {
        type = "AnnotatedInstantThrows";
        instant = Instant.now();
        zonedDateTime = ZonedDateTime.now(); // uses the default timezone
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    @Override
    public String toString() {
        return "AnnotatedInstantThrows{type='" + type + "', instant=" + instant + ", zonedDateTime=" + zonedDateTime
                + '}';
    }
}
