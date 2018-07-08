package com.liang.model;

import java.io.Serializable;

public class Reservation implements Serializable {
    private Integer reservatid;

    private Integer rUserid;

    private String rUsername;

    private String restype;

    private String associateid;

    private String resstatus;

    private static final long serialVersionUID = 1L;

    public Integer getReservatid() {
        return reservatid;
    }

    public void setReservatid(Integer reservatid) {
        this.reservatid = reservatid;
    }

    public Integer getrUserid() {
        return rUserid;
    }

    public void setrUserid(Integer rUserid) {
        this.rUserid = rUserid;
    }

    public String getrUsername() {
        return rUsername;
    }

    public void setrUsername(String rUsername) {
        this.rUsername = rUsername == null ? null : rUsername.trim();
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype == null ? null : restype.trim();
    }

    public String getAssociateid() {
        return associateid;
    }

    public void setAssociateid(String associateid) {
        this.associateid = associateid == null ? null : associateid.trim();
    }

    public String getResstatus() {
        return resstatus;
    }

    public void setResstatus(String resstatus) {
        this.resstatus = resstatus == null ? null : resstatus.trim();
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
        Reservation other = (Reservation) that;
        return (this.getReservatid() == null ? other.getReservatid() == null : this.getReservatid().equals(other.getReservatid()))
            && (this.getrUserid() == null ? other.getrUserid() == null : this.getrUserid().equals(other.getrUserid()))
            && (this.getrUsername() == null ? other.getrUsername() == null : this.getrUsername().equals(other.getrUsername()))
            && (this.getRestype() == null ? other.getRestype() == null : this.getRestype().equals(other.getRestype()))
            && (this.getAssociateid() == null ? other.getAssociateid() == null : this.getAssociateid().equals(other.getAssociateid()))
            && (this.getResstatus() == null ? other.getResstatus() == null : this.getResstatus().equals(other.getResstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReservatid() == null) ? 0 : getReservatid().hashCode());
        result = prime * result + ((getrUserid() == null) ? 0 : getrUserid().hashCode());
        result = prime * result + ((getrUsername() == null) ? 0 : getrUsername().hashCode());
        result = prime * result + ((getRestype() == null) ? 0 : getRestype().hashCode());
        result = prime * result + ((getAssociateid() == null) ? 0 : getAssociateid().hashCode());
        result = prime * result + ((getResstatus() == null) ? 0 : getResstatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reservatid=").append(reservatid);
        sb.append(", rUserid=").append(rUserid);
        sb.append(", rUsername=").append(rUsername);
        sb.append(", restype=").append(restype);
        sb.append(", associateid=").append(associateid);
        sb.append(", resstatus=").append(resstatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}