package kece.domain.events;

import java.time.OffsetDateTime;

public abstract class Event {
	
	private final OffsetDateTime timestamp = OffsetDateTime.now();

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}
	
}
