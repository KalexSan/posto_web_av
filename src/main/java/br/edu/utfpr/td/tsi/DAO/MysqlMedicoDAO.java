package br.edu.utfpr.td.tsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.MODELO.Medico;

@Component
public class MysqlMedicoDAO implements MedicoDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void inserir(Medico medico) {
        String sql = " INSERT INTO medico (nome, sobrenome) VALUES (?, ?) ";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getSobrenome());
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Long id, Medico medico) {
        // TODO Auto-generated method stub
    }

    @Override
    public void remover(Long id) {
        String sql = " DELETE FROM medico WHERE idMedico = ? ";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medico> listarTodos() {
        ArrayList<Medico> medicos = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM medico");
            while (resultSet.next()) {
                Long id = resultSet.getLong("idMedico");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                medicos.add(new Medico(id, nome, sobrenome));
            }

            conn.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        
        }

        return medicos;
    }

    @Override
    public Medico procurar(Long id) {
        String sql = "SELECT * FROM medico WHERE idMedico = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                return new Medico(id, nome, sobrenome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
