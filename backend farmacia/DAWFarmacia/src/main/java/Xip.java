import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Xip {

	private int id;
	private Medicine medicine;
	private Patient patient;
	private Date date;
	
	public Xip() {
		
	}
	
	public Xip(int id, Medicine medicine, Patient patient, Date date) {
		this.id = id;
		this.medicine = medicine;
		this.patient = patient;
		this.date=date;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void load(int id) {
		String query = "SELECT * FROM xip WHERE id = '" +id+"';";
		BBDD bd = new BBDD();
		bd.conectar();
		ResultSet rs = bd.loadSelect(query);
		
		try {
			while(rs.next()) {
				this.id = rs.getInt("id");
				// guardamos el paciente
				this.patient = new Patient();
				this.patient.load(rs.getString("id_patient"));
				// guardamos el medicamento
				this.medicine = new Medicine();
				this.medicine.load(rs.getInt("id_medicine"));
				this.date = rs.getDate("date");
				
			}
		} catch (SQLException e) {
			System.out.println("Error a Xip.load: " + e.getMessage());
		}
	}
}
