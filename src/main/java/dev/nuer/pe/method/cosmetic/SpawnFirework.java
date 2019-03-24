package dev.nuer.pe.method.cosmetic;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class SpawnFirework {

    public SpawnFirework(Player player) {
        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(),
                EntityType.FIREWORK);
        FireworkMeta fireworkMeta = firework.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder()
                .withColor(Color.AQUA.mixColors(Color.WHITE.mixColors(Color.PURPLE)))
                .withFade(Color.PURPLE).with(FireworkEffect.Type.BALL_LARGE).build();
        fireworkMeta.setPower(0);
        fireworkMeta.addEffect(effect);
        firework.setFireworkMeta(fireworkMeta);
    }
}
