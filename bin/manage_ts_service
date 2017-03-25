#!/bin/sh

#----------------------------------------------------------
# DEFINE SCRIPT PARAMTERS
#----------------------------------------------------------
HOSTNAME=`hostname`

SCRIPT_BIN_DIR=$(dirname $0)
cd $SCRIPT_BIN_DIR
SCRIPT_BIN_DIR=`pwd`

cd $SCRIPT_BIN_DIR/../service-data/config
CONFIG_BASE=`pwd`

cd $SCRIPT_BIN_DIR/../service-data/pid
PID_BASE=`pwd`

cd $SCRIPT_BIN_DIR/../service-data/logs
LOG_BASE=`pwd`
ERROR_LOG_FILE=$LOG_BASE/error_log.txt

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.101-3.b13.24.amzn1.x86_64
VM_ARGUMENTS=" "
PROGRAM_ARGUMENTS="com.techstomach.ehs.service.MainService server $CONFIG_BASE/main.yml"

for i in `ls $SCRIPT_BIN_DIR/../lib/*.jar`
do
   CLASSPATH=$CLASSPATH:$i;
done
CLASSPATH=$CLASSPATH:$SCRIPT_BIN_DIR/../classes

#----------------------------------------------------------
# DEFINE SCRIPT PARAMTERS
#----------------------------------------------------------
. /etc/rc.d/init.d/functions

message() {
    if test "x$DEBUG" == "xyes" ; then
        echo $1
    fi
}


start() {
    message "SCRIPT_BIN_DIR=$SCRIPT_BIN_DIR"
    message "HOSTNAME=$HOSTNAME"
    message "CONFIG_BASE=$CONFIG_BASE"
    message "PID_BASE=$PID_BASE"
    message "ERROR_LOG_FILE=$ERROR_LOG_FILE"
    message "CLASSPATH=$CLASSPATH"
    message "JAVA_HOME=$JAVA_HOME"
    message "VM_ARGUMENTS=$VM_ARGUMENTS"
    message "PROGRAM_ARGUMENTS=$PROGRAM_ARGUMENTS"

    SERVICE_PID=`ps -ef |grep   java | grep -v grep | grep AppStarterVerticle | awk '{print $2;}'`
    if [ -n "$SERVICE_PID" ]; then
      echo "ERROR: the service is already running with pid = $SERVICE_PID"
      exit 1
    fi

    nohup $JAVA_HOME/bin/java $VM_ARGUMENTS -cp $CLASSPATH $PROGRAM_ARGUMENTS > /dev/null 2>>$ERROR_LOG_FILE </dev/null &
    SERVICE_PID=`ps -ef |grep   java | grep -v grep | grep MainService | awk '{print $2;}'`
    if [ -n "$SERVICE_PID" ]; then
      echo "the service is started with pid = $SERVICE_PID"
      echo $SERVICE_PID>$PID_BASE/pid.txt
    else
      echo "ERROR: service is not running"
    fi
}

stop() {
    message "SCRIPT_BIN_DIR=$SCRIPT_BIN_DIR"
    message "HOSTNAME=$HOSTNAME"
    message "CONFIG_BASE=$CONFIG_BASE"
    message "PID_BASE=$PID_BASE"
    message "ERROR_LOG_FILE=$ERROR_LOG_FILE"
    message "CLASSPATH=$CLASSPATH"
    message "JAVA_HOME=$JAVA_HOME"
    message "VM_ARGUMENTS=$VM_ARGUMENTS"
    message "PROGRAM_ARGUMENTS=$PROGRAM_ARGUMENTS"

    SERVICE_PID=`ps -ef |grep   java | grep -v grep | grep MainService | awk '{print $2;}'`
    if [ ! -n "$SERVICE_PID" ]; then
      echo "ERROR: the service is already stopped"
      exit 1
    fi

    if [ -f $PID_BASE/pid.txt ]
    then
       pid=`cat $PID_BASE/pid.txt`
       echo "stopping service with pid = $pid"
       killproc -p $PID_BASE/pid.txt
       echo ""
    else
       echo $SERVICE_PID>$PID_BASE/pid.txt
       pid=`cat $PID_BASE/pid.txt`
       echo "stopping service with pid = $pid"
       killproc -p $PID_BASE/pid.txt
       echo ""
    fi

}
status() {
    SERVICE_PID=`ps -ef |grep   java | grep -v grep | grep MainService | awk '{print $2;}'`
    if [ -n "$SERVICE_PID" ]; then
      echo "the service is running with pid = $SERVICE_PID"
    else
      echo "the service is stopped"
    fi
}

case "$1" in
    start)
        message "start method called"
        start
        ;;
    stop)
        message "stop method called"
        stop
        ;;
    status)
        message "status method called"
        status
        ;;
    restart)
        message "restart method called"
        stop
        sleep 3
        start
        ;;
    *)
        echo "ERROR: unsupported request. usage: /home/ec2-user/db-api-service/bin/manage_db_api_service <start><stop><restart>"
        exit 1
esac