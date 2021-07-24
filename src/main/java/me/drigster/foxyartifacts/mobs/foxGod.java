package me.drigster.foxyartifacts.mobs;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

public class foxGod extends EntityFox {

    public foxGod(Location loc){
        super(EntityTypes.FOX, ((CraftWorld)loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new ChatComponentText(ChatColor.GOLD + "FOX GOD"));
        this.setCustomNameVisible(true);
        this.setInvulnerable(true);
        this.setCanPickupLoot(false);

        this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(10);
    }

    @Override
    public void initPathfinder() {
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalDoorOpen(this, true));
        this.goalSelector.a(3, new PathfinderGoalLeapAtTarget(this, 0.4F));
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 3D, true));
    }
}
