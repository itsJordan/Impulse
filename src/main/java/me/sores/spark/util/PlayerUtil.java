package me.sores.spark.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

/**
 * Created by sores on 3/3/2020.
 */
public class PlayerUtil {

    public static boolean doesExist(Player player){
        return Bukkit.getOnlinePlayers().contains(player);
    }

    public static boolean doesExist(UUID uuid){
        return Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(uuid));
    }

    public static boolean isInWater(Player player) {
        return (player.getLocation().getBlock().getType() == Material.WATER || player.getLocation().getBlock().getType() == Material.STATIONARY_WATER);
    }

    public static void gotoSpawn(Player player){
        Location spawn = player.getWorld().getSpawnLocation();

        player.teleport(spawn);
    }

    public static int getPotionLevel(Player player, PotionEffectType type) {
        for (PotionEffect pe : player.getActivePotionEffects()) {
            if (pe.getType().getName().equals(type.getName())) {
                return pe.getAmplifier() + 1;
            }
        }
        return 0;
    }

    public static PotionEffect getPotionEffect(Player player, PotionEffectType type) {
        for(PotionEffect pe : player.getActivePotionEffects()) {
            if(pe.getType().getName().equalsIgnoreCase(type.getName())) {
                return pe;
            }
        }
        return null;
    }

    public static void clearEffects(Player player){
        for(PotionEffect effect : player.getActivePotionEffects()){
            player.removePotionEffect(effect.getType());
        }
    }

    public static void clearInventory(Player player){
        player.getInventory().clear();
        clearArmor(player);
    }

    public static void clearArmor(Player player){
        PlayerInventory inventory = player.getInventory();

        inventory.setHelmet(new ItemStack(Material.AIR));
        inventory.setChestplate(new ItemStack(Material.AIR));
        inventory.setLeggings(new ItemStack(Material.AIR));
        inventory.setBoots(new ItemStack(Material.AIR));
    }

    public static boolean hasHelmet(Player player){
        return player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getType() != Material.AIR;
    }

    public static boolean hasChest(Player player){
        return player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() != Material.AIR;
    }

    public static boolean hasLegs(Player player){
        return player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getType() != Material.AIR;
    }

    public static boolean hasBoots(Player player){
        return player.getInventory().getBoots() != null && player.getInventory().getBoots().getType() != Material.AIR;
    }

}
