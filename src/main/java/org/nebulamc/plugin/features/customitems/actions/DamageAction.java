package org.nebulamc.plugin.features.customitems.actions;

import me.angeschossen.lands.api.flags.Flags;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.nebulamc.plugin.features.customitems.Action;
import org.nebulamc.plugin.utils.Utils;

public class DamageAction extends Action {

    double damage;

    public DamageAction(double damage){
        this.damage = damage;
    }

    @Override
    public void execute(Player player, Location location, Entity target) {
        if (target instanceof LivingEntity){
            if (target instanceof Player){
                if (!Utils.hasFlag(player, location, null, Flags.ATTACK_PLAYER))
                    return;
            }
            if (target instanceof Monster){
                if (!Utils.hasFlag(player, location, null, Flags.ATTACK_MONSTER))
                    return;
            }
            if (target instanceof Animals){
                if (!Utils.hasFlag(player, location, null, Flags.ATTACK_ANIMAL))
                    return;
            }
            ((LivingEntity) target).damage(damage, player);

        }
    }
}
