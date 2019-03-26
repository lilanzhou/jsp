package com.ryan.control;

import com.ryan.service.UserServiceImpl;
import com.ryan.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019:03:23
 *
 * @Author : Lilanzhou
 * 功能 :
 */
@WebServlet(name = "ServletImpl", urlPatterns = {"/user"},
        initParams = {@WebInitParam(name = "show", value = "show.jsp"),
                      @WebInitParam(name = "query", value = "/user?action=queryAll")

})
public class ServletImpl extends HttpServlet {
    private UserServiceImpl service = new UserServiceImpl();
    private Map<String, String> map = new HashMap<>();
    private RequestDispatcher dispatcher=null;
    boolean flag=false;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        map.put("query", config.getInitParameter("query"));
        map.put("show", config.getInitParameter("show"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action=request.getParameter("action");
        switch (action){
            case "queryAll":
                List<User>list=service.queryAll();
                request.setAttribute("list",list);
                dispatcher=request.getRequestDispatcher(map.get("show"));
                dispatcher.forward(request,response);
                break;
            case "add":
                User user=new User();
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                String updateById=request.getParameter("id");
                if(updateById!=""){
                    user.setId(Integer.parseInt(updateById));
                    flag=service.updateByQueryId(user);
                }else {
                    flag = service.add(user);
                }
                if (flag){
                    response.sendRedirect(map.get("query"));
                }
                break;
            case "delete":
                String id=request.getParameter("id");
                flag=service.deleteById(Integer.parseInt(id));
                if(flag){
                    response.sendRedirect(map.get("query"));
                }
                break;
            case "edit":
                String id1=request.getParameter("id");
                while (id1!=null){
                    User user1=service.queryId(Integer.parseInt(id1));
                    request.setAttribute("username",user1.getUsername());
                    request.setAttribute("password",user1.getPassword());
                    request.setAttribute("id",user1.getId());
                    dispatcher=request.getRequestDispatcher(map.get("query"));
                    dispatcher.forward(request,response);
                }

        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
