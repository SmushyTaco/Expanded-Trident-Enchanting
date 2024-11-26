package com.smushytaco.expanded_trident_enchanting
import io.wispforest.owo.config.annotation.*
@Modmenu(modId = ExpandedTridentEnchanting.MOD_ID)
@Config(name = ExpandedTridentEnchanting.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var canUseFireAspectOnTrident = true
    @JvmField
    var canUseKnockbackOnTrident = true
    @JvmField
    var canUseLootingOnTrident = true
    @JvmField
    var canUseDensityOnTrident = true
    @JvmField
    var canUseBreachOnTrident = true
    @JvmField
    var canUseWindBurstOnTrident = true
    @JvmField
    var canUseOtherWeaponEnchantmentTypesOnTrident = true
    @JvmField
    var impalingAndOtherWeaponEnchantmentTypesCanBeMixed = true
}