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

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts {@link LocalDate} to {@link Date} and back.
 * 
 * @author Imtiaz Rahi
 * @since 2016-09-05
 * @see <a href="http://www.adam-bien.com/roller/abien/entry/new_java_8_date_and">New Java 8 Date and JPA 2.1 Integration</a>
 * @see <a href="http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa">Java 8 LocalDateTime in JPA</a>
 * @see <a href="https://github.com/marschall/threeten-jpa/tree/master/threeten-jpa/src/main/java/com/github/marschall/threeten/jpa>ThreeTen JPA</a>
 */
@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attr) {
		return attr == null ? null : Date.valueOf(attr);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date data) {
		return data == null ? null : data.toLocalDate();
	}
}
