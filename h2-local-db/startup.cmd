@echo off

REM url de conexion: 
REM SET url="jdbc:h2:data/curso-spring"
REM 
SET url="jdbc:h2:tcp://localhost/./data/curso-spring"
REM Driver:
SET driver="org.h2.Driver"

ECHO "iniciando h2"
ECHO "url: %url%"
ECHO "driver: %driver%"

REM java -cp h2-1.3.170.jar org.h2.tools.Server
java -cp h2-2.1.210.jar org.h2.tools.Server
