
package Servlet;

import Entity.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "PersonServlet", urlPatterns =
  {
    "/PersonServlet"
  })
public class PersonServlet extends HttpServlet
{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Person> makePersons()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a","b","1"));
        persons.add(new Person("c","d","2"));
        persons.add(new Person("f","g","3"));
        persons.add(new Person("t","h","4"));
       
        return persons;
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
          {
                List<Person> persons = makePersons();
                out.println(gson.toJson(persons));
          }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }


}
