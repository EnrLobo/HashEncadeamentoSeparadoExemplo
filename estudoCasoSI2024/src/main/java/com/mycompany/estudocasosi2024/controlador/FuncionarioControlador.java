/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estudocasosi2024.controlador;

import com.mycompany.estudocasosi2024.modelo.dao.CidadeDAO;
import com.mycompany.estudocasosi2024.modelo.dao.FuncionarioDAO;
import com.mycompany.estudocasosi2024.modelo.entidade.Cidade;
import com.mycompany.estudocasosi2024.servico.WebConstantes;
import com.mycompany.estudocasosi2024.modelo.entidade.Cidade;
import com.mycompany.estudocasosi2024.modelo.entidade.Funcionario;
import com.mycompany.estudocasosi2024.servico.ConverteData;
import com.mycompany.estudocasosi2024.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tulio
 */
@WebServlet(WebConstantes.BASE_PATH + "/FuncionarioControlador")
public class FuncionarioControlador extends HttpServlet {

    private CidadeDAO cidadeDao;
    private Cidade cidade;
    private FuncionarioDAO funcionarioDao;
    private Funcionario funcionario;
    
    String codigoFuncionario = "";
    String nomeFuncionario = "";
    String salarioFuncionario = "";
    String nascimentoFuncionario = "";
    String cidadeFuncionario = "";
    String opcao = "";
    private ConverteData converte = new ConverteData();

    @Override
    public void init() throws ServletException {
        cidadeDao = new CidadeDAO();
        cidade = new Cidade();
        funcionarioDao = new FuncionarioDAO();
        funcionario = new Funcionario();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            codigoFuncionario = request.getParameter("codigoFuncionario");
            nomeFuncionario = request.getParameter("nomeFuncionario");
            salarioFuncionario = request.getParameter("salarioFuncionario");
            nascimentoFuncionario = request.getParameter("nascimentoFuncionario");
            cidadeFuncionario = request.getParameter("cidadeFuncionario");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            switch (opcao) {
                case "cadastrar":  cadastrar(request, response); break;
                case "editar":  editar(request, response); break;
                case "confirmarEditar":  confirmarEditar(request, response); break;
                case "excluir":  excluir(request, response); break;
                case "confirmarExcluir":  confirmarExcluir(request, response); break;
                case "cancelar":  cancelar(request, response); break;
                default:
                    throw new IllegalArgumentException("Opção inválida"+opcao);
            }
          

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parâmetros não são numeros válidos");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        funcionario.setNomeFuncionario(nomeFuncionario);
        funcionario.setSalarioFuncionario(Double.valueOf(salarioFuncionario));
        funcionario.setNascimentoFuncionario(converte.converteCalendario(nascimentoFuncionario));
        funcionario.getCidadeFuncionario().setCodigoCidade(Integer.valueOf(cidadeFuncionario));
        funcionarioDao.salvar(funcionario);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigoFuncionario", codigoFuncionario);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nomeFuncionario", nomeFuncionario);
        request.setAttribute("salarioFuncionario", salarioFuncionario);
        request.setAttribute("nascimentoFuncionario", ConverteData.convertDateFormat(nascimentoFuncionario) );
        request.setAttribute("cidadeFuncionario", cidadeFuncionario);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigoFuncionario", codigoFuncionario);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nomeFuncionario", nomeFuncionario);
        request.setAttribute("salarioFuncionario", salarioFuncionario);
        request.setAttribute("nascimentoFuncionario", ConverteData.convertDateFormat(nascimentoFuncionario) );
        request.setAttribute("cidadeFuncionario", cidadeFuncionario);
        request.setAttribute("mensagem", "Clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        funcionario.setNomeFuncionario(nomeFuncionario);
        funcionario.setSalarioFuncionario(Double.valueOf(salarioFuncionario));
        funcionario.setNascimentoFuncionario(converte.converteCalendario(nascimentoFuncionario));
        funcionario.getCidadeFuncionario().setCodigoCidade(Integer.valueOf(cidadeFuncionario));
        funcionarioDao.alterar(funcionario);
        cancelar(request, response);
    }
     private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        funcionario.setNomeFuncionario(nomeFuncionario);
        funcionario.setSalarioFuncionario(Double.valueOf(salarioFuncionario));
        funcionario.setNascimentoFuncionario(converte.converteCalendario(nascimentoFuncionario));
        funcionario.getCidadeFuncionario().setCodigoCidade(Integer.valueOf(cidadeFuncionario));
        funcionarioDao.excluir(funcionario);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigoFuncionario", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nomeFuncionario", "");
        request.setAttribute("salarioFuncionario", "");
        request.setAttribute("nascimentoFuncionario", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Funcionario> funcionarios = funcionarioDao.buscarTodas();
        request.setAttribute("funcionarios", funcionarios);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFuncionario.jsp");
        dispatcher.forward(request, response);

    }
    
    public void validaCampos(){
        if(nomeFuncionario==null || nomeFuncionario.isEmpty()|| salarioFuncionario==null || salarioFuncionario.isEmpty()){
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}