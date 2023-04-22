package com.amrut.prabhu;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Data")
public class Data {

    @Id()
    @GeneratedValue
    private Long id;

    private BigDecimal value;
    private BigDecimal cumulative;

    private LocalDate date;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getCumulative() {
        return cumulative;
    }

    public void setCumulative(BigDecimal cumulative) {
        this.cumulative = cumulative;
    }
}
