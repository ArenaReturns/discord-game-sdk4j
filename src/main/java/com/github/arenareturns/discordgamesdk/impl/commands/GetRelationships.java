package com.github.arenareturns.discordgamesdk.impl.commands;

import com.github.arenareturns.discordgamesdk.impl.DataProxies;

import java.util.List;

public class GetRelationships
{
	private GetRelationships() {}

	public class Response
	{
		private List<DataProxies.RelationshipImpl> relationships;

		public List<DataProxies.RelationshipImpl> getRelationships()
		{
			return relationships;
		}
	}
}
