package com.randude14.hungergames.commands;

import com.randude14.hungergames.Defaults.Commands;
import com.randude14.hungergames.Defaults.Perm;
import com.randude14.hungergames.GameManager;
import com.randude14.hungergames.HungerGames;
import com.randude14.hungergames.utils.ChatUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PauseCommand extends SubCommand{

	@Override
	public boolean execute(CommandSender cs, Command cmd, String[] args) {
		Player player = (Player) cs;
		if (!HungerGames.checkPermission(player, Perm.ADMIN_PAUSE)) return true;

		if (args.length < 1) {
			ChatUtils.helpCommand(player, Commands.ADMIN_PAUSE.getUsage(), cmd.getLabel());
			return true;
		}

		game = GameManager.getGame(args[0]);
		if (game == null) {
		    ChatUtils.error(player, "%s does not exist.", args[0]);
		    return true;
		}

		if(game.pauseGame(player)) {
			ChatUtils.broadcast(true, "%s has been paused.", game.getName());
		}
		return true;
	}
    
}