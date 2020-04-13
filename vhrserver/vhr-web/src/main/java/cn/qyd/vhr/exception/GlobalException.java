package cn.qyd.vhr.exception;

import cn.qyd.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author qiuyunduo
 * @date 2020/4/4 14:51
 * @descript the descript
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if(e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据,操作失败");
        }

        return RespBean.error("数据库异常,操作失败");
    }
}
