#! /bin/sh

port='8095'
JVM_OPTS=" -Xms8g -Xmx8g -XX:PermSize=512M -XX:MaxPermSize=512M "

currentDir=$(cd `dirname $0`; pwd)
echo $currentDir


kill -9 $(netstat -nlp | grep :${port} | awk '{print $7}' | awk -F"/" '{ print $1 }')


runFile=$(ls -t *.jar | head -1)

array=(${runFile//.jar/})
fileName=${array[0]}
nohup /data/otcd/jdk1.8.0_261/bin/java -jar $JVM_OPTS $currentDir''/$runFile >/dev/null 2>&1 &

----------------------------------------------------------------------------------------------------------------------------------

# vi deploy.sh

APP_NAME=OTCD_TO_BRANCH

echo "prepare to deploy $APP_NAME"

pid=`ps -ef | /usr/workspace/otcd/t0/grep otcd_server-1.0.3.0.jar  | grep -v grep | awk '{print $2}'`

if [[ $pid ]]; then

   echo "$APP_NAME is running and pid is $pid"
   kill -9 $pid
   if [[ $? -eq 0 ]];then
       echo "sucess to stop $APP_NAME"
   else
       echo "fail to stop $APP_NAME"
   fi
fi

echo "start to deploy $APP_NAME"

nohup java -jar -Dspring.profiles.active=deploy /usr/workspace/otcd/t0/otcd_server-1.0.3.0.jar >/usr/workspace/otcd/t0/nohup.out 2>&1 &
