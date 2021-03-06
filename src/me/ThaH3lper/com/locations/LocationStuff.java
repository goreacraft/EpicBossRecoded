package me.ThaH3lper.com.locations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.ThaH3lper.com.EpicBoss;

public class LocationStuff {
	EpicBoss eb;
	public LocationStuff(EpicBoss neweb)
	{
		eb = neweb;
		loadLocation();
		saveLocation();
	}
	
	public void addLocation(String name, Location l)
	{
		eb.LocationList.add(new Locations(l, name, l.getWorld().getName()));
		saveLocation();
	}
	
	public void removeLocation(String name)
	{
		if(eb.LocationList != null)
		{
			int i = 0;
			while(i < eb.LocationList.size())
			{
				if(eb.LocationList.get(i).getName().equals(name))
				{
					eb.LocationList.remove(i);
					saveLocation();
				}
				i++;
			}
		}
	}
	
	public void loadLocation()
	{
		if(eb.SavedData.getCustomConfig().contains("Location"))
		{
			if(eb.SavedData.getCustomConfig().getStringList("Location") != null)
			{
				for(String s : eb.SavedData.getCustomConfig().getStringList("Location"))
				{
					String[] Splits = s.split(":");

					String name = Splits[0];
					Location l = new Location(Bukkit.getWorld(Splits[1]), Double.parseDouble(Splits[2]), Double.parseDouble(Splits[3]), Double.parseDouble(Splits[4]));
					
					eb.LocationList.add(new Locations(l, name, Splits[1]));
				}
			}
		}
	}
	
	public void saveLocation()
	{
		if(eb.LocationList != null)
		{
			List<String> saved = new ArrayList<String>();
			for(Locations loc : eb.LocationList)
			{
				String save = loc.getName() + ":" + loc.getWorldName() + ":" + ((int) loc.getLocation().getX()) + ":" + ((int) loc.getLocation().getY()) + ":" + ((int) loc.getLocation().getZ());
				saved.add(save);
			}
			eb.SavedData.reloadCustomConfig();
			eb.SavedData.getCustomConfig().set("Location", saved);
			eb.SavedData.saveCustomConfig();
		}
	}
	public boolean locationExict(String name)
	{
		if(eb.LocationList != null)
		{
			for(Locations loc : eb.LocationList)
			{
				if(loc.getName().equals(name))
				{
					return true;
				}
			}
		}
		return false;
	}
	public Player getPlayer(String name)
	{
			for(Player p : Bukkit.getServer().getOnlinePlayers())
			{
				if(p.getName().equals(name))
				{
					return p;
				}
			}
		return null;
	}
	public Locations getLocations(String name)
	{
		if(eb.LocationList != null)
		{
			for(Locations loc : eb.LocationList)
			{
				if(loc.getName().equals(name))
				{
					return loc;
				}
			}
		}
		return null;
	}
}
