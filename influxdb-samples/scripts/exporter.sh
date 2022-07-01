#!/bin/sh
# 注意换行符 dos2unix codes.txt
codes=`cat codes.txt`
dir=fj104
host=127.0.0.1
port=8086
username=cloudiip
password=cloudiip@1234
# json|csv|column
format=csv
# rfc3339|h|m|s|ms|u|ns
precision=rfc3339
database=iot_point
table=iot_tenant_system
start='2022-01-01 00:00:00'
end='2022-01-02 00:00:00'
for code in $codes
do
influxSQL="select time,code,value from $table where code ='$code' and time >= '$start' and time <= '$end' tz('Asia/Shanghai') "
echo "Executing influxSQL: $influxSQL"
s1=`date +%s`
influx -host $host -port $port -username $username -password $password -format $format -precision $precision -database $database -execute "$influxSQL" > $dir/${code}.csv
s2=`date +%s`
s=s2-s1
echo "Finished. cost time: $s2 s"
done