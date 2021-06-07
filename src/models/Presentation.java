package models;

public class Presentation {
	private String idPresentation;
	private String presentationName;
	private String presentationQuantity;
	
	public Presentation() {

	}

	public Presentation(String idPresentation, String presentationName, String presentationQuantity) {
		this.idPresentation = idPresentation;
		this.presentationName = presentationName;
		this.presentationQuantity = presentationQuantity;
	}

	public String getIdPresentation() {
		return idPresentation;
	}

	public void setIdPresentation(String idPresentation) {
		this.idPresentation = idPresentation;
	}

	public String getPresentationName() {
		return presentationName;
	}

	public void setPresentationName(String presentationName) {
		this.presentationName = presentationName;
	}

	public String getPresentationQuantity() {
		return presentationQuantity;
	}

	public void setPresentationQuantity(String presentationQuantity) {
		this.presentationQuantity = presentationQuantity;
	}
}
