package cn.qyd.vhr.bean;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable {
    private Integer id;

    private Integer basicsalary;

    private Integer bonus;

    private Integer lunchsalary;

    private Integer trafficsalary;

    private Integer allsalary;

    private Integer pensionbase;

    private Float pensionper;

    private Date createdate;

    private Integer medicalbase;

    private Float medicalper;

    private Integer accumulationfundbase;

    private Float accumulationfundper;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Integer basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getLunchsalary() {
        return lunchsalary;
    }

    public void setLunchsalary(Integer lunchsalary) {
        this.lunchsalary = lunchsalary;
    }

    public Integer getTrafficsalary() {
        return trafficsalary;
    }

    public void setTrafficsalary(Integer trafficsalary) {
        this.trafficsalary = trafficsalary;
    }

    public Integer getAllsalary() {
        return allsalary;
    }

    public void setAllsalary(Integer allsalary) {
        this.allsalary = allsalary;
    }

    public Integer getPensionbase() {
        return pensionbase;
    }

    public void setPensionbase(Integer pensionbase) {
        this.pensionbase = pensionbase;
    }

    public Float getPensionper() {
        return pensionper;
    }

    public void setPensionper(Float pensionper) {
        this.pensionper = pensionper;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getMedicalbase() {
        return medicalbase;
    }

    public void setMedicalbase(Integer medicalbase) {
        this.medicalbase = medicalbase;
    }

    public Float getMedicalper() {
        return medicalper;
    }

    public void setMedicalper(Float medicalper) {
        this.medicalper = medicalper;
    }

    public Integer getAccumulationfundbase() {
        return accumulationfundbase;
    }

    public void setAccumulationfundbase(Integer accumulationfundbase) {
        this.accumulationfundbase = accumulationfundbase;
    }

    public Float getAccumulationfundper() {
        return accumulationfundper;
    }

    public void setAccumulationfundper(Float accumulationfundper) {
        this.accumulationfundper = accumulationfundper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", basicsalary=").append(basicsalary);
        sb.append(", bonus=").append(bonus);
        sb.append(", lunchsalary=").append(lunchsalary);
        sb.append(", trafficsalary=").append(trafficsalary);
        sb.append(", allsalary=").append(allsalary);
        sb.append(", pensionbase=").append(pensionbase);
        sb.append(", pensionper=").append(pensionper);
        sb.append(", createdate=").append(createdate);
        sb.append(", medicalbase=").append(medicalbase);
        sb.append(", medicalper=").append(medicalper);
        sb.append(", accumulationfundbase=").append(accumulationfundbase);
        sb.append(", accumulationfundper=").append(accumulationfundper);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}