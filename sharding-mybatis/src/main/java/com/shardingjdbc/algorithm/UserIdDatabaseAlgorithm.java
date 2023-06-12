package com.shardingjdbc.algorithm;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 根据userId分库策略
 */
@Slf4j
public class UserIdDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<Integer> shardingValue) {
        for (Pair<String, Integer> each : nameToSuffixPair(databaseNames)) {
            if (each.getValue() == shardingValue.getValue() % databaseNames.size()) {
                return each.getKey();
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * 数据库名/表名 String集合转换Pair集合，key=String，value=后缀数字
     */
    public static Collection<Pair<String, Integer>> nameToSuffixPair(Collection<String> target) {
        return target.stream().map(e -> new Pair<>(e, Integer.parseInt(e.substring(e.lastIndexOf("_") + 1)))).collect(Collectors.toList());
    }
}
