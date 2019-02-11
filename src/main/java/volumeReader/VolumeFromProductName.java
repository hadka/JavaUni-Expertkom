package volumeReader;

public class VolumeFromProductName {
	
	Double volume;
	String volumeUnit;

	public VolumeFromProductName(Double volume, String volumeUnit) {
		super();
		this.volume = volume;
		this.volumeUnit = volumeUnit;
	}

	public VolumeFromProductName() {
		super();
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getVolumeUnit() {
		return volumeUnit;
	}

	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	@Override
	public String toString() {
		return "VolumeFromProductName [volume=" + volume + ", volumeUnit=" + volumeUnit + "]";
	}
}
