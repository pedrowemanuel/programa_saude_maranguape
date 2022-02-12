package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FuncionarioBean;
import model.FuncionarioDAO;
import model.UnidadeBean;
import model.UnidadeDAO;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {
		"/acessarLoginAdmin",
		"/acessarLoginProfissionalSaude",
		"/cidadao/selecionarUnidade",
		"/admin/fazerLogin",
		"/funcionario/fazerLogin",
		"/admin/acessarCadastroUnidade",
		"/admin/cadastrarUnidade",
		"/admin/acessarListarUnidades",
		"/admin/excluirUnidade",
		"/admin/acessarCadastroFuncionarioAdmin",
		"/admin/cadastrarFuncionarioAdmin",
		"/admin/acessarListarFuncionariosAdmin",
		"/admin/excluirFuncionario",
		"/funcionarioAdmin/acessarCadastroFuncionario",
		"/funcionarioAdmin/cadastrarFuncionario",
		"/funcionarioAdmin/acessarListarFuncionarios",
		"/funcionarioAdmin/acessarCadastroPostagem",
		"/funcionarioAdmin/cadastrarPostagem",
		"/funcionarioAdmin/acessarListarPostagens",
		"/funcionarioAdmin/excluirPostagem",
		"/funcionario/acessarCadastroPostagem",
		"/funcionario/cadastrarPostagem",
		"/funcionario/acessarListarPostagens",
		"/funcionario/excluirPostagem",
		"/cidadao/acessarPostagens",
		"/cidadao/acessarComentarios",
		"/cidadao/acessarCadastroComentario",
		"/cidadao/cadastrarComentario",
		"/cidadao/cadastrarRespostaComentario",
		"/deslogar"
	})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static boolean logado = false;

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
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
