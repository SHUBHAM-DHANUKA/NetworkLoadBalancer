awk 'BEGIN{FS=" "} {print $7}' client_textConfig2.txt | head -8 | tail -1 > bandwidth2.txt

