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

import java.time.ZoneId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts {@link ZoneId} to string and back.
 * 
 * @author Imtiaz Rahi
 * @since 2017-05-26
 */
@Converter
public class ZoneIdConverter implements AttributeConverter<ZoneId, String> {

	@Override
	public String convertToDatabaseColumn(ZoneId attr) {
		return attr == null ? null : attr.toString();
	}

	@Override
	public ZoneId convertToEntityAttribute(String data) {
		return data == null ? null : ZoneId.of(data);
	}

}
