/*package com.scouter.oceansdelight.datagen;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class BlockstateGenerator extends BlockStateProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public BlockstateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, OceansDelight.MODID, exFileHelper);
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(OceansDelight.MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels(){
        this.feastBlock((FeastBlock) ODBlocks.GUARDIAN_SOUP.get());
    }

    public void feastBlock(FeastBlock block) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            IntegerProperty servingsProperty = block.getServingsProperty();
            int servings = (Integer)state.getValue(servingsProperty);
            String suffix = "_stage" + (block.getMaxServings() - servings);
            if (servings == 0) {
                suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
            }

            ConfiguredModel.Builder var10000 = ConfiguredModel.builder();
            String var10002 = this.blockName(block);
            return var10000.modelFile(this.existingModel(var10002 + suffix)).rotationY(((int)((Direction)state.getValue(FeastBlock.FACING)).toYRot() + 180) % 360).build();
        });
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public void tomatoBlock(Block block, ResourceLocation texture, String renderType) {
        tomatoBlock(block, key(block).toString(), texture, renderType);
    }

    public void tomatoBlock(Block block, String baseName, ResourceLocation texture, String  renderType) {
        ModelFile age1 = models().cross(baseName + "_stage0", new ResourceLocation(texture.toString() + "_stage0")).renderType(renderType);
        ModelFile age2 = models().cross(baseName + "_stage1",  new ResourceLocation(texture.toString() + "_stage1")).renderType(renderType);
        ModelFile age3 = models().cross(baseName + "_stage2",  new ResourceLocation(texture.toString() + "_stage2")).renderType(renderType);
        ModelFile age4 = models().cross(baseName + "_stage3",  new ResourceLocation(texture.toString() + "_stage3")).renderType(renderType);

        tomatoBlock(block, age1, age2, age3, age4);
    }
    private void tomatoBlock(Block block, ModelFile age1, ModelFile age2, ModelFile age3, ModelFile age4){
        getVariantBuilder(block).forAllStatesExcept((state -> {
            switch ( state.getValue(BlockStateProperties.AGE_3)){
                default: return ConfiguredModel.builder().modelFile(age1).build();
                case 1:return ConfiguredModel.builder().modelFile(age2).build();
                case 2:return ConfiguredModel.builder().modelFile(age3).build();
                case 3:return ConfiguredModel.builder().modelFile(age4).build();
            }
        }));
    }



    @Override
    public String getName() {
        return "Block States: " + OceansDelight.MODID;
    }
}
*/