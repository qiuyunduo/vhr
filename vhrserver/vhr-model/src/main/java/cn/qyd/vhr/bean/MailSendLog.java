package cn.qyd.vhr.bean;

import java.io.Serializable;
import java.util.Date;

public class MailSendLog implements Serializable {
    private String msgid;

    private Integer empid;

    private Integer status;

    private String routekey;

    private String exchange;

    private Integer count;

    private Date trytime;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid == null ? null : msgid.trim();
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoutekey() {
        return routekey;
    }

    public void setRoutekey(String routekey) {
        this.routekey = routekey == null ? null : routekey.trim();
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getTrytime() {
        return trytime;
    }

    public void setTrytime(Date trytime) {
        this.trytime = trytime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgid=").append(msgid);
        sb.append(", empid=").append(empid);
        sb.append(", status=").append(status);
        sb.append(", routekey=").append(routekey);
        sb.append(", exchange=").append(exchange);
        sb.append(", count=").append(count);
        sb.append(", trytime=").append(trytime);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}