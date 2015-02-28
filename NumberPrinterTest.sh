#!/bin/bash

trap 'result=$?; printf "\n\n ^^^^^^^^^^^ error ${0} at line ${LINENO} ^^^^^^^^^^ \n\n"; echo $result; exit $result' ERR

##mvn clean test 
##mvn clean test -Dtest=NumberPrinterTest -DconvertionMode=WORDS -DnumberToConvert=999
##mvn clean test -Dtest=NumberPrinterTest -DconvertionMode=ROMAN -DnumberToConvert=999

mvn clean test -Dtest=NumberPrinterTest -DconvertionMode=$1 -DnumberToConvert=$2

