package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.AdministradorBean;
import model.ComentarioBean;
import model.ComentarioDAO;
import model.FuncionarioBean;
import model.FuncionarioDAO;
import model.PostagemBean;
import model.PostagemDAO;
import model.RespostaComentarioBean;
import model.UnidadeBean;
import model.UnidadeDAO;
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
		"/funcionarioAdminExcluirFuncionario",
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
@MultipartConfig
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
		} else if (action.equals("/cidadaoSelecionarUnidade")) {
			response.sendRedirect("selecionarUnidade.html");
		} else if (action.equals("/adminAcessarCadastroUnidade")) {
			response.sendRedirect("cadastro_unidade.jsp");
		}  else if (action.equals("/adminCadastrarUnidade")) {
			cadastrarUnidade(request, response);
		}   else if (action.equals("/adminAcessarListarUnidades")) {
			listarUnidades(request, response);
		}   else if (action.equals("/adminExcluirUnidade")) {
			excluirUnidade(request, response);
		}   else if (action.equals("/adminAcessarCadastroFuncionarioAdmin")) {
			acessarCadastroFuncionarioAdmin(request, response);
		}   else if (action.equals("/adminCadastrarFuncionarioAdmin")) {
			cadastrarFuncioarioAdmin(request, response);
		}   else if (action.equals("/adminAcessarListarFuncionariosAdmin")) {
			listarFuncionariosAdmin(request, response);
		}   else if (action.equals("/adminExcluirFuncionario")) {
			excluirFuncionario(request, response);
			response.sendRedirect("adminAcessarListarFuncionariosAdmin");
		}   else if (action.equals("/funcionarioAdminAcessarCadastroFuncionario")) {
			acessarCadastroFuncionario(request, response);
		}   else if (action.equals("/funcionarioAdminCadastrarFuncionario")) {
			cadastrarFuncioario(request, response);
		}   else if (action.equals("/funcionarioAdminAcessarListarFuncionarios")) {
			listarFuncionarios(request, response);
		}   else if (action.equals("/funcionarioAdminExcluirFuncionario")) {
			excluirFuncionario(request, response);
			response.sendRedirect("funcionarioAdminAcessarListarFuncionarios");
		}   else if (action.equals("/funcionarioAdminAcessarCadastroPostagem")) {
			response.sendRedirect("cadastro_postagem_func_admin.jsp");
		}   else if (action.equals("/funcionarioAdminCadastrarPostagem")) {
			cadastrarPostagem(request, response);
			response.sendRedirect("funcionarioAdminAcessarListarPostagens");
		}   else if (action.equals("/funcionarioAdminAcessarListarPostagens")) {
			listarPostagensFuncionarioAdmin(request, response);
		}   else if (action.equals("/funcionarioAdminExcluirPostagem")) {
			excluirPostagem(request, response);
			response.sendRedirect("funcionarioAdminAcessarListarPostagens");
		}   else if (action.equals("/funcionarioAcessarCadastroPostagem")) {
			response.sendRedirect("cadastro_postagem_func.jsp");
		}   else if (action.equals("/funcionarioCadastrarPostagem")) {
			cadastrarPostagem(request, response);
			response.sendRedirect("funcionarioAcessarListarPostagens");
		}   else if (action.equals("/funcionarioAcessarListarPostagens")) {
			listarPostagensFuncionario(request, response);
		}   else if (action.equals("/funcionarioExcluirPostagem")) {
			excluirPostagem(request, response);
			response.sendRedirect("funcionarioAcessarListarPostagens");
		}   else if (action.equals("/cidadaoAcessarPostagens")) {
			listarPostagensCidadao(request, response);
		}   else if (action.equals("/cidadaoAcessarComentarios")) {
			listarComentarios(request, response);
		}   else if (action.equals("/cidadaoAcessarCadastroComentario")) {
			request.setAttribute("id_postagem", request.getParameter("id_postagem"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro_comentario.jsp");
			requestDispatcher.forward(request, response);
		}   else if (action.equals("/cidadaoCadastrarComentario")) {
			cadastrarComentario(request, response);
		}   else if (action.equals("/cidadaoCadastrarRespostaComentario")) {
			cadastrarRespostaComentario(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getPart("file") != null) {			
			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			
			request.setAttribute("link_arquivo", fileName);
		}
	
	    // ... (do your job here)
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
	
	protected void cadastrarUnidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidadeBean = new UnidadeBean(request.getParameter("nome"),request.getParameter("regiao"));
		UnidadeDAO unidadeDAO = new UnidadeDAO();
		unidadeDAO.cadastrar(unidadeBean);

		response.sendRedirect("adminAcessarListarUnidades");
	}
	
	protected void listarUnidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeDAO unidadeDAO = new UnidadeDAO();
		ArrayList<UnidadeBean> unidades = unidadeDAO.listar();
		
		request.setAttribute("unidades", unidades);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listar_unidades.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void excluirUnidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidadeBean = new UnidadeBean();
		unidadeBean.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));

		UnidadeDAO unidadeDAO = new UnidadeDAO();
		unidadeDAO.excluir(unidadeBean);
		
		response.sendRedirect("adminAcessarListarUnidades");
	}
	
	protected void acessarCadastroFuncionarioAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeDAO unidadeDAO = new UnidadeDAO();
		ArrayList<UnidadeBean> unidades = unidadeDAO.listar();
		
		request.setAttribute("unidades", unidades);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro_funcionario_admin.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void cadastrarFuncioarioAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidadeBean = new UnidadeBean();
		unidadeBean.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));

		FuncionarioBean funcionarioBean = new FuncionarioBean(
				request.getParameter("email"),
				request.getParameter("cpf"),
				request.getParameter("nome"),
				request.getParameter("cpf"),
				request.getParameter("cargo"),
				true,
				unidadeBean
			);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.cadastrar(funcionarioBean);

		response.sendRedirect("adminAcessarListarFuncionariosAdmin");
	}
	
	protected void listarFuncionariosAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioBean funcionarioBean = new FuncionarioBean();
		funcionarioBean.setFuncionarioAdmin(true);

		ArrayList<FuncionarioBean> funcionarios = funcionarioDAO.listar(funcionarioBean);
		
		request.setAttribute("funcionarios", funcionarios);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listar_funcionarios_admin.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void acessarCadastroFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeDAO unidadeDAO = new UnidadeDAO();
		ArrayList<UnidadeBean> unidades = unidadeDAO.listar();
		
		request.setAttribute("unidades", unidades);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro_funcionario.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void cadastrarFuncioario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidadeBean = new UnidadeBean();
		unidadeBean.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));

		FuncionarioBean funcionarioBean = new FuncionarioBean(
				request.getParameter("email"),
				request.getParameter("cpf"),
				request.getParameter("nome"),
				request.getParameter("cpf"),
				request.getParameter("cargo"),
				false,
				unidadeBean
			);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.cadastrar(funcionarioBean);

		response.sendRedirect("funcionarioAdminAcessarListarFuncionarios");
	}
	
	protected void listarFuncionarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		FuncionarioBean funcionarioBean = new FuncionarioBean();
		funcionarioBean.setFuncionarioAdmin(false);
		
		UnidadeBean unidade = new UnidadeBean();
		unidade.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));
		
		funcionarioBean.setUnidade(unidade);

		ArrayList<FuncionarioBean> funcionarios = funcionarioDAO.listar(funcionarioBean);
		
		request.setAttribute("funcionarios", funcionarios);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listar_funcionarios.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void excluirFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FuncionarioBean funcionarioBean = new FuncionarioBean();
		funcionarioBean.setIdFuncionario(Integer.parseInt(request.getParameter("id_funcionario")));

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.excluir(funcionarioBean);
	}
	
	protected void cadastrarPostagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FuncionarioBean funcionarioBean = new FuncionarioBean();
		funcionarioBean.setIdFuncionario(Integer.parseInt(request.getParameter("id_funcionario")));

		PostagemBean postagemBean = new PostagemBean(
				request.getParameter("mensagem"),
				new Date(),
				request.getParameter("link_imagem"),
				funcionarioBean
			);
		PostagemDAO postagemDAO = new PostagemDAO();
		postagemDAO.cadastrar(postagemBean);

	}
	
	protected void listarPostagensFuncionarioAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidade = new UnidadeBean();
		unidade.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));
		
		PostagemDAO postagemDAO = new PostagemDAO();
		ArrayList<PostagemBean> postagens = postagemDAO.listar(unidade);
		
		request.setAttribute("postagens", postagens);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listar_postagens_func_admin.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void excluirPostagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostagemBean postagemBean = new PostagemBean();
		postagemBean.setIdPostagem(Integer.parseInt(request.getParameter("id_postagem")));

		PostagemDAO postagemDAO = new PostagemDAO();
		postagemDAO.excluir(postagemBean);
	}

	protected void listarPostagensFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidade = new UnidadeBean();
		unidade.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));
		
		PostagemDAO postagemDAO = new PostagemDAO();
		ArrayList<PostagemBean> postagens = postagemDAO.listar(unidade);
		
		request.setAttribute("postagens", postagens);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listar_postagens_func.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void listarPostagensCidadao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnidadeBean unidade = new UnidadeBean();
		unidade.setIdUnidade(Integer.parseInt(request.getParameter("id_unidade")));
		
		PostagemDAO postagemDAO = new PostagemDAO();
		ArrayList<PostagemBean> postagens = postagemDAO.listar(unidade);
		
		request.setAttribute("postagens", postagens);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("feed_postagens.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void listarComentarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostagemBean postagem = new PostagemBean();
		postagem.setIdPostagem(Integer.parseInt(request.getParameter("id_postagem")));
		
		ComentarioDAO comentarioDAO = new ComentarioDAO();
		ArrayList<ComentarioBean> comentariosERespostas = comentarioDAO.listarComentariosERespostas(postagem);
		
		request.setAttribute("comentariosERespostas", comentariosERespostas);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("comentarios.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void cadastrarComentario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostagemBean postagemBean = new PostagemBean();
		postagemBean.setIdPostagem(Integer.parseInt(request.getParameter("id_postagem")));
		
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuario");

		ComentarioBean comentarioBean = new ComentarioBean(
				request.getParameter("mensagem"),
				new Date(),
				usuario,
				postagemBean
			);
		
		ComentarioDAO comentarioDAO = new ComentarioDAO();
		comentarioDAO.cadastrar(comentarioBean);
		
		request.setAttribute("id_postagem", request.getParameter("id_postagem"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cidadaoAcessarComentarios");
		requestDispatcher.forward(request, response);

	}
	
	protected void cadastrarRespostaComentario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostagemBean postagemBean = new PostagemBean();
		postagemBean.setIdPostagem(Integer.parseInt(request.getParameter("id_postagem")));
		
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuario");

		RespostaComentarioBean respostaComentarioBean = new RespostaComentarioBean(
				request.getParameter("mensagem"),
				new Date(),
				usuario,
				postagemBean,
				Integer.parseInt(request.getParameter("id_postagem"))
			);
		
		ComentarioDAO comentarioDAO = new ComentarioDAO();
		comentarioDAO.cadastrar(respostaComentarioBean);
		
		request.setAttribute("id_postagem", request.getParameter("id_postagem"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cidadaoAcessarComentarios");
		requestDispatcher.forward(request, response);

	}
}
