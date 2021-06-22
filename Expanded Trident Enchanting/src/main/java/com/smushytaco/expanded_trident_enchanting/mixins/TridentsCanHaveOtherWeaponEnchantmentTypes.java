package com.smushytaco.expanded_trident_enchanting.mixins;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(DamageEnchantment.class)
public abstract class TridentsCanHaveOtherWeaponEnchantmentTypes {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseOtherWeaponEnchantmentTypesOnTrident() || !(stack.getItem() instanceof TridentItem)) return;
        cir.setReturnValue(true);
    }
}