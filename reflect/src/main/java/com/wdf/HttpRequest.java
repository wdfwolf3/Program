package com.wdf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpRequest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\nio.txt"));
            String className = null;
            List<String> list = new ArrayList<>();
            while ((className = bufferedReader.readLine()) != null) {
                Class c = Class.forName(className);
                Object object = c.newInstance();
                list.add(className);
            }
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><title></title><body>" + Arrays.toString(list.toArray()) + "</body></html>");
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
