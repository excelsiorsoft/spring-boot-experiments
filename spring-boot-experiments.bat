
start /B C:\"Program Files"\SpringTools4\sts-4.5.0.RELEASE\SpringToolSuite4.exe -data %~dp0 -clean -showlocation -vmC:\Java\jdk1.8.0_144\bin\java.exe -vmargs -Xmx1024m -XX:MaxPermSize=256m -vmargs -javaagent:lombok.jar
