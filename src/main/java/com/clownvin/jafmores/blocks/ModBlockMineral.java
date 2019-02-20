package com.clownvin.jafmores.blocks;

import com.clownvin.jafmores.JAFMOres;
import com.clownvin.jafmores.ModResource;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class ModBlockMineral extends ModBlock {

    public ModBlockMineral(ModResource resource) {
        super(resource);
    }

    @Override
    public boolean isBeaconBase(IBlockState state, IWorldReader reader, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
