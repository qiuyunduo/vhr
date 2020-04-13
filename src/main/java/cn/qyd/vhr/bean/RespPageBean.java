package cn.qyd.vhr.bean;

import lombok.Data;

import java.util.List;

/**
 * @author qiuyunduo
 * @date 2020/4/7 13:07
 * @descript the descript
 */
@Data
public class RespPageBean {
    private Long total;
    private List<?> objects;

    public RespPageBean() {

    }

    public RespPageBean(Long total, List<?> objects) {
        this.total = total;
        this.objects = objects;
    }
}
