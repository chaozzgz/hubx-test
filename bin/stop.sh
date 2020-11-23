#! /bin/bash

PID=`ps -ef | grep "admin-mgmt-service-[0-9].[0-9].[0-9].jar" | awk '{print $2}'`

if [ -z "$PID" ];then
	echo "not running process"
	exit
fi

kill -9  $PID