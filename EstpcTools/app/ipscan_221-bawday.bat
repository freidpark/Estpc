@echo off


echo.
echo �Ʒ� �޴��� �����Ͻÿ�.(���������� : saveLog)
echo =========================================
echo 1. IP Scan ���α׷��� ����ȭ�鿡 ����.(�ִ�15��)
echo 2. ���� PC�� 8���� ����ȭ�鿡 ����.(�������� �ȵ�!)
echo 3. ���� PC�� 8���� �������� �� ����ȭ�鿡 ����.(�ټ� �ð� �ҿ�)
echo 4. ���� PC�� 8���� saveLog ������ ���常 �Ѵ�.
echo =========================================
set /p Mnum=������ �޴���?(��ȣ �Է�) :


if %Mnum% LSS 5 (
echo.
echo %Mnum%���� �����߽��ϴ�.
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
echo 1~4�� �߿� �����ϼ���. �ٽ� ���� �մϴ�.
pause
echo.
start.bat
)









:Mnum1

set pgm=ipscan_221-bawday.exe
set /p num=����ȭ�鿡 ���α׷��� �� �� ���ðڽ��ϱ�?(�ִ�15��):


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
echo �ִ� 15������ ���� �ֽ��ϴ�. �ٽ� �������ּ���
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
echo �Ʒ� ���� PC�� 8���� ����ȭ�鿡 ���ϴ�.(�������� ����)
echo -----------------------------------------------
echo 01.����          (118.44.147.131 to 118.44.147.181)
echo 02.�ູ          (110.15.193.130 to 110.15.193.230)
echo 03.��Ÿ          (110.15.192.130 to 110.15.192.180)
echo 04.�̷���        (211.199.215.66 to 211.199.215.108)
echo 05.�񿣽�        (210.223.234.70 to 210.223.234.120)
echo 06.���̺�������  (61.40.48.70 to 61.40.48.120)
echo 07.�����Ĺ�      (115.20.245.9 to 115.20.245.70)
echo 08.�츮��        (211.225.194.140 to 211.225.194.239)
echo -----------------------------------------------

pause

%pgm01% | %pgm02% | %pgm03% | %pgm04% | %pgm05% | %pgm06% | %pgm07% | %pgm08%
exit





:Mnum3


set pgmS01=ipscan_221-bawday.exe -h 118.44.147.131 118.44.147.181 saveLog/����.txt
set pgmS02=ipscan_221-bawday.exe -h 110.15.193.130 110.15.193.230 saveLog/�ູ.txt
set pgmS03=ipscan_221-bawday.exe -h 110.15.192.130 110.15.192.180 saveLog/��Ÿ.txt
set pgmS04=ipscan_221-bawday.exe -h 211.199.215.66 211.199.215.108 saveLog/�̷���.txt
set pgmS05=ipscan_221-bawday.exe -h 210.223.234.70 210.223.234.120 saveLog/�񿣽�.txt
set pgmS06=ipscan_221-bawday.exe -h 61.40.48.70 61.40.48.120 saveLog/���̺�������.txt
set pgmS07=ipscan_221-bawday.exe -h 115.20.245.9 115.20.245.70 saveLog/�����Ĺ�.txt
set pgmS08=ipscan_221-bawday.exe -h 211.225.194.140 211.225.194.239 saveLog/�̽�Ʈ.txt

set pgm01=ipscan_221-bawday.exe 118.44.147.131 118.44.147.181
set pgm02=ipscan_221-bawday.exe 110.15.193.130 110.15.193.230
set pgm03=ipscan_221-bawday.exe 110.15.192.130 110.15.192.180
set pgm04=ipscan_221-bawday.exe 211.199.215.66 211.199.215.108
set pgm05=ipscan_221-bawday.exe 210.223.234.70 210.223.234.120
set pgm06=ipscan_221-bawday.exe 61.40.48.70 61.40.48.120
set pgm07=ipscan_221-bawday.exe 115.20.245.9 115.20.245.70
set pgm08=ipscan_221-bawday.exe 211.225.194.140 211.225.194.239



echo.
echo �Ʒ� ���� PC�� 8���� �������� �� ����ȭ�鿡 ���ϴ�.(saveLog������ �����)
echo �����ϴµ� �ð��� �ɸ��ϴ�.. ��ø� ��ٷ� �ּ���.
echo -----------------------------------------------
echo 01.����          (118.44.147.131 to 118.44.147.181)
echo 02.�ູ          (110.15.193.130 to 110.15.193.230)
echo 03.��Ÿ          (110.15.192.130 to 110.15.192.180)
echo 04.�̷���        (211.199.215.66 to 211.199.215.108)
echo 05.�񿣽�        (210.223.234.70 to 210.223.234.120)
echo 06.���̺�������  (61.40.48.70 to 61.40.48.120)
echo 07.�����Ĺ�      (115.20.245.9 to 115.20.245.70)
echo 08.�츮��        (211.225.194.140 to 211.225.194.239)
echo -----------------------------------------------

pause


%pgmS01% | %pgmS02% | %pgmS03% | %pgmS04% | %pgmS05% | %pgmS06% | %pgmS07% | %pgmS08%
%pgm01% | %pgm02% | %pgm03% | %pgm04% | %pgm05% | %pgm06% | %pgm07% | %pgm08%
exit




:Mnum4

set pgmS01=ipscan_221-bawday.exe -h -f:xml 118.44.147.131 118.44.147.181 saveLog/����.txt
set pgmS02=ipscan_221-bawday.exe -h -f:xml 110.15.193.130 110.15.193.230 saveLog/�ູ.txt
set pgmS03=ipscan_221-bawday.exe -h -f:xml 110.15.192.130 110.15.192.180 saveLog/��Ÿ.xml
set pgmS04=ipscan_221-bawday.exe -h -f:xml 211.199.215.66 211.199.215.108 saveLog/�̷���.txt
set pgmS05=ipscan_221-bawday.exe -h -f:xml 210.223.234.70 210.223.234.120 saveLog/�񿣽�.txt
set pgmS06=ipscan_221-bawday.exe -h -f:xml 61.40.48.70 61.40.48.120 saveLog/���̺�������.txt
set pgmS07=ipscan_221-bawday.exe -h -f:xml 115.20.245.9 115.20.245.70 saveLog/�����Ĺ�.txt
set pgmS08=ipscan_221-bawday.exe -h -f:xml 211.225.194.140 211.225.194.239 saveLog/�̽�Ʈ.txt



echo.
echo �Ʒ� ���� PC�� 8���� ���Ϸ� ���常 �մϴ�.(saveLog���� �����)
echo ���� �� �ڵ� ����˴ϴ�. ��ø� ��ٷ� �ּ���.... 
echo -----------------------------------------------
echo 01.����          (118.44.147.131 to 118.44.147.181)
echo 02.�ູ          (110.15.193.130 to 110.15.193.230)
echo 03.��Ÿ          (110.15.192.130 to 110.15.192.180)
echo 04.�̷���        (211.199.215.66 to 211.199.215.108)
echo 05.�񿣽�        (210.223.234.70 to 210.223.234.120)
echo 06.���̺�������  (61.40.48.70 to 61.40.48.120)
echo 07.�����Ĺ�      (115.20.245.9 to 115.20.245.70)
echo 08.�츮��        (211.225.194.140 to 211.225.194.239)
echo -----------------------------------------------

pause

%pgmS01% | %pgmS02% | %pgmS03% | %pgmS04% | %pgmS05% | %pgmS06% | %pgmS07% | %pgmS08%
exit
