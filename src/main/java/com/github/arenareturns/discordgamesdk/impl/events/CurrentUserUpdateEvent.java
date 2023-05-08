package com.github.arenareturns.discordgamesdk.impl.events;

import com.github.arenareturns.discordgamesdk.Core;
import com.github.arenareturns.discordgamesdk.user.DiscordUser;
import com.github.arenareturns.discordgamesdk.impl.Command;
import com.github.arenareturns.discordgamesdk.impl.EventHandler;

public class CurrentUserUpdateEvent
{
	public static class Handler extends EventHandler<DiscordUser>
	{
		public Handler(Core.CorePrivate core)
		{
			super(core);
		}

		@Override
		public void handle(Command command, DiscordUser user)
		{
			core.currentUser = user;
			core.getEventAdapter().onCurrentUserUpdate();
		}

		@Override
		public Class<?> getDataClass()
		{
			return DiscordUser.class;
		}

		@Override
		public boolean shouldRegister()
		{
			return false;
		}
	}
}
