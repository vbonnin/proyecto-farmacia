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

@WebServlet("/ServePatients")
public class ServePatients extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServePatients() {
        super();
    }

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
            String query = "SELECT * FROM patient;";
            BBDD bd = new BBDD();
            bd.conectar();
            ResultSet rs = bd.loadSelect(query);

            
                while (rs.next()) {
                    String patientMail = (rs.getString("mail"));
                    ja.put(patientMail);
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
