package com.scouter.oceansdelight.blocks;

import com.nhoryzon.mc.farmersdelight.block.FeastBlock;
import com.scouter.oceansdelight.items.ODItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class GuardianSoupBlock extends FeastBlock {

    public GuardianSoupBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                .strength(0.5F, 6.0F).noOcclusion()
                .sound(SoundType.LANTERN), ODItems.BOWL_OF_GUARDIAN_SOUP, true);
    }
    //public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 5);
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE,
            Stream.of(
                    Block.box(2, 3, 0, 14, 15, 16),
                    Block.box(14, 3, 2, 16, 15, 14),
                    Block.box(0, 3, 2, 2, 15, 14),
                    Block.box(2, 1, 2, 14, 3, 14)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get()
                    ,BooleanOp.OR
            );


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : PIE_SHAPE;
    }
}
