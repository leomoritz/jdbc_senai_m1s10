import java.sql.*;

public class AppMain {
    public static void main(String[] args) {

        //Declarando os parâmetros para o banco
        String url = "jdbc:postgresql://localhost:5432/m1s10?currentSchema=exercicio_2";
        String user = "postgres";
        String password = "admin";

        //Abrindo transação com o uso de try with resources que encerra a conexão com o banco ao sair do bloco trycatch
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            //Realizando transação com o banco
            Statement stm = connection.createStatement();
//            stm.execute("INSERT INTO PRODUTOS (nome, descricao) " +
//                    "VALUES ('Curso Java', 'Curso DevInHouse sobre Java')", Statement.RETURN_GENERATED_KEYS);
//            ResultSet result = stm.getGeneratedKeys();
//            while(result.next()){
//                int id = result.getInt(1);
//                System.out.println("Insert realizado com sucesso! Id registrado: " + id);
//            }

            stm.execute("SELECT * FROM PRODUTOS");
            ResultSet resultSet = stm.getResultSet();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String descricao = resultSet.getString(3);
                System.out.println(id + " | " + nome + " | " + descricao);
            }

//            stm.execute("UPDATE PRODUTOS SET nome = 'Curso Java e Spring Boot' WHERE id = 2");
//            int updateCount = stm.getUpdateCount();
//            System.out.println("Quantidade de registros alterados: " + updateCount);
//
//            stm.execute("DELETE FROM PRODUTOS WHERE id = 1");
//            int deleteCount = stm.getUpdateCount();
//            System.out.println("Quantidade de registros alterados: " + deleteCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
