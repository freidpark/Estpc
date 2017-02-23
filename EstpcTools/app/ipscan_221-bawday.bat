@echo off


echo.
echo 아래 메뉴를 선택하시오.(저장폴더명 : saveLog)
echo =========================================
echo 1. IP Scan 프로그램을 바탕화면에 띄운다.(최대15개)
echo 2. 영동 PC방 8곳을 바탕화면에 띄운다.(파일저장 안됨!)
echo 3. 영동 PC방 8곳을 파일저장 후 바탕화면에 띄운다.(다소 시간 소요)
echo 4. 영동 PC방 8곳을 saveLog 폴더에 저장만 한다.
echo =========================================
set /p Mnum=선택한 메뉴는?(번호 입력) :


if %Mnum% LSS 5 (
echo.
echo %Mnum%번을 선택했습니다.
if %Mnum% EQU 1 (
goto :Mnum1
) else (
if %Mnum% EQU 2 (
goto :Mnum2
) else (
if %Mnum% EQU 3 (
goto :Mnum3
) else (
if %Mnum% EQU 4 (
goto :Mnum4
)
)
)
)
)else (
echo 1~4번 중에 선택하세요. 다시 시작 합니다.
pause
echo.
start.bat
)









:Mnum1

set pgm=ipscan_221-bawday.exe
set /p num=바탕화면에 프로그램을 몇 개 띄우시겠습니까?(최대15개):


if %num% LSS 16 (
echo.
if %num% EQU 1 (
%pgm%
exit
) else (
if %num% EQU 2 (
%pgm% | %pgm%
exit
) else (
if %num% EQU 3 (
%pgm% | %pgm% | %pgm% 
exit
) else (
if %num% EQU 4 (
%pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 5 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 6 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 7 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 8 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 9 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 10 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 11 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 12 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 13 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 14 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
) else (
if %num% EQU 15 (
%pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm% | %pgm%
exit
)
)
)
)
)
)
)
)
)
)
)
)
)
)
)
) else (
echo 최대 15개까지 띄울수 있습니다. 다시 시작해주세요
pause
echo.
start.bat
)




:Mnum2

set pgm01=ipscan_221-bawday.exe 118.44.147.131 118.44.147.181
set pgm02=ipscan_221-bawday.exe 110.15.193.130 110.15.193.230
set pgm03=ipscan_221-bawday.exe 110.15.192.130 110.15.192.180
set pgm04=ipscan_221-bawday.exe 211.199.215.66 211.199.215.108
set pgm05=ipscan_221-bawday.exe 210.223.234.70 210.223.234.120
set pgm06=ipscan_221-bawday.exe 61.40.48.70 61.40.48.120
set pgm07=ipscan_221-bawday.exe 115.20.245.9 115.20.245.70
set pgm08=ipscan_221-bawday.exe 211.225.194.140 211.225.194.239

echo.
echo 아래 영동 PC방 8곳을 바탕화면에 띄웁니다.(파일저장 없음)
echo -----------------------------------------------
echo 01.웰팡          (118.44.147.131 to 118.44.147.181)
echo 02.행복          (110.15.193.130 to 110.15.193.230)
echo 03.스타          (110.15.192.130 to 110.15.192.180)
echo 04.미래넷        (211.199.215.66 to 211.199.215.108)
echo 05.비엔시        (210.223.234.70 to 210.223.234.120)
echo 06.아이비정류장  (61.40.48.70 to 61.40.48.120)
echo 07.아프후문      (115.20.245.9 to 115.20.245.70)
echo 08.우리집        (211.225.194.140 to 211.225.194.239)
echo -----------------------------------------------

pause

%pgm01% | %pgm02% | %pgm03% | %pgm04% | %pgm05% | %pgm06% | %pgm07% | %pgm08%
exit





:Mnum3


set pgmS01=ipscan_221-bawday.exe -h 118.44.147.131 118.44.147.181 saveLog/웰팡.txt
set pgmS02=ipscan_221-bawday.exe -h 110.15.193.130 110.15.193.230 saveLog/행복.txt
set pgmS03=ipscan_221-bawday.exe -h 110.15.192.130 110.15.192.180 saveLog/스타.txt
set pgmS04=ipscan_221-bawday.exe -h 211.199.215.66 211.199.215.108 saveLog/미래넷.txt
set pgmS05=ipscan_221-bawday.exe -h 210.223.234.70 210.223.234.120 saveLog/비엔시.txt
set pgmS06=ipscan_221-bawday.exe -h 61.40.48.70 61.40.48.120 saveLog/아이비정류장.txt
set pgmS07=ipscan_221-bawday.exe -h 115.20.245.9 115.20.245.70 saveLog/아프후문.txt
set pgmS08=ipscan_221-bawday.exe -h 211.225.194.140 211.225.194.239 saveLog/이스트.txt

set pgm01=ipscan_221-bawday.exe 118.44.147.131 118.44.147.181
set pgm02=ipscan_221-bawday.exe 110.15.193.130 110.15.193.230
set pgm03=ipscan_221-bawday.exe 110.15.192.130 110.15.192.180
set pgm04=ipscan_221-bawday.exe 211.199.215.66 211.199.215.108
set pgm05=ipscan_221-bawday.exe 210.223.234.70 210.223.234.120
set pgm06=ipscan_221-bawday.exe 61.40.48.70 61.40.48.120
set pgm07=ipscan_221-bawday.exe 115.20.245.9 115.20.245.70
set pgm08=ipscan_221-bawday.exe 211.225.194.140 211.225.194.239



echo.
echo 아래 영동 PC방 8곳을 파일저장 후 바탕화면에 띄웁니다.(saveLog폴더에 저장됨)
echo 저장하는데 시간이 걸립니다.. 잠시만 기다려 주세요.
echo -----------------------------------------------
echo 01.웰팡          (118.44.147.131 to 118.44.147.181)
echo 02.행복          (110.15.193.130 to 110.15.193.230)
echo 03.스타          (110.15.192.130 to 110.15.192.180)
echo 04.미래넷        (211.199.215.66 to 211.199.215.108)
echo 05.비엔시        (210.223.234.70 to 210.223.234.120)
echo 06.아이비정류장  (61.40.48.70 to 61.40.48.120)
echo 07.아프후문      (115.20.245.9 to 115.20.245.70)
echo 08.우리집        (211.225.194.140 to 211.225.194.239)
echo -----------------------------------------------

pause


%pgmS01% | %pgmS02% | %pgmS03% | %pgmS04% | %pgmS05% | %pgmS06% | %pgmS07% | %pgmS08%
%pgm01% | %pgm02% | %pgm03% | %pgm04% | %pgm05% | %pgm06% | %pgm07% | %pgm08%
exit




:Mnum4

set pgmS01=ipscan_221-bawday.exe -h -f:xml 118.44.147.131 118.44.147.181 saveLog/웰팡.txt
set pgmS02=ipscan_221-bawday.exe -h -f:xml 110.15.193.130 110.15.193.230 saveLog/행복.txt
set pgmS03=ipscan_221-bawday.exe -h -f:xml 110.15.192.130 110.15.192.180 saveLog/스타.xml
set pgmS04=ipscan_221-bawday.exe -h -f:xml 211.199.215.66 211.199.215.108 saveLog/미래넷.txt
set pgmS05=ipscan_221-bawday.exe -h -f:xml 210.223.234.70 210.223.234.120 saveLog/비엔시.txt
set pgmS06=ipscan_221-bawday.exe -h -f:xml 61.40.48.70 61.40.48.120 saveLog/아이비정류장.txt
set pgmS07=ipscan_221-bawday.exe -h -f:xml 115.20.245.9 115.20.245.70 saveLog/아프후문.txt
set pgmS08=ipscan_221-bawday.exe -h -f:xml 211.225.194.140 211.225.194.239 saveLog/이스트.txt



echo.
echo 아래 영동 PC방 8곳을 파일로 저장만 합니다.(saveLog폴더 저장됨)
echo 저장 후 자동 종료됩니다. 잠시만 기다려 주세요.... 
echo -----------------------------------------------
echo 01.웰팡          (118.44.147.131 to 118.44.147.181)
echo 02.행복          (110.15.193.130 to 110.15.193.230)
echo 03.스타          (110.15.192.130 to 110.15.192.180)
echo 04.미래넷        (211.199.215.66 to 211.199.215.108)
echo 05.비엔시        (210.223.234.70 to 210.223.234.120)
echo 06.아이비정류장  (61.40.48.70 to 61.40.48.120)
echo 07.아프후문      (115.20.245.9 to 115.20.245.70)
echo 08.우리집        (211.225.194.140 to 211.225.194.239)
echo -----------------------------------------------

pause

%pgmS01% | %pgmS02% | %pgmS03% | %pgmS04% | %pgmS05% | %pgmS06% | %pgmS07% | %pgmS08%
exit
