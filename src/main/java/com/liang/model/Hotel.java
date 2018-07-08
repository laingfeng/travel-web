package com.liang.model;

import java.io.Serializable;

public class Hotel implements Serializable {
    private String hotelnum;

    private String hotelname;

    private String hotelcity;

    private String hotelstar;

    private Integer hotelprice;

    private Integer hotelnumrooms;

    private Integer hotelnumavail;

    private String hotelconnectway;

    private String hotelphone;

    private static final long serialVersionUID = 1L;

    public String getHotelnum() {
        return hotelnum;
    }

    public void setHotelnum(String hotelnum) {
        this.hotelnum = hotelnum == null ? null : hotelnum.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public String getHotelcity() {
        return hotelcity;
    }

    public void setHotelcity(String hotelcity) {
        this.hotelcity = hotelcity == null ? null : hotelcity.trim();
    }

    public String getHotelstar() {
        return hotelstar;
    }

    public void setHotelstar(String hotelstar) {
        this.hotelstar = hotelstar == null ? null : hotelstar.trim();
    }

    public Integer getHotelprice() {
        return hotelprice;
    }

    public void setHotelprice(Integer hotelprice) {
        this.hotelprice = hotelprice;
    }

    public Integer getHotelnumrooms() {
        return hotelnumrooms;
    }

    public void setHotelnumrooms(Integer hotelnumrooms) {
        this.hotelnumrooms = hotelnumrooms;
    }

    public Integer getHotelnumavail() {
        return hotelnumavail;
    }

    public void setHotelnumavail(Integer hotelnumavail) {
        this.hotelnumavail = hotelnumavail;
    }

    public String getHotelconnectway() {
        return hotelconnectway;
    }

    public void setHotelconnectway(String hotelconnectway) {
        this.hotelconnectway = hotelconnectway == null ? null : hotelconnectway.trim();
    }

    public String getHotelphone() {
        return hotelphone;
    }

    public void setHotelphone(String hotelphone) {
        this.hotelphone = hotelphone == null ? null : hotelphone.trim();
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
        Hotel other = (Hotel) that;
        return (this.getHotelnum() == null ? other.getHotelnum() == null : this.getHotelnum().equals(other.getHotelnum()))
            && (this.getHotelname() == null ? other.getHotelname() == null : this.getHotelname().equals(other.getHotelname()))
            && (this.getHotelcity() == null ? other.getHotelcity() == null : this.getHotelcity().equals(other.getHotelcity()))
            && (this.getHotelstar() == null ? other.getHotelstar() == null : this.getHotelstar().equals(other.getHotelstar()))
            && (this.getHotelprice() == null ? other.getHotelprice() == null : this.getHotelprice().equals(other.getHotelprice()))
            && (this.getHotelnumrooms() == null ? other.getHotelnumrooms() == null : this.getHotelnumrooms().equals(other.getHotelnumrooms()))
            && (this.getHotelnumavail() == null ? other.getHotelnumavail() == null : this.getHotelnumavail().equals(other.getHotelnumavail()))
            && (this.getHotelconnectway() == null ? other.getHotelconnectway() == null : this.getHotelconnectway().equals(other.getHotelconnectway()))
            && (this.getHotelphone() == null ? other.getHotelphone() == null : this.getHotelphone().equals(other.getHotelphone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHotelnum() == null) ? 0 : getHotelnum().hashCode());
        result = prime * result + ((getHotelname() == null) ? 0 : getHotelname().hashCode());
        result = prime * result + ((getHotelcity() == null) ? 0 : getHotelcity().hashCode());
        result = prime * result + ((getHotelstar() == null) ? 0 : getHotelstar().hashCode());
        result = prime * result + ((getHotelprice() == null) ? 0 : getHotelprice().hashCode());
        result = prime * result + ((getHotelnumrooms() == null) ? 0 : getHotelnumrooms().hashCode());
        result = prime * result + ((getHotelnumavail() == null) ? 0 : getHotelnumavail().hashCode());
        result = prime * result + ((getHotelconnectway() == null) ? 0 : getHotelconnectway().hashCode());
        result = prime * result + ((getHotelphone() == null) ? 0 : getHotelphone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hotelnum=").append(hotelnum);
        sb.append(", hotelname=").append(hotelname);
        sb.append(", hotelcity=").append(hotelcity);
        sb.append(", hotelstar=").append(hotelstar);
        sb.append(", hotelprice=").append(hotelprice);
        sb.append(", hotelnumrooms=").append(hotelnumrooms);
        sb.append(", hotelnumavail=").append(hotelnumavail);
        sb.append(", hotelconnectway=").append(hotelconnectway);
        sb.append(", hotelphone=").append(hotelphone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}