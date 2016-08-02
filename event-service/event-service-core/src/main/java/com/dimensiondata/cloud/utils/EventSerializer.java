package com.dimensiondata.cloud.utils;

import com.dimensiondata.cloud.monitoring.Event;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class EventSerializer implements Serializer<Event> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(final String topic, final Event data) {
		try {
			byte[] serializedName;
			int stringSize;
			if (data == null)
				return null;
			else {
				if (data.getEventType() != null) {
					serializedName = data.getEventType().getBytes("UTF-8");
					stringSize = serializedName.length;
				} else {
					serializedName = new byte[0];
					stringSize = 0;
				}
			}
			final ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
			buffer.putInt(data.getEventId());
			buffer.putInt(stringSize);
			buffer.put(serializedName);
			return buffer.array();
		} catch (Exception e) {
			throw new SerializationException("Error when serializing Event to byte[] " + e);
		}
	}

	@Override
	public void close() {
	}

}
