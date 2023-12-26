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

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts {@link Instant} to {@link Timestamp} and back.
 * 
 * @author Imtiaz Rahi
 * @since 2017-05-26
 * @see <a href="http://www.thoughts-on-java.org/persist-localdate-Instant-jpa">Java 8 Instant in JPA</a>
 */
@Converter
public class InstantConverter implements AttributeConverter<Instant, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(Instant attr) {
		return attr == null ? null : Timestamp.from(attr);
	}

	@Override
	public Instant convertToEntityAttribute(Timestamp data) {
		return data == null ? null : data.toInstant();
	}
}
