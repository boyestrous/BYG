package corgiaoc.byg.common.world.biome.nether;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGNetherBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;

public class CrimsonGardens extends BYGNetherBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("crimson_gardens", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.CRIMSON_GARDENS, BYGSurfaceBuilders.Configs.CRIMSON_GARDEN));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 11280416;
    static final int FOLIAGE_COLOR = 11280416;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public CrimsonGardens() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .grassColor(GRASS_COLOR)
                .foliageColor(FOLIAGE_COLOR)
                .fogColor(3343107)
                .skyColor(BiomeUtil.calcSkyColor(2.0F))
                .particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.01428F))
                .loopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    static {
        //TODO: Reenable Embur Bog lake.
        GENERATION_SETTINGS.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_LAVA);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NETHER);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NETHER);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA);
        DefaultBiomeFeatures.addNetherMineables(GENERATION_SETTINGS); //Stones
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.FORTRESS); //Fortress
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT); //BastionRemnant
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.WEEPING_VINES);//Weeping Vines
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.CRIMSON_FUNGI); //Crimson Fungi
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.CRIMSON_FOREST_VEGETATION); //Crimson Forest Vegetation
//        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.field_243949_i); //Basalt Columns Large

        BYGDefaultBiomeFeatures.addCrimsonGardensVegetation(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HOGLIN, 9, 3, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 100, 2, 5));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 15, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

    }
}