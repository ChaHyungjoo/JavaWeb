import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.newlecture.javaweb.entity.Notice;


@WebServlet("/notice")
public class Nana extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
	   response.setCharacterEncoding("UTF-8");
	   response.setContentType("text/html; charset=UTF-8");
	   
	   String title = request.getParameter("title");
	   
//	   -----------------------------------------------------------------------------------------------------------
	   List<Notice> list;
	   
	   PrintWriter out = response.getWriter();

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM Notice WHERE title LIKE ?";

		// jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 /인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+title+"%");

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// Model--------------------------------------------------------------------------------------
			list = new ArrayList<Notice>();

			while (rs.next()) {
				Notice n = new Notice();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setContent(rs.getString("CONTENT"));
				n.setHit(rs.getInt("HIT"));
				list.add(n);
			}

			rs.close();
			st.close();
			con.close();
			
			// view--------------------------------------------------------------------------------------
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action=\"notice\" method=\"get\">");
			out.println("<label>검색어</label>");
			out.println("<input type=\"text\" name=\"title\"/>");
			out.println("<input type=\"submit\" />");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
			for (Notice n : list)
				out.println(n.getTitle() + "<br />");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
      
   }
}