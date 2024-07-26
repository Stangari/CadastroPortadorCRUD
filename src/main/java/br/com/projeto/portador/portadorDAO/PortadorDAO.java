package br.com.projeto.portador.portadorDAO;
import br.com.projeto.portador.entity.Portador;
import controller.ConnectionFactory;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PortadorDAO {

    public void create(Portador portador){
        String sql = "INSERT INTO portador(nome, CNPJ, CPF) VALUES (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionPostgres();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, portador.getNome());
            pstm.setString(2, portador.getCNPJ());
            pstm.setString(3, portador.getCPF());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);    // <- não adicionar essa linha
        } finally {try {
            if(pstm != null){
                pstm.close();
            }
            if (conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        }
    }

    public List<Portador> getPortador(){
        String sql = "SELECT * FROM portador";
        List<Portador> portadores = new ArrayList<Portador>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; //****NOVO
        try{
            conn = ConnectionFactory.createConnectionPostgres();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery(); //****NOVO

            while(rset.next()){
                Portador portador = new Portador();

                portador.setId(rset.getInt("id"));
                portador.setNome(rset.getString("nome"));
                portador.setCNPJ(rset.getString("cnpj"));
                portador.setCPF(rset.getString("cpf"));

                portadores.add(portador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);    // <- não adicionar essa linha
        } finally{
                try {
                if(rset != null){  //// Adicionar rset
                rset.close();
            }
                if (conn!=null){
                conn.close();
            }
                if(pstm != null){
                pstm.close();
            }
            }catch (SQLException e){
            e.printStackTrace();
        }
        }return portadores;
    }

    public static void update(Portador portador){
        String sql= "UPDATE portador SET nome = ?, cnpj = ?, cpf = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionPostgres();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, portador.getNome());
            pstm.setString(2, portador.getCNPJ());
            pstm.setString(3, portador.getCPF());

            pstm.setLong(4, portador.getId()); //set id

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);    // <- não adicionar essa linha
        } finally {try {
            if(pstm != null){
                pstm.close();
            }
            if (conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        }

    }

    public void deleteByID(int id){
        String sql = "DELETE FROM portador WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionPostgres();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);    // <- não adicionar essa linha
        } finally {try {
            if(pstm != null){
                pstm.close();
            }
            if (conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        }

    }

    }










