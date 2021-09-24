package com.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
//import javax.servlet.jsp.JspFactory;
//import javax.servlet.jsp.PageContext;
//import javax.servlet.jsp.tagext.BodyContent;


/**
 * Servlet implementation class Check
 */
@WebServlet("/imgvarify.ano")
public class ImgvarifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 60;// 设置验证码图片宽度
	private static final int HEIGHT = 20;// 设置验证码图片高度
	private static final int LENGTH = 4;// 设置验证码长度
	// 设置验证码随机出现的字符
	private static final String str = "1234567890" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	char[] chars = str.toCharArray();// 将字符放在数组中方便随机读取
	private static Random random = new Random();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImgvarifyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置输出的类型为图片
		// response.setContentType("text/html;charset=utf-8");
		response.setContentType("image/jpeg");

		// 设置不进行缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		// 指定宽高
		// BufferedImage.TYPE_3BYTE_BGR指定使用的颜色为RGB模式

		// 画笔
		Graphics graphics = image.getGraphics();

		// 设置背景颜色并绘制矩形背景
		graphics.setColor(Color.WHITE);

		// 指定生成的图形为矩形框
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
//		graphics.setFont(new Font("", Font.PLAIN, 20));
		graphics.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		// 用于记录生成的验证码
		String safeCode = "";

		// 生成验证码并绘制
		for (int i = 0; i < LENGTH; i++) { // 设置验证码长度
			String c = "" + chars[random.nextInt(str.length())];
			graphics.setColor(getColor());

			graphics.drawString(c, 10 * i + 10, 18);
			// 在画布上坐标位置为 10*i+10,18的地方画
			safeCode += c;
		}

		// 生成干扰点
		for (int i = 0; i < 50; i++) {
			graphics.setColor(getColor());
			graphics.drawOval(random.nextInt(60), random.nextInt(20), 1, 1);
		}
		/*
		 * drawOval(int x,int y,int width,int height)：
		 * 是画用线围成的椭圆形。其中参数x和参数y指定椭圆形左上角的位置，参数width和height是横轴和纵轴。
		 */

		HttpSession session = request.getSession();

		// 将生成的验证码存入session中，以便进行校验
//		 if (!request.getSession().isNew()){
//             session.invalidate();
//             session = request.getSession(true);
		//   log.debug("new Session:" + session.getId());
//         }
//		保存验证码到会话中
		session.setAttribute("varifycode", safeCode);
		System.out.println("varifycode=" + session.getAttribute("varifycode"));
		// 绘制图片
		graphics.dispose();

		// 将图片输出到response中
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	private Color getColor() { // 生成随机颜色
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
