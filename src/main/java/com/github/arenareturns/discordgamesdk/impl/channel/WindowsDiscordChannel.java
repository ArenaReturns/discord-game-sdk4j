package com.github.arenareturns.discordgamesdk.impl.channel;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WindowsDiscordChannel implements DiscordChannel {
	private final FileChannel channel;
	private boolean blocking = true;

	public WindowsDiscordChannel() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("\\\\?\\pipe\\discord-ipc-0", "rw");
		channel = raf.getChannel();
	}

	public void close() throws IOException {
		channel.close();
	}

	public void configureBlocking(boolean block) throws IOException {
		blocking = block;
	}

	public int read(ByteBuffer dst) throws IOException {
		int res = 0;
		if (blocking || (channel.size() - channel.position()) >= dst.remaining())
		{
			res = channel.read(dst);
		}
		return res;
	}

	public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
		long res = 0;
		long remaining = 0;
		for (int i = offset; !blocking && i < offset+length; i++)
		{
			remaining += dsts[i].remaining();
		}
		if (blocking || (channel.size() - channel.position()) >= remaining)
		{
			res = channel.read(dsts, offset, length);
		}
		return res;
	}

	public int write(ByteBuffer src) throws IOException {
		int res = channel.write(src);
		channel.force(false); // ensure that data is actually written to file
		return res;
	}
}
