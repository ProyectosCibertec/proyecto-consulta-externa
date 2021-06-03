package models;

public class District {

	private String idDistrict;
	private String isoDistrict;
	private String districtDescription;

	public District() {

	}

	public District(String idDistrict, String isoDistrict, String districtDescription) {
		this.idDistrict = idDistrict;
		this.isoDistrict = isoDistrict;
		this.districtDescription = districtDescription;
	}

	public String getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(String idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getIsoDistrict() {
		return isoDistrict;
	}

	public void setIsoDistrict(String isoDistrict) {
		this.isoDistrict = isoDistrict;
	}

	public String getDistrictDescription() {
		return districtDescription;
	}

	public void setDistrictDescription(String districtDescription) {
		this.districtDescription = districtDescription;
	}
}
