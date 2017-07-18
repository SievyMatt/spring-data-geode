/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.gemfire.test.mock;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import org.mockito.stubbing.Answer;

/**
 * The {@link MockObjectsSupport} class is an abstract base class encapsulating common operations and utilities
 * used in mocking using Mockito.
 *
 * @author John Blum
 * @since 2.0.0
 */
@SuppressWarnings("unused")
public abstract class MockObjectsSupport {

	/* (non-Javadoc) */
	protected static Answer<Boolean> newGetter(AtomicBoolean returnValue) {
		return invocation -> returnValue.get();
	}

	/* (non-Javadoc) */
	protected static Answer<Integer> newGetter(AtomicInteger returnValue) {
		return invocation -> returnValue.get();
	}

	/* (non-Javadoc) */
	protected static Answer<Long> newGetter(AtomicLong returnValue) {
		return invocation -> returnValue.get();
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newGetter(AtomicReference<R> returnValue) {
		return invocation -> returnValue.get();
	}

	/* (non-Javadoc) */
	protected static <R, S> Answer<S> newGetter(AtomicReference<R> returnValue, Function<R, S> converter) {
		return invocation -> converter.apply(returnValue.get());
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newSetter(AtomicBoolean argument, R returnValue) {
		return invocation -> {
			argument.set(invocation.getArgument(0));
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newSetter(AtomicBoolean argument, Boolean value, R returnValue) {
		return invocation -> {
			argument.set(value);
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newSetter(AtomicInteger argument, R returnValue) {
		return invocation -> {
			argument.set(invocation.getArgument(0));
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newSetter(AtomicInteger argument, Integer value, R returnValue) {
		return invocation -> {
			argument.set(value);
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newSetter(AtomicLong argument, R returnValue) {
		return invocation -> {
			argument.set(invocation.getArgument(0));
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <R> Answer<R> newSetter(AtomicLong argument, Long value, R returnValue) {
		return invocation -> {
			argument.set(value);
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <T, R> Answer<R> newSetter(AtomicReference<T> argument, R returnValue) {
		return invocation -> {
			argument.set(invocation.getArgument(0));
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <T, R> Answer<R> newSetter(AtomicReference<T> argument, T value, R returnValue) {
		return invocation -> {
			argument.set(value);
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <T, R> Answer<R> newSetter(AtomicReference<T> argument, Function<?, T> converter, R returnValue) {
		return invocation -> {
			argument.set(converter.apply(invocation.getArgument(0)));
			return returnValue;
		};
	}

	/* (non-Javadoc) */
	protected static <K, V, R> Answer<R> newSetter(Map<K, V> argument, R returnValue) {
		return invocation -> {
			argument.put(invocation.getArgument(0), invocation.getArgument(1));
			return returnValue;
		};
	}
}
