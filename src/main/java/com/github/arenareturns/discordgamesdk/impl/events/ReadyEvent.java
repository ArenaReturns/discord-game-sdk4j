package com.github.arenareturns.discordgamesdk.impl.events;

import com.github.arenareturns.discordgamesdk.Core;
import com.github.arenareturns.discordgamesdk.user.DiscordUser;
import com.github.arenareturns.discordgamesdk.impl.Command;
import com.github.arenareturns.discordgamesdk.impl.EventHandler;

public class ReadyEvent
{
	public static class Data
	{
		int v;
		Config config;
		DiscordUser user;

		static class Config
		{
			String cdn_host;
			String api_endpoint;
			String environment;

			@Override
			public String toString()
			{
				return "Config{" +
						"cdn_host='" + cdn_host + '\'' +
						", api_endpoint='" + api_endpoint + '\'' +
						", environment='" + environment + '\'' +
						'}';
			}
		}

		@Override
		public String toString()
		{
			return "ReadyData{" +
					"v=" + v +
					", config=" + config +
					", user=" + user +
					'}';
		}
	}

	public static class Handler extends EventHandler<Data>
	{
		public Handler(Core.CorePrivate core)
		{
			super(core);
		}

		@Override
		public void handle(Command command, Data data)
		{
			core.ready();
			core.currentUser = data.user;
			core.workQueue.add(()->core.getEventAdapter().onCurrentUserUpdate());
		}

		@Override
		public Class<?> getDataClass()
		{
			return Data.class;
		}

		@Override
		public boolean shouldRegister()
		{
			return false;
		}
	}
}
