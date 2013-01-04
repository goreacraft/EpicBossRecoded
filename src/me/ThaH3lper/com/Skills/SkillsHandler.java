package me.ThaH3lper.com.Skills;


import java.util.ArrayList;
import java.util.List;

import me.ThaH3lper.com.EpicBoss;
import me.ThaH3lper.com.Boss.Boss;
import me.ThaH3lper.com.Skills.AllSkills.Swarm;
import me.ThaH3lper.com.Skills.AllSkills.Throw;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkillsHandler {
	public EpicBoss eb;
	public Swarm swarm;
	public Throw throwplayer;
	
	//Constructors
	
	public SkillsHandler(EpicBoss boss)
	{
		eb = boss;
		swarm = new Swarm(eb);
		throwplayer = new Throw(eb);
	}
	public void skills(Boss b)
	{
		List<String> skills = b.getSkill();
		if(skills != null)
		{
			int index = 0;
			for(String s : skills)
			{
				String[] parts = s.split(" ");
				if(parts[0].equals("swarm"))
				{
					swarm.executeSwarm(s, b, index);
				}
				if(parts[0].equals("throw"))
				{
					throwplayer.executeThrow(s, b, index);
				}
				index++;
			}
		}
	}
	public List<Player> getPlayersRadious(int radious, Boss b)
	{
		List<Player> playerlist = new ArrayList<Player>();
		for(Player p: Bukkit.getOnlinePlayers())
		{
			if(b.getLocation().distance(p.getLocation()) < radious)
			{
				playerlist.add(p);
			}
		}
		return playerlist;
		
	}
}