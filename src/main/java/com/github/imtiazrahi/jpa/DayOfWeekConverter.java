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

import java.time.DayOfWeek;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * {@link DayOfWeek} to integer.
 * 
 * @author Imtiaz Rahi
 * @since 2017-05-26
 */
@Converter(autoApply = true)
public class DayOfWeekConverter implements AttributeConverter<DayOfWeek, Integer> {

	@Override
	public Integer convertToDatabaseColumn(DayOfWeek attr) {
		return attr == null ? null : attr.getValue();
	}

	@Override
	public DayOfWeek convertToEntityAttribute(Integer data) {
		return data == null ? null : DayOfWeek.of(data);
	}

}
