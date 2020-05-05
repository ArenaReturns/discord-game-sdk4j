package de.jcm.discordgamesdk;

import de.jcm.discordgamesdk.activity.Activity;
import de.jcm.discordgamesdk.activity.ActivityActionType;
import de.jcm.discordgamesdk.activity.ActivityJoinRequestReply;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * Manager to control the player's current activity.
 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities">
 *     https://discordapp.com/developers/docs/game-sdk/activities</a>
 */
public class ActivityManager
{
	private final Core core;
	private final long pointer;

	ActivityManager(Core core, long pointer)
	{
		this.core = core;
		this.pointer = pointer;
	}

	/**
	 * Registers a command for Discord to use to launch your game.
	 * @param command Custom protocol URL or path to an executable (including options arguments)
	 * @return The {@link Result} of the operation
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#registercommand">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#registercommand</a>
	 */
	public Result registerCommand(String command)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		return registerCommand(pointer, command);
	}

	/**
	 * <p>Registers a Steam launch for your game.</p>
	 * <p>The registered URI is steam://run-game-id/&lt;id&gt;</p>
	 * @param steamId Steam ID of your game
	 * @return The {@link Result} of the operation
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#registersteam">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#registersteam</a>
	 */
	public Result registerSteam(int steamId)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		return registerSteam(pointer, steamId);
	}

	/**
	 * <p>Updates the user's current presence to a new activity.</p>
	 * <p>The {@link Core#DEFAULT_CALLBACK} is used to handle the returned {@link Result}.</p>
	 * @param activity New activity for the user.
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#updateactivity">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#updateactivity</a>
	 */
	public void updateActivity(Activity activity)
	{
		updateActivity(activity, Core.DEFAULT_CALLBACK);
	}

	/**
	 * <p>Updates the user's current presence to a new activity.</p>
	 * <p>A custom callback is used to handle the returned {@link Result}.</p>
	 * @param activity New activity for the user.
	 * @param callback Callback to process the returned {@link Result}.
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#updateactivity">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#updateactivity</a>
	 */
	public void updateActivity(Activity activity, @NotNull Consumer<Result> callback)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		updateActivity(pointer, activity.getPointer(), callback);
	}

	/**
	 * <p>Clears the user's current presence.</p>
	 * <p>The {@link Core#DEFAULT_CALLBACK} is used to handle the returned {@link Result}.</p>
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#clearactivity">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#clearactivity</a>
	 */
	public void clearActivity()
	{
		clearActivity(Core.DEFAULT_CALLBACK);
	}

	/**
	 * <p>Clears the user's current presence.</p>
	 * <p>A custom callback is used to handle the returned {@link Result}.</p>
	 * @param callback Callback to process the returned {@link Result}.
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#clearactivity">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#clearactivity</a>
	 */
	public void clearActivity(@NotNull Consumer<Result> callback)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		clearActivity(pointer, callback);
	}

	/**
	 * <p>Replies to an "Ask to join" request.</p>
	 * <p>The {@link Core#DEFAULT_CALLBACK} is used to handle the returned {@link Result}.</p>
	 * @param userId ID of user who asked to join
	 * @param reply Type of reply to send
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#sendrequestreply">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#sendrequestreply</a>
	 */
	public void sendRequestReply(long userId, ActivityJoinRequestReply reply)
	{
		sendRequestReply(userId, reply, Core.DEFAULT_CALLBACK);
	}

	/**
	 * <p>Replies to an "Ask to join" request.</p>
	 * <p>A custom callback is used to handle the returned {@link Result}.</p>
	 * @param userId ID of user who asked to join
	 * @param reply Type of reply to send
	 * @param callback Callback to process the returned {@link Result}.
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#sendrequestreply">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#sendrequestreply</a>
	 */
	public void sendRequestReply(long userId, ActivityJoinRequestReply reply, Consumer<Result> callback)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		sendRequestReply(pointer, userId, reply.ordinal(), callback);
	}

	/**
	 * <p>Invites a user to join your game.</p>
	 * <p>The {@link Core#DEFAULT_CALLBACK} is used to handle the returned {@link Result}.</p>
	 * @param userId ID of user to invite
	 * @param type Type of invitation to send
	 * @param content Content/message of the invitation
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#sendinvite">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#sendinvite</a>
	 */
	public void sendInvite(long userId, ActivityActionType type, String content)
	{
		sendInvite(userId, type, content, Core.DEFAULT_CALLBACK);
	}

	/**
	 * <p>Invites a user to join your game.</p>
	 * <p>A custom callback is used to handle the returned {@link Result}.</p>
	 * @param userId ID of user to invite
	 * @param type Type of invitation to send
	 * @param content Content/message of the invitation
	 * @param callback Callback to process the returned {@link Result}.
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#sendinvite">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#sendinvite</a>
	 */
	public void sendInvite(long userId, ActivityActionType type, String content, Consumer<Result> callback)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		sendInvite(pointer, userId, type.ordinal(), content, callback);
	}

	/**
	 * <p>Accepts a game invitation from another user.</p>
	 * <p>The {@link Core#DEFAULT_CALLBACK} is used to handle the returned {@link Result}.</p>
	 * @param userId ID of user to accept invitation from
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#acceptinvite">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#acceptinvite</a>
	 */
	public void acceptRequest(long userId)
	{
		acceptRequest(userId, Core.DEFAULT_CALLBACK);
	}

	/**
	 * <p>Accepts a game invitation from another user.</p>
	 * <p>A custom callback is used to handle the returned {@link Result}.</p>
	 * @param userId ID of user to accept invitation from
	 * @param callback Callback to process the returned {@link Result}.
	 * @see <a href="https://discordapp.com/developers/docs/game-sdk/activities#acceptinvite">
	 *     https://discordapp.com/developers/docs/game-sdk/activities#acceptinvite</a>
	 */
	public void acceptRequest(long userId, Consumer<Result> callback)
	{
		if(core.isClosed())
			throw new IllegalStateException("Core has been closed");

		acceptRequest(pointer, userId, callback);
	}

	private native Result registerCommand(long pointer, String command);
	private native Result registerSteam(long pointer, int steamId);
	private native void updateActivity(long pointer, long activityPointer, Consumer<Result> callback);
	private native void clearActivity(long pointer, Consumer<Result> callback);
	private native void sendRequestReply(long pointer, long userId, int reply, Consumer<Result> callback);
	private native void sendInvite(long pointer, long userId, int type, String content, Consumer<Result> callback);
	private native void acceptRequest(long pointer, long userId, Consumer<Result> callback);
}
