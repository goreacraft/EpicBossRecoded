package me.ThaH3lper.com.Commands;

import me.ThaH3lper.com.EpicBoss;
import me.ThaH3lper.com.Boss.Boss;
import me.ThaH3lper.com.LoadBosses.LoadBoss;
import me.ThaH3lper.locations.Locations;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsPlayer{
	private EpicBoss eb;
	String s = ChatColor.DARK_RED + "-------------------" + ChatColor.GRAY + "[ " + ChatColor.RED + ChatColor.BOLD + "EpicBoss" + ChatColor.GRAY +" ]" + ChatColor.DARK_RED + "-------------------";
	
	private Bosses bosses;
	private Timers timer;
	private Location location;
	private Bossegg bossegg;
	
	public CommandsPlayer(EpicBoss boss)
	{
		eb = boss;
		bosses = new Bosses(eb);
		timer = new Timers(eb);
		location = new Location(eb);
		bossegg = new Bossegg(eb);
	}
	public void Command (CommandSender sender, Command cmd, String commandlabel, String[] args)
	{
		Player p = (Player) sender;
		if(args.length == 0)
		{
			p.sendMessage(s);
			p.sendMessage(ChatColor.RED + "/eb boss" + ChatColor.GRAY + ChatColor.ITALIC + "   Commands/info about Bosses");
			p.sendMessage(ChatColor.RED + "/eb location" + ChatColor.GRAY + ChatColor.ITALIC + "  Commands/info about Locations");
			p.sendMessage(ChatColor.RED + "/eb timers" + ChatColor.GRAY + ChatColor.ITALIC + "  Commands/info about Timers");
			p.sendMessage(ChatColor.RED + "/eb bossegg" + ChatColor.GRAY + ChatColor.ITALIC + "  Commands/info about bossegg");
			p.sendMessage(ChatColor.RED + "/eb reload" + ChatColor.GRAY + ChatColor.ITALIC + "    Reload changes in Bosses.yml");
		}
		if(args.length >= 1)
		{
			if(args[0].equals("reload"))
			{
				eb.loadconfig.LoadBosses();
				p.sendMessage(ChatColor.GREEN + "EpicBoss reloded!");
			}
			else if(args[0].equals("boss"))
			{
				bosses.Command(p, cmd, commandlabel, args);
			}
			else if(args[0].equals("bossegg"))
			{
				bossegg.Command(p, cmd, commandlabel, args);
			}
			else if(args[0].equals("timers"))
			{
				timer.Command(p, cmd, commandlabel, args);
			}
			else if(args[0].equals("location"))
			{
				location.Command(p, cmd, commandlabel, args);
			}
			else
			{
				p.sendMessage(s);
				p.sendMessage(ChatColor.RED + "/eb boss" + ChatColor.GRAY + ChatColor.ITALIC + "   Commands/info about Bosses");
				p.sendMessage(ChatColor.RED + "/eb location" + ChatColor.GRAY + ChatColor.ITALIC + "  Commands/info about Locations");
				p.sendMessage(ChatColor.RED + "/eb timers" + ChatColor.GRAY + ChatColor.ITALIC + "  Commands/info about Timers");
				p.sendMessage(ChatColor.RED + "/eb bossegg" + ChatColor.GRAY + ChatColor.ITALIC + "  Commands/info about bossegg");
				p.sendMessage(ChatColor.RED + "/eb reload" + ChatColor.GRAY + ChatColor.ITALIC + "    Reload changes in Bosses.yml");
			}
		}
	}
}
