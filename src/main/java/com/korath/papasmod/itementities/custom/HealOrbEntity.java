package com.korath.papasmod.itementities.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class HealOrbEntity extends AbstractArrow {
    public HealOrbEntity(EntityType<HealOrbEntity> entityType, Level world) {
        super(entityType, world);
        this.setNoGravity(true);


    }

    public HealOrbEntity(EntityType<HealOrbEntity> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
        this.setNoGravity(true);
    }

    public HealOrbEntity(EntityType<HealOrbEntity> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
        this.setNoGravity(true);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {

        if(result.getEntity() instanceof Player player)
        {
            player.heal(4f);

        }
        discard();

    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        discard();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
