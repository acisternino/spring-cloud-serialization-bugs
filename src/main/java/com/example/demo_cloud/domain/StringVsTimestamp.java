package com.example.demo_cloud.domain;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * This class contains a few time- and date-related properties and can be used
 * to show the change in serialiazation format between Spring Cloud 4.1.2 and 4.1.3.
 * <br>
 * See <a href="https://github.com/spring-cloud/spring-cloud-stream/issues/2979">https://github.com/spring-cloud/spring-cloud-stream/issues/2979</a>.
 */
public class StringVsTimestamp {

    private String type;

    private Date date;

    private ZonedDateTime zonedDateTime;

    public StringVsTimestamp() {
        type = "StringVsTimestamp";
        date = new Date();
        zonedDateTime = ZonedDateTime.now();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    @Override
    public String toString() {
        return "StringVsTimestamp{type='" + type + "', date=" + date + ", zonedDateTime=" + zonedDateTime + '}';
    }
}
