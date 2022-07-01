package com.renguangli.influxdb;

import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * influxdb-samples
 *
 * @author renguangli
 * @date 2022/6/27 10:41
 */
public class InfluxdbWriteSamples {

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(10);
    private static final int batchSize = 100000;

    public static void main(String[] args) {
        InfluxDB influxDB = InfluxDBFactory.connect("http://172.16.22.233:8086");
        influxDB.setDatabase("iot_point");
        influxDB.setConsistency(InfluxDB.ConsistencyLevel.ALL);

        CsvData csvData = CsvUtil.getReader().read(new File("data/011011011100100SVGZL.csv"));

        int i = 0;
        List<String> records = new ArrayList<>(batchSize);
        long totalStart = System.currentTimeMillis();
        for (CsvRow csvRow : csvData) {
            // 第一条跳过
            if (i++ == 0) { continue; }
            // 请求体拼接
            String requestData = csvRow.get(0) + ",code=" + csvRow.get(2) + " " +
                    "value=" + csvRow.get(3) + " " +
                    toTimestamp(csvRow);
            records.add(requestData);
            if (records.size() == batchSize) {
                long l = System.currentTimeMillis();
                influxDB.write(records);
                System.out.println(System.currentTimeMillis() - l);
                records = new ArrayList<>(batchSize);
            }
        }

        // 不足 batchSize
        long l = System.currentTimeMillis();
        influxDB.write(records);
        System.out.println(System.currentTimeMillis() - l);

        System.out.println("总共花费：" + (System.currentTimeMillis() - totalStart));
    }

    public static long toTimestamp(CsvRow csvRow) {
        String timeStr = csvRow.get(1).substring(0, 19).replace("T", " ");
        LocalDateTime datetime = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return datetime.toInstant(ZoneOffset.of("+8")).getEpochSecond() * 1000;
    }

}
