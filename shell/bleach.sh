#!/bin/bash
# travse and bleach the java files in order to have friendly content.
# What does bleach do:
# 1. remove the /* xx */ de-compiled content
# 

function travse(){
    echo "travse() $1"
    for file in ` ls $1`
        do
                if [ -d $1"/"$file ] #如果file存在且是一个目录则为真
                then
                    travse $1"/"$file
                else
                    local path=$1"/"$file #得到文件的完整的目录
                    #bleach the java file.
                    if [[ $path =~ ".java" ]]
                    then
                    	echo "Bleach [$path]"
                    	sed -i 's/^\/\*.*\*\///g' $path
                    fi
                fi
        done
}

travse $1