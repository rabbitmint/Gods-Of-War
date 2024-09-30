@echo off
:start
copy /y "E:\Desktop\LikeMint\target\LikeMint-1.0.jar" "E:\Desktop\LikeMint\server\plugins\"
cls
"E:\Program Files\Zulu\zulu-16\bin\java.exe" -Xmx3G -XX:+UseG1GC -Dfile.encoding=UTF-8 -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=8M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=15 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 -Daikars.new.flags=true -Dusing.aikars.flags=https://mcutils.com -jar server.jar --nogui
pause >nul
cls
echo Server restarting...
goto :start