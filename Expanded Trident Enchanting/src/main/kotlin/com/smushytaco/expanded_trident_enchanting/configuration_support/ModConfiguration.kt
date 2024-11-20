package com.smushytaco.expanded_trident_enchanting.configuration_support
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
@Config(name = ExpandedTridentEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    val canUseFireAspectOnTrident = true
    val canUseKnockbackOnTrident = true
    val canUseLootingOnTrident = true
    val canUseDensityOnTrident = true
    val canUseBreachOnTrident = true
    val canUseWindBurstOnTrident = true
    val canUseOtherWeaponEnchantmentTypesOnTrident = true
    val impalingAndOtherWeaponEnchantmentTypesCanBeMixed = true
}