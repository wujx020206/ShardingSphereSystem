package com.shardingjdbc.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * 年月分表策略
 */
@Slf4j
public class AttendanceShardingTableAlgorithm implements PreciseShardingAlgorithm<Date> {

    @Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<Date> shardingValue) {
        Date accessDate = shardingValue.getValue();

        Calendar cal = Calendar.getInstance();
        cal.setTime(accessDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;

        // 构建真实表表名
        String tableName = shardingValue.getLogicTableName() + year + String.format("%02d", month);
        if (tableNames.contains(tableName)) {
            return tableName;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
