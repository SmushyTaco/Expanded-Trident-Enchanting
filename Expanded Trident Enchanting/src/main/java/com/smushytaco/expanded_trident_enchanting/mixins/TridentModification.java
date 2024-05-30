package com.smushytaco.expanded_trident_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.tag.ItemTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Enchantment.class)
public abstract class TridentModification {
    @Shadow
    @Final
    private Enchantment.Properties properties;
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment == Enchantments.FIRE_ASPECT) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (enchantment == Enchantments.KNOCKBACK) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        }  else if (enchantment instanceof LuckEnchantment) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseLootingOnTrident() || properties.supportedItems() != ItemTags.SWORD_ENCHANTABLE || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (enchantment instanceof DamageEnchantment) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseOtherWeaponEnchantmentTypesOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        }
        return original;
    }
}