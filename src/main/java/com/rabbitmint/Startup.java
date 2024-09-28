package com.rabbitmint;

import org.bukkit.Bukkit;

import static com.rabbitmint.Data.*;
import static org.bukkit.Bukkit.getLogger;

public class Startup {

    public void onStartup() {
        getLogger().info("[RabbitMint] 신들의 전쟁 플러그인이 활성화 되었습니다.");
        getLogger().info("[RabbitMint] 인식된 신들의 전쟁 플러그인의 버전은 "+ Version +" 입니다.");
        getLogger().info("[RabbitMint] 인식된 신들의 전쟁 플러그인의 버전 채널은 "+ VerChannel +" 입니다.");

        if (!"Release".equals(VerChannel)) {
            getLogger().info("[RabbitMint] 사용중인 버전은 권장되지 않은 버전 입니다.");
            getLogger().info("[RabbitMint] "+ GitHubLink +" 에서 권장 버전을 다운로드해서 사용해주세요.");
        }

    }

    public void onShutdown() {
        getLogger().info("[RabbitMint] 서버가 종료 됩니다.");
        Bukkit.shutdown();
    }
}
