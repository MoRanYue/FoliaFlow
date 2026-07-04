package xyz.hynse.foliaflow.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import xyz.hynse.foliaflow.FoliaFlow;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("foliaflow.reload")) return true;
        try {
            FoliaFlow.instance.reload();
            sender.sendMessage(Component.text("FoliaFlow reloaded.").color(NamedTextColor.YELLOW));
        } catch (Exception e) {
            sender.sendMessage(Component.text("Something went wrong reloading FoliaFlow, see the console for more.").color(NamedTextColor.RED));
            e.printStackTrace();
        }
        return true;
    }
}
