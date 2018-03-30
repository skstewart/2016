;Name: Shayna Stewart
;Date: 5/30/16
;Project 3 5.4 #24
;
         CHARI   0x000D,d    ;Input first character
         CHARI   0x000E,d    ;Input second character
         CHARO   0x000D,d    ;Output first character
         CHARO   '\n',i
         CHARO   0x000E,d    ;Output second character
         STOP                
         .BLOCK  1           ;Storag for first char
         .BLOCK  2           ;Storage for second char
         .END                  
