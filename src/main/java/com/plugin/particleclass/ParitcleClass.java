package com.plugin.particleclass;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public final class ParitcleClass extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }



    @EventHandler
    public void onIneteracrt(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            Location loc = e.getPlayer().getEyeLocation();

                new BukkitRunnable() {
                    double u;

                    @Override
                    public void run() {
                        u += Math.PI/8;
                        for(double t = 0; t<Math.PI *2;t +=Math.PI /8)
                        {
                            double majorR = 4;
                            double minorR = 1;

                            double x = Math.cos(t) * (majorR + minorR*Math.cos(u));
                            double y = minorR * Math.sin(u) - 1;
                            double z = Math.sin(t) * (majorR + minorR*Math.cos(u));

                            loc.add(x, y, z);
                            e.getPlayer().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                            loc.subtract(x, y, z);
                        }
                        if (u > Math.PI*2) cancel();
                    }


                }.runTaskTimer(this, 0, 1L);





        }
    }

}
