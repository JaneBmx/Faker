SETLOCAL EnableDelayedExpansion
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /format:list') do set t=%%I
set /a t1 = %t:~8,1%*36000 + %t:~9,1%*3600 + %t:~10,1%*600 + %t:~11,1%*60 + %t:~12,1%*10 + %t:~13,1% && set t1=!t1!%t:~15,3%

java -jar Faker.jar be_BY 1000000 > NUL

for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /format:list') do set t=%%I
set /a t2 = %t:~8,1%*36000 + %t:~9,1%*3600 + %t:~10,1%*600 + %t:~11,1%*60 + %t:~12,1%*10 + %t:~13,1% && set t2=!t2!%t:~15,3%
set /a t2-=t1 && if !t2! lss 0 set /a t2+=24*3600000
set /a "h=t2/3600000,t2%%=3600000,m=t2/60000,t2%%=60000" && set t2=00000!t2!&& set t2=!t2:~-5!
if %h% leq 9 (set h=0%h%) && if %m% leq 9 (set m=0%m%)
set t2=%h%:%m%:%t2:~0,2%.%t2:~2,3%
echo %t2%
ENDLOCAL
PAUSE