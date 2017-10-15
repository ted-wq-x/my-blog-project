#!/bin/bash
#cd /path/to/your-project
# git pull origin master

cd /usr/java/
if [ ! -d "./core_proj_bak" ]; then
  mkdir core_proj_bak
fi
# 备份文件
temp=$(date +%Y-%m-%d-%H-%M-%S)
filetemp=*.jar
mv $filetemp core_proj_bak/$temp.jar

mv ~/*.jar /usr/java/core-blog.jar

# 重启


varNum=$(ps x | grep core | grep 'java' | awk '{print $1}')

#echo "varNum='$varNum'"
##
if [ -n $varNum ]
then 	
  kill -9 $varNum
fi
##
echo 'kill core success'
nohup java -jar /usr/java/core-blog.jar  &
echo 'start core success'
echo 'travis build done!'
exit 0
