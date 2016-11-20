/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Playlist.PlaylistDAO;
import Playlist.PlaylistDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author Phong
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/javascript;charset=UTF-8");

        String callBackMethods = request.getParameter("callback");
        
        try (PrintWriter out = response.getWriter()) {
                
                JSONArray jArray = new JSONArray();
                List<PlaylistDTO> topPlaylist = new PlaylistDAO().getTopPlaylists();
                
                for(PlaylistDTO playlist : topPlaylist){
                    UserDTO user = new UserDAO().loadByID(playlist.getID_User());
                    jArray.add(getJson(playlist,user));
                }
                out.append(callBackMethods);
                out.append("("+jArray.toJSONString()+");");
            out.flush();
        } catch (SQLException ex) {
            Logger.getLogger(SongServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SongServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SongServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private JSONObject getJson(PlaylistDTO playlist,UserDTO user) {
        JSONObject jObj = new JSONObject();
        
        jObj.put("id", playlist.getID());
        jObj.put("name",playlist.getName());
        jObj.put("likes", playlist.getNumOfLike());
        jObj.put("listen", playlist.getNumOfListen());
        jObj.put("username", user.getUsername());
        
        return jObj;
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
