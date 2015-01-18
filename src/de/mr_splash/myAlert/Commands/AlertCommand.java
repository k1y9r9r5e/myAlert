package de.mr_splash.myAlert.Commands;

import de.mr_splash.myAlert.myAlert;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AlertCommand extends Command
{

    private myAlert plugin;
    public AlertCommand(myAlert plugin)
    {
        super("malert");
        this.plugin = plugin;
    }

    public void execute(CommandSender sender, String[] args)
    {
        if(sender.hasPermission("myalert.alert"))
        {
            if (args.length >= 1)
            {
                String msg = "";

                for (String messages : args)
                {
                    msg = msg + messages + " ";
                }

                for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers())
                {
                    p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', plugin.prefix + " " + ChatColor.translateAlternateColorCodes('&', msg))));
                }
            }
            else
            {
                sender.sendMessage(new TextComponent(ChatColor.RED + "/malert <message>"));
            }
        }
        else
        {
            sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "You do not have the permission to use this command!"));
        }
    }
}
