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

import java.time.Duration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author Imtiaz Rahi
 * @since 2017-05-26
 */
@Converter(autoApply = true)
public class DurationToStringConverter implements AttributeConverter<Duration, String> {

	@Override
	public String convertToDatabaseColumn(Duration attr) {
		return attr == null ? null : attr.toString();
	}

	@Override
	public Duration convertToEntityAttribute(String data) {
		return data == null ? null : Duration.parse(data);
	}

}
