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
 * This object contains the meta data and holds the data.
 *
 * @author Udo Held
 */
public class SensorData {

  @SerializedName("d")
  private DataHolder[] data;

  @SerializedName("clientid")
  private String client;

  @SerializedName("timestamp")
  private Long transferTimeStamp;

  @SerializedName("topic")
  private String mqttTopic;

  public DataHolder[] getData() {
    return data;
  }

  public void setData(DataHolder[] data) {
    this.data = data;
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }

  public Long getTransferTimeStamp() {
    return transferTimeStamp;
  }

  public void setTransferTimeStamp(Long transferTimeStamp) {
    this.transferTimeStamp = transferTimeStamp;
  }

  public String getMqttTopic() {
    return mqttTopic;
  }

  public void setMqttTopic(String mqttTopic) {
    this.mqttTopic = mqttTopic;
  }
}
