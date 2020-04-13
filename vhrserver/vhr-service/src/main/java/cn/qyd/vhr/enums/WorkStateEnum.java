package cn.qyd.vhr.enums;

/**
 * @author qiuyunduo
 * @date 2020/4/8 11:12
 * @descript the descript
 */
public enum  WorkStateEnum {
    WORKING("在职"),
    NOT_WORkING("离职");

    private String state;

    private WorkStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
