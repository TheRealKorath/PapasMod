package com.korath.papasmod.client.renderer;

import com.korath.papasmod.PapasMod;
import com.korath.papasmod.itementities.custom.HealOrbEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class HealOrbRenderer extends ArrowRenderer<HealOrbEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(PapasMod.MOD_ID, "textures/entity/spectral_arrow.png");

    public HealOrbRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(HealOrbEntity arrow) {
        return TEXTURE;
    }
}