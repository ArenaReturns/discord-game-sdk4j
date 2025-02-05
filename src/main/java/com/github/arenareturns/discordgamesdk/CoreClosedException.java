package com.github.arenareturns.discordgamesdk;

/**
 * Exception which is thrown when attempting to execute an SDK operation
 * when the {@link Core} has been closed.
 */
public class CoreClosedException extends IllegalStateException
{
	public CoreClosedException()
	{
		super("Core is closed");
	}
}
