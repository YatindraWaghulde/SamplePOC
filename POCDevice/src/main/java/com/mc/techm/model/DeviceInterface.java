package com.mc.techm.model;

import java.util.List;
import java.util.Optional;

public interface DeviceInterface {

	public Optional<DeviceDetails> getDevice(int deviceId);
	public List<DeviceDetails> getAllDevices();
	public void addDevice(DeviceDetails device);
	public void updateDevice(DeviceDetails device,int deviceId);
	public void deleteDevice(int deviceId);
	
}
