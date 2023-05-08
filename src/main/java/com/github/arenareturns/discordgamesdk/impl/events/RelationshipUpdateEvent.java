package com.github.arenareturns.discordgamesdk.impl.events;

import com.github.arenareturns.discordgamesdk.Core;
import com.github.arenareturns.discordgamesdk.impl.Command;
import com.github.arenareturns.discordgamesdk.impl.DataProxies;
import com.github.arenareturns.discordgamesdk.impl.EventHandler;

public class RelationshipUpdateEvent
{
	public static class Handler extends EventHandler<DataProxies.RelationshipImpl>
	{
		public Handler(Core.CorePrivate core)
		{
			super(core);
		}

		@Override
		public void handle(Command command, DataProxies.RelationshipImpl data)
		{
			core.relationships.put(data.user.getUserId(), data.toRelationship());
			core.getEventAdapter().onRelationshipUpdate(data.toRelationship());
		}

		@Override
		public Class<?> getDataClass()
		{
			return DataProxies.RelationshipImpl.class;
		}
	}
}
