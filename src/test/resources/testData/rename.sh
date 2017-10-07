autoload -Uz zmv
alias zmv='noglob zmv -W'
cd ./src/test/resources/testData/music_festival
# zmv -n (*)-表1.csv $1.csv
zmv *-表1.csv *.csv

cd ..
cp ./table-ordering.txt ./music_festival/table-ordering.txt