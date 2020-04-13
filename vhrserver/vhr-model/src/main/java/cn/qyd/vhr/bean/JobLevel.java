package cn.qyd.vhr.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class JobLevel implements Serializable {
    private Integer id;

    private String name;

    private String titleLevel;

    private Date createDate;

    private Boolean enabled;

    public JobLevel() {

    }

    public JobLevel(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobLevel jobLevel = (JobLevel) o;
        return Objects.equals(name, jobLevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private static final long serialVersionUID = 1L;
}