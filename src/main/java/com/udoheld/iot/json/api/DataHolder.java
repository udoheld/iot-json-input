/*
    Copyright 2017 the original author or authors.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this program. If not, see
    <http://www.gnu.org/licenses/>.
 */

package com.udoheld.iot.json.api;

import com.google.gson.annotations.SerializedName;

/**
 * This objects holds an actual data entry.
 *
 * @author Udo Held
 */
public class DataHolder {

  @SerializedName("bn")
  private String baseName;

  @SerializedName("bt")
  private Double baseTimeStamp;

  @SerializedName("v")
  private Double value;

  @SerializedName("n")
  private String name;

  @SerializedName("u")

  private String unit;

  public String getBaseName() {
    return baseName;
  }

  public void setBaseName(String baseName) {
    this.baseName = baseName;
  }

  public Double getBaseTimeStamp() {
    return baseTimeStamp;
  }

  public void setBaseTimeStamp(Double baseTimeStamp) {
    this.baseTimeStamp = baseTimeStamp;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
}
