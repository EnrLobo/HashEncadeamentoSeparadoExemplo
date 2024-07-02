package com.mycompany.estudocasosi2024.modelo.dao;

import com.mycompany.estudocasosi2024.modelo.entidade.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 10414032675
 */
public class CidadeDAO extends GenericoDAO<Cidade>{
    public void salvar(Cidade c){
        String insert = "INSERT INTO CIDADE(NOME,UF) VALUES (?,?)";
        save(insert, c.getNomeCidade(),c.getUfCidade());
    }
    
    public void alterar(Cidade c){
        String update = "UPDATE CIDADE SET NOME = ?,UF=? WHERE CODIGO=?";
        save(update, c.getNomeCidade(), c.getUfCidade(), c.getCodigoCidade());
    }
    
    public void excluir(Cidade c){
        String delete = "DELETE FROM CIDADE WHERE CODIGO = ?";
        save(delete, c.getCodigoCidade());
    }
    
    public Cidade buscarPorId(int id){
        String select = "SELECT * FROM CIDADE WHERE CODIGO=?";
        return buscarPorId(select, new CidadeRowMapper(), id);
    }
    
    public List<Cidade> buscarTodas(){
        String select = "SELECT FROM CIDADE";
        return buscarTodos(select, new CidadeRowMapper());
    }
    
    public static class CidadeRowMapper implements RowMapper<Cidade>{
        
        @Override
        public Cidade mapRow(ResultSet rs) throws SQLException{
            Cidade cidade = new Cidade();
            cidade.setCodigoCidade(rs.getInt("CODIGO"));
            cidade.setNomeCidade(rs.getString("NOME"));
            cidade.setUfCidade(rs.getString("UF"));
            return cidade;
        }
        
    }
    
}
