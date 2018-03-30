;Name: Shayna Stewart
;Date: 5/30/16
;Project 3
;Description: Takes in a number and divides by 16, then outputs the new number.
;
         BR      main        ;Branch around data
num:     .BLOCK  2           ;Storage for one integer #2d
msg:     .ASCII  " / 16 = \x00"
;
main:    DECI    num,d       ;Get the number
         DECO    num,d       ;and output it
         STRO    msg,d       ;Output ' /16 = '
         LDA     num,d       ;A <- the number
         ASRA                ;   / 2
         ASRA                ;   / 2
         ASRA                ;   / 2
         ASRA                ;   / 2
         STA     num,d       ;Store the sum
         DECO    num,d       ;Output the sum
         STOP                
         .END                  
