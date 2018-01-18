package com.blackliao.bean;

public class Channel {

	private int channelID;
	private String channelName;

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public String toString() {
		return "Channel [channelID=" + channelID + ", channelName=" + channelName + "]";
	}

}
