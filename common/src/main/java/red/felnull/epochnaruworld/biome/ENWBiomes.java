package red.felnull.epochnaruworld.biome;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import red.felnull.otyacraftengine.api.helper.BiomeRegisterHelper;

public class ENWBiomes {
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> OBSIDIAN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(Blocks.OBSIDIAN.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));

    public static void init(BiomeRegisterHelper reg) {
/*
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.monsters(spawnSettings, 95, 5, 100);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        generationSettings.surfaceBuilder(OBSIDIAN_SURFACE_BUILDER);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);
        BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
        BiomeDefaultFeatures.addDefaultLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);

        Biome b = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x3f76e4).waterFogColor(0x050533).fogColor(0xc0d8ff).skyColor(0x77adff).build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();


        IKSGBiomeUtil.registerConfiguredSurfaceBuilder(new ResourceLocation(EpochNaruWorld.MODID, "test"), OBSIDIAN_SURFACE_BUILDER);
        reg.registrationBiome(new ResourceLocation(EpochNaruWorld.MODID, "test"), b);
        reg.registrationAddOverworldContinentalBiome(new ResourceLocation(EpochNaruWorld.MODID, "test"), IKSGBiomeUtil.BiomeType.TEMPERATE, 1);
    */
    }
}
