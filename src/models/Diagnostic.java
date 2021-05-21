package models;

public class Diagnostic {
	
	private String idDiagnostic;
	private String diagnosticName;
	private String diagnosticDescription;
	
	public Diagnostic() {

	}

	public Diagnostic(String idDiagnostic, String diagnosticName, String diagnosticDescription) {
		this.idDiagnostic = idDiagnostic;
		this.diagnosticName = diagnosticName;
		this.diagnosticDescription = diagnosticDescription;
	}

	public String getIdDiagnostic() {
		return idDiagnostic;
	}

	public void setIdDiagnostic(String idDiagnostic) {
		this.idDiagnostic = idDiagnostic;
	}

	public String getDiagnosticName() {
		return diagnosticName;
	}

	public void setDiagnosticName(String diagnosticName) {
		this.diagnosticName = diagnosticName;
	}

	public String getDiagnosticDescription() {
		return diagnosticDescription;
	}

	public void setDiagnosticDescription(String diagnosticDescription) {
		this.diagnosticDescription = diagnosticDescription;
	}
}
