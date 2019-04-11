import com.mycompany.personas.Controlador;
import com.mycompany.personas.ImagenGenerador;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Franco Morbidoni
 */
@WebServlet(urlPatterns = {"/agregar"})
@MultipartConfig
public class agregar extends HttpServlet {
Controlador controlador = new Controlador();
ImagenGenerador imagenGenerador = new ImagenGenerador();
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
            String foto="";
            int dni = Integer.valueOf(request.getParameter("dni"));
            String nombre=request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int edad = Integer.valueOf(request.getParameter("edad"));
            Part filePart = request.getPart("foto");
            if (filePart.getSize()==0) {
                foto="Sin foto.";
            }else{
                InputStream fileContent = filePart.getInputStream();
                Image image = ImageIO.read(fileContent);
                BufferedImage bi = imagenGenerador.createResizedCopy(image, 150, 150, true);
                foto=imagenGenerador.encodeToString(bi, "png");
            }
            String resp = controlador.Agregar(dni,nombre,apellido,edad,foto);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + resp + "</h1>");
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
