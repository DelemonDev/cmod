package net.cmodcom.entity.custom;

import net.cmodcom.entity.ModEntities;
import net.cmodcom.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SkulkPetrificationStoneEntity extends ThrownItemEntity {
    private static final int RADIUS = 8; // Define the radius

    public SkulkPetrificationStoneEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public SkulkPetrificationStoneEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.SKULK_PETRIFICATION_STONE_ENTITY, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SKULK_PETRIFICATION_STONE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            replaceBlocksWithAir(blockHitResult.getBlockPos());
            this.getWorld().sendEntityStatus(this, (byte) 3);
        }

        this.discard();
        super.onBlockHit(blockHitResult);
    }

    private void replaceBlocksWithAir(BlockPos center) {
        World world = this.getWorld();
        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int y = -RADIUS; y <= RADIUS; y++) {
                for (int z = -RADIUS; z <= RADIUS; z++) {
                    BlockPos pos = center.add(x, y, z);
                    if (world.getBlockState(pos).getBlock() == Blocks.SCULK) {
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    }
                    if (world.getBlockState(pos).getBlock() == Blocks.SCULK_VEIN) {
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
    }
}