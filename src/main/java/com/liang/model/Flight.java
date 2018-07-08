package com.liang.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {
    private String flightnum;

    private Integer flightprice;

    private Integer numseats;

    private Integer flightnumavail;

   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date flydate;

    private String flyfromcity;

    private String flytocity;

    private static final long serialVersionUID = 1L;

    public String getFlightnum() {
        return flightnum;
    }

    public void setFlightnum(String flightnum) {
        this.flightnum = flightnum == null ? null : flightnum.trim();
    }

    public Integer getFlightprice() {
        return flightprice;
    }

    public void setFlightprice(Integer flightprice) {
        this.flightprice = flightprice;
    }

    public Integer getNumseats() {
        return numseats;
    }

    public void setNumseats(Integer numseats) {
        this.numseats = numseats;
    }

    public Integer getFlightnumavail() {
        return flightnumavail;
    }

    public void setFlightnumavail(Integer flightnumavail) {
        this.flightnumavail = flightnumavail;
    }

    public Date getFlydate() {
        return flydate;
    }

    public void setFlydate(Date flydate) {
        this.flydate = flydate;
    }

    public String getFlyfromcity() {
        return flyfromcity;
    }

    public void setFlyfromcity(String flyfromcity) {
        this.flyfromcity = flyfromcity == null ? null : flyfromcity.trim();
    }

    public String getFlytocity() {
        return flytocity;
    }

    public void setFlytocity(String flytocity) {
        this.flytocity = flytocity == null ? null : flytocity.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Flight other = (Flight) that;
        return (this.getFlightnum() == null ? other.getFlightnum() == null : this.getFlightnum().equals(other.getFlightnum()))
            && (this.getFlightprice() == null ? other.getFlightprice() == null : this.getFlightprice().equals(other.getFlightprice()))
            && (this.getNumseats() == null ? other.getNumseats() == null : this.getNumseats().equals(other.getNumseats()))
            && (this.getFlightnumavail() == null ? other.getFlightnumavail() == null : this.getFlightnumavail().equals(other.getFlightnumavail()))
            && (this.getFlydate() == null ? other.getFlydate() == null : this.getFlydate().equals(other.getFlydate()))
            && (this.getFlyfromcity() == null ? other.getFlyfromcity() == null : this.getFlyfromcity().equals(other.getFlyfromcity()))
            && (this.getFlytocity() == null ? other.getFlytocity() == null : this.getFlytocity().equals(other.getFlytocity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlightnum() == null) ? 0 : getFlightnum().hashCode());
        result = prime * result + ((getFlightprice() == null) ? 0 : getFlightprice().hashCode());
        result = prime * result + ((getNumseats() == null) ? 0 : getNumseats().hashCode());
        result = prime * result + ((getFlightnumavail() == null) ? 0 : getFlightnumavail().hashCode());
        result = prime * result + ((getFlydate() == null) ? 0 : getFlydate().hashCode());
        result = prime * result + ((getFlyfromcity() == null) ? 0 : getFlyfromcity().hashCode());
        result = prime * result + ((getFlytocity() == null) ? 0 : getFlytocity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", flightnum=").append(flightnum);
        sb.append(", flightprice=").append(flightprice);
        sb.append(", numseats=").append(numseats);
        sb.append(", flightnumavail=").append(flightnumavail);
        sb.append(", flydate=").append(flydate);
        sb.append(", flyfromcity=").append(flyfromcity);
        sb.append(", flytocity=").append(flytocity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}