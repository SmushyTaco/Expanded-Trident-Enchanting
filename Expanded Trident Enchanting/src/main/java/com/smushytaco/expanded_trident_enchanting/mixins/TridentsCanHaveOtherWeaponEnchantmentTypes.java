package com.smushytaco.expanded_trident_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(DamageEnchantment.class)
public abstract class TridentsCanHaveOtherWeaponEnchantmentTypes {
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) { return ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseOtherWeaponEnchantmentTypesOnTrident() && stack.getItem() instanceof TridentItem || original; }
}