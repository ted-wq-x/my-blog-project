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
rm -rf ~/*.jar

echo 'travis build done!'
