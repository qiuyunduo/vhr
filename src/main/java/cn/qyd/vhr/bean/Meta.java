package cn.qyd.vhr.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiuyunduo
 * @date 2020/4/2 21:58
 * @descript the descript
 */
@Data
public class Meta implements Serializable {
    private Boolean keepAlive;

    private Boolean requireAuth;
}
