package com.korath.papasmod.itementities.custom;

import com.korath.papasmod.particle.ModParticles;
import com.korath.papasmod.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class HealOrbEntity extends AbstractOrb {
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
            this.playSound(ModSounds.HEAL_ORB_HIT.get());

            if(player.level instanceof ServerLevel serverLevel)
                spawnHealingParticles(player.blockPosition(), serverLevel);
        }


        discard();

    }

    public static  void spawnHealingParticles(BlockPos pos, ServerLevel level )
    {
        for(int i=0; i < 360; i++)
        {
            if(i%20 == 0)
            {
                double x = pos.getX()+0.5d + Math.cos(i);
                double y = pos.getY()+0.5d;
                double z = pos.getZ() +0.5d + Math.sin(i);

                level.sendParticles(ParticleTypes.COMPOSTER,
                        x, y, z,
                        0, 0, 0,
                        1f, 1);
            }
        }
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
