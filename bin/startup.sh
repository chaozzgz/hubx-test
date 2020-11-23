#!/bin/bash

#setup active profile

if [ $# -gt 0 ]; then
	echo "starting application with profile $1"
	PROFILE=$1
else
	echo "usage: startup.sh [profile: develop|staging|prod...]"
	exit
fi

CONFIG_FILE=$CORE_CONFIG_DIR/common-$PROFILE.yml

if [ ! -f "$CONFIG_FILE" ]; then
    echo "config file $CONFIG_FILE not exit"
    exit
fi

#assemble configuration

CONFIG="-Dspring.profiles.active=$PROFILE"

CONFIG=$CONFIG" -Dspring.config.location="
CONFIG=$CONFIG"file:$CORE_CONFIG_DIR/common.yml,"
CONFIG=$CONFIG"file:$CORE_CONFIG_DIR/common-$PROFILE.yml,"
CONFIG=$CONFIG"file:./application.yml,"
CONFIG=$CONFIG"file:./application-$PROFILE.yml"

echo "configuration: $CONFIG"

APP_NAME=`ls | grep admin-mgmt-service-[0-9].[0-9].[0-9].jar`

nohup java $CONFIG -jar $APP_NAME >/dev/null 2>&1 &

PID=$!

echo "pid: $PID"
echo $PID>app.pid