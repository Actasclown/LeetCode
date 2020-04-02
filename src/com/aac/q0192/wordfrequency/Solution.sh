cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2,$1}'
# grep -oP '\w+' words.txt | sort | uniq -c | sort -r | awk '{print $2,$1}'
