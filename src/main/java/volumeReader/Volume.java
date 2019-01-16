package volumeReader;

public class Volume {
	
	Double volume;
	String volumeUnit;

	public Volume(Double volume, String volumeUnit) {
		super();
		this.volume = volume;
		this.volumeUnit = volumeUnit;
	}

	public Volume() {
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
		return "Volume [volume=" + volume + ", volumeUnit=" + volumeUnit + "]";
	}
}
