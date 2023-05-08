package com.github.arenareturns.discordgamesdk.impl.commands;

import com.github.arenareturns.discordgamesdk.activity.Activity;

public class SetActivity
{
	private SetActivity() {}
	public static class Args
	{
		private int pid;
		private Activity activity;

		public Args(int pid, Activity activity)
		{
			this.pid = pid;
			this.activity = activity;
		}
	}
}
