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

import java.sql.Time;
import java.time.LocalTime;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts {@link LocalTime} to {@link Time} and back. <br>
 * 
 * @author Imtiaz Rahi
 * @since 2017-05-26
 * @see <a href="https://github.com/marschall/threeten-jpa">ThreeTen JPA</a>
 * @see <a href="https://bitbucket.org/montanajava/jpaattributeconverters">Using the Java 8 Date Time Classes with JPA!</a>
 */
@Converter
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime attr) {
		return attr == null ? null : Time.valueOf(attr);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time data) {
		return data == null ? null : data.toLocalTime();
	}
}
