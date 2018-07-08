package com.liang.model;

import java.io.Serializable;

public class Transfor implements Serializable {
    private String carnum;

    private String cartype;

    private String carfrom;

    private String carto;

    private Integer carprice;

    private Integer carnumavail;

    private static final long serialVersionUID = 1L;

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getCarfrom() {
        return carfrom;
    }

    public void setCarfrom(String carfrom) {
        this.carfrom = carfrom == null ? null : carfrom.trim();
    }

    public String getCarto() {
        return carto;
    }

    public void setCarto(String carto) {
        this.carto = carto == null ? null : carto.trim();
    }

    public Integer getCarprice() {
        return carprice;
    }

    public void setCarprice(Integer carprice) {
        this.carprice = carprice;
    }

    public Integer getCarnumavail() {
        return carnumavail;
    }

    public void setCarnumavail(Integer carnumavail) {
        this.carnumavail = carnumavail;
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
        Transfor other = (Transfor) that;
        return (this.getCarnum() == null ? other.getCarnum() == null : this.getCarnum().equals(other.getCarnum()))
            && (this.getCartype() == null ? other.getCartype() == null : this.getCartype().equals(other.getCartype()))
            && (this.getCarfrom() == null ? other.getCarfrom() == null : this.getCarfrom().equals(other.getCarfrom()))
            && (this.getCarto() == null ? other.getCarto() == null : this.getCarto().equals(other.getCarto()))
            && (this.getCarprice() == null ? other.getCarprice() == null : this.getCarprice().equals(other.getCarprice()))
            && (this.getCarnumavail() == null ? other.getCarnumavail() == null : this.getCarnumavail().equals(other.getCarnumavail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarnum() == null) ? 0 : getCarnum().hashCode());
        result = prime * result + ((getCartype() == null) ? 0 : getCartype().hashCode());
        result = prime * result + ((getCarfrom() == null) ? 0 : getCarfrom().hashCode());
        result = prime * result + ((getCarto() == null) ? 0 : getCarto().hashCode());
        result = prime * result + ((getCarprice() == null) ? 0 : getCarprice().hashCode());
        result = prime * result + ((getCarnumavail() == null) ? 0 : getCarnumavail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carnum=").append(carnum);
        sb.append(", cartype=").append(cartype);
        sb.append(", carfrom=").append(carfrom);
        sb.append(", carto=").append(carto);
        sb.append(", carprice=").append(carprice);
        sb.append(", carnumavail=").append(carnumavail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}