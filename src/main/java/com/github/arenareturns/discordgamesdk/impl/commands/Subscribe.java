package com.github.arenareturns.discordgamesdk.impl.commands;

import com.github.arenareturns.discordgamesdk.impl.Command;

public class Subscribe
{
	private Subscribe() {}
	public static class Response
	{
		private Command.Event evt;

		public Command.Event getEvent()
		{
			return evt;
		}
	}
}
