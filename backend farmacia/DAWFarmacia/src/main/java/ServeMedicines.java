import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class ServeMedicines
 */
@WebServlet("/ServeMedicines")
public class ServeMedicines extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServeMedicines() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String session = request.getParameter("session");

        Doctor doctor = new Doctor();
        boolean isLogged = doctor.isLogged(mail, session);

        if (isLogged) {
            doctor.load(mail);
            
            String jsonString = null;
            JSONArray ja = new JSONArray();
            try {
            String query = "SELECT * FROM medicine;";
            BBDD bd = new BBDD();
            bd.conectar();
            ResultSet rs = bd.loadSelect(query);

            
                while (rs.next()) {
                	Medicine m = new Medicine();
                	m.setName(rs.getString("name"));
                	m.setId(rs.getInt("id"));
                    JSONObject mjson = new JSONObject(m);
                    ja.put(mjson);
                }
                jsonString = ja.toString();
            } catch (SQLException e) {
               System.out.println("Error en el ServePatients.doget: " + e.getMessage());
            }
            response.getWriter().append(jsonString);

           
        } else {
            System.out.println("El usuario no está loggeado");
        }
    }


}
