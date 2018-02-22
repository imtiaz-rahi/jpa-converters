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
package com.github.imtiazrahi.jpa;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link LocalDateTime} to {@link Timestamp} and back.
 * 
 * @author Imtiaz Rahi
 * @since 2016-09-05
 * @see <a href="http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa">Java 8 LocalDateTime in JPA</a>
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attr) {
		return attr == null ? null : Timestamp.valueOf(attr);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp data) {
		return data == null ? null : data.toLocalDateTime();
	}
}
