import com.mycompany.personas.Controlador;
import com.mycompany.personas.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franco Morbidoni
 */
@WebServlet(urlPatterns = {"/listado_dni"})
public class listado_dni extends HttpServlet {
Controlador controlador = new Controlador();
    /**
     * Procesa los pedidos de los métodos GET y POST de la página.
     *
     * @param request pedido del servlet
     * @param response respuesta del servlet
     * @throws ServletException si el servlet provoca un error.
     * @throws IOException si ocurre un problema con I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List <Persona> resp = controlador.Listado(Integer.valueOf(request.getParameter("listaDni")));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listado_dni</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado filtrado por DNI:</h1>");
            for (Persona persona : resp) {
               out.println(persona.getDNI() +" | " +persona.getNombre()+" | "+persona.getApellido()+" | "+persona.getEdad()+" |    ");
               if (persona.getFoto().equals("Sin foto.")) {
                   out.print(persona.getFoto()+"<br>");
               }else{
                  String encoding = "data:image/png;base64," + persona.getFoto();
                   out.print("<img src=\"" + encoding +"\" alt=\"Foto no encontrada.\" height=\"150\" width=\"150\"><br>");
               }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
