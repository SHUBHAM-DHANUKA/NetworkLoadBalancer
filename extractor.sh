awk 'BEGIN{FS=" "} {print $7}' client_textConfig.txt | head -8 | tail -1 > bandwidth.txt

