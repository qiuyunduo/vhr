package cn.qyd.vhr.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Menu implements Serializable {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Meta meta;

    private List<Menu> children;

    private Integer parentId;

    private Boolean enabled;

    private List<Role> roles;

    private static final long serialVersionUID = 1L;


}