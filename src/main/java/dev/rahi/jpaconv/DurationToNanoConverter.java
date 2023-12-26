/*
 * Copyright (C) 2017 Imtiaz Rahi
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.rahi.jpaconv;

import java.time.Duration;

import jakarta.persistence.AttributeConverter;

/**
 * {@link Duration} to nano seconds
 * 
 * @author Imtiaz Rahi
 * @since 2017-05-26
 */
public class DurationToNanoConverter implements AttributeConverter<Duration, Long> {

	@Override
	public Long convertToDatabaseColumn(Duration attr) {
		return attr == null ? null : attr.toNanos();
	}

	@Override
	public Duration convertToEntityAttribute(Long data) {
		return data == null ? null : Duration.ofNanos(data);
	}

}
