package com.katas.question13;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadIdWithoutThreadLocal {
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// Thread local variable containing each thread's ID
	private static final Integer threadId = nextId.getAndIncrement();

	// Returns the current thread's unique ID, assigning it if necessary
	public static int get() {
		return threadId.intValue();
	}
}

