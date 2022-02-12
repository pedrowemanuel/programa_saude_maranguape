package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdministradorBean;
import model.FuncionarioBean;
import model.UsuarioBean;
import model.UsuarioDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {
		"/acessarLoginAdmin",
		"/acessarLoginFuncionario",
		"/cidadaoSelecionarUnidade",
		"/fazerLogin",
		"/adminAcessarCadastroUnidade",
		"/adminCadastrarUnidade",
		"/adminAcessarListarUnidades",
		"/adminExcluirUnidade",
		"/adminAcessarCadastroFuncionarioAdmin",
		"/adminCadastrarFuncionarioAdmin",
		"/adminAcessarListarFuncionariosAdmin",
		"/adminExcluirFuncionario",
		"/funcionarioAdminAcessarCadastroFuncionario",
		"/funcionarioAdminCadastrarFuncionario",
		"/funcionarioAdminAcessarListarFuncionarios",
		"/funcionarioAdminAcessarCadastroPostagem",
		"/funcionarioAdminCadastrarPostagem",
		"/funcionarioAdminAcessarListarPostagens",
		"/funcionarioAdminExcluirPostagem",
		"/funcionarioAcessarCadastroPostagem",
		"/funcionarioCadastrarPostagem",
		"/funcionarioAcessarListarPostagens",
		"/funcionarioExcluirPostagem",
		"/cidadaoAcessarPostagens",
		"/cidadaoAcessarComentarios",
		"/cidadaoAcessarCadastroComentario",
		"/cidadaoCadastrarComentario",
		"/cidadaoCadastrarRespostaComentario",
		"/fazerLogout"
	})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		if (action.equals("/acessarLoginAdmin")) {
			request.setAttribute("tipoLogin", "admin");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		} else if (action.equals("/acessarLoginFuncionario")) {
			request.setAttribute("tipoLogin", "funcionario");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		} else if (action.equals("/cidadao/selecionarUnidade")) {
			response.sendRedirect("selecionarUnidade.html");
		}  else if (action.equals("/fazerLogin")) {
			fazerLogin(request, response);
		} else if (action.equals("/fazerLogout")) {
			fazerLogout(request,response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void fazerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UsuarioBean usuarioBean = new UsuarioBean(request.getParameter("email"), request.getParameter("senha"));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		UsuarioBean usuario = usuarioDAO.login(usuarioBean);

		if (usuario != null) {
			
			request.getSession().setAttribute("usuario", usuario);
			
			try {
				AdministradorBean administrador = (AdministradorBean) usuario;
				response.sendRedirect("admin_home.jsp");
				
			} catch (Exception e) {
				try {
					FuncionarioBean funcionario = (FuncionarioBean) usuario;
					
					if(funcionario.isFuncionarioAdmin()) {					
						response.sendRedirect("funcionario_admin_home.jsp");
					} else {
						response.sendRedirect("funcionario_home.jsp");
					}
				} catch (Exception e2) {
					response.sendRedirect("selecionarUnidade.html");
				}
			}
		} else {			
			fazerLogout(request,response);
		}
		
	}
	
	protected void fazerLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
	}

}
