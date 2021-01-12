package cn.ylj.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : yanglujian
 * create at:  2021/1/12  3:54 下午
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {

    //Java对象 到 jdbc类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, date.getTime());
    }

    //jdbc类型 到 java对象
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long time = resultSet.getLong(s);
        Date date = new Date(time);
        return date;
    }

    //jdbc类型 到 java类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long time = resultSet.getLong(i);
        return new Date(time);
    }

    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new Date(callableStatement.getLong(i));
    }
}