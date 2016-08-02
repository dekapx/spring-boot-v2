package com.dimensiondata.cloud.monitoring;

import java.io.Serializable;

public class Event implements Serializable {
	private int eventId;
	private String eventType;

	public Event(final int eventId, final String eventType) {
		this.eventId = eventId;
		this.eventType = eventType;
	}

	public int getEventId() {
		return eventId;
	}

	public String getEventType() {
		return eventType;
	}

	@Override
	public String toString() {
		return "[ " + eventId + " - " + eventType + " ]";
	}
}
