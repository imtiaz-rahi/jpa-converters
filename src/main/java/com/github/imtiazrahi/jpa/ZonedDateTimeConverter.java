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
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts {@link ZonedDateTime} to {@link Timestamp} and back. <br>
 * NOTE: we may lose timezone offset with some database; e.g. PostgreSQL
 * 
 * @author Imtiaz Rahi
 * @since 2016-03-04
 * @see <a href="https://github.com/marschall/threeten-jpa">ThreeTen JPA</a>
 * @see <a href="https://bitbucket.org/montanajava/jpaattributeconverters">Using the Java 8 Date Time Classes with JPA!</a>
 */
@Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(ZonedDateTime attr) {
		return attr == null ? null : Timestamp.from(attr.toInstant());
	}

	@Override
	public ZonedDateTime convertToEntityAttribute(Timestamp data) {
		return data == null ? null : data.toInstant().atZone(ZoneId.systemDefault());
	}
}
