package com.github.koryu25.rpg.command.commands;

import com.github.koryu25.rpg.Main;
import com.github.koryu25.rpg.adventurer.skill.Accuracy;
import com.github.koryu25.rpg.adventurer.skill.SkillMoment;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ArrayList<SkillMoment> momentList = Main.getInstance().getSkillStyleList().get(0).get(0).getSkillTiming().getMomentList();

            for (int i = 0; i < momentList.size(); i++) {
                SkillMoment moment = momentList.get(i);
                if (moment.accuracy == Accuracy.CRITICAL) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        }
                    }.runTaskLater(Main.getInstance(), i);
                }
            }
            String str = "";
            for (SkillMoment moment : momentList) {
                str = str + moment.accuracy.getSymbol();
            }
            player.sendMessage(str);
            return true;
        }
        return false;
    }
}
