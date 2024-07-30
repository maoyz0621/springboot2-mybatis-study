/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus35.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author maoyz0621 on 2024/5/28
 * @version v1.0
 */
@MappedJdbcTypes(value = {JdbcType.DECIMAL, JdbcType.NUMERIC})
@MappedTypes({String.class, Object.class})
public class CustomBigDecimalTypeHandler extends BaseTypeHandler<Object> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return dealResult(rs.getObject(columnName));
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return dealResult(rs.getObject(columnIndex));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return dealResult(cs.getObject(columnIndex));
    }

    /**
     * 处理结果，去除小数位的0
     *
     * @param result jdbc返回值
     * @return 去除小数位0
     */
    private Object dealResult(Object result) {
        if (result == null) {
            return null;
        }
        if (result instanceof BigDecimal) {
            return ((BigDecimal) result).stripTrailingZeros().toPlainString();
        }
        return result.toString();
    }
}