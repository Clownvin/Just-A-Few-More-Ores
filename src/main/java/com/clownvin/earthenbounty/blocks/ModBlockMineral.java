package com.clownvin.earthenbounty.blocks;

import com.clownvin.earthenbounty.ModResource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ModBlockMineral extends ModBlock {

    public ModBlockMineral(ModResource resource) {
        super(resource);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
