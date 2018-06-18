package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("action: "+action);
		if("/quoto".equals(action)) {
			//模拟生成几只股票的信息
			List<Stock> stocks=new ArrayList<Stock>();
			Random rm=new Random();
			for(int i=0;i<5;i++) {
				Stock s=new Stock();
				s.setCode("2333"+rm.nextInt(30));
				s.setName("BILI"+rm.nextInt(30));
				s.setPrice(22.33+rm.nextInt(30));
				stocks.add(s);
			}
			ObjectMapper om=new ObjectMapper();
			String jsonStr=om.writeValueAsString(stocks);
			System.out.println(jsonStr);
			out.println(jsonStr);
		}else if("/getNumber".equals(action)) {
			Random r=new Random();
			int number=r.nextInt(9999);
			System.out.println("number: "+number);
			out.print(number);
		}else if("/saveInfo".equals(action)) {
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			System.out.println("name"+name+"phone"+phone+"address"+address);
			out.println("保存送货信息成功");
		}
	}

}
