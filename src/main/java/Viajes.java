import java.sql.*;
import java.util.Scanner;

public class Viajes {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****WELCOME*****");

        boolean aux = true;
        while (aux) {

            System.out.println("1. Registrar viaje: ");
            System.out.println("2. Visualizar departamento: ");
            System.out.println("3. Agendar viaje: ");
            System.out.println("4. Modificar información basica: ");
            System.out.println("5. Terminar");
            System.out.println("Ingrese un numero entre 1 - 5: ");
            int result = Integer.parseInt(scanner.nextLine());

            switch (result) {
                case 1:
                    System.out.print("Ingrese codigo del viaje: ");
                    String code = scanner.nextLine();

                    System.out.println("Ingrese su nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Ingrese su documento: ");
                    String document = scanner.nextLine();

                    System.out.print("Ingrese el estado del viaje: ");
                    String state = scanner.nextLine();

                    System.out.println("Ingrese puntos que acumulo durante el viaje: ");
                    String points = scanner.nextLine();

                    Insert(code, name, document, state, points);

                    break;

                case 2:
                    System.out.println("Departamentos destinos: ");

                    Select();

                    break;

                case 3:

                    System.out.println("Ingrese su documento: ");
                    document = scanner.nextLine();

                    String newdocument = Select_One(document);
                    if (newdocument.equals("")){
                        System.out.println("usuario no se encuentra registrado");
                    }else {

                        System.out.print("Ingrese codigo de viaje: ");
                        code = scanner.nextLine();

                        System.out.print("Ingrese departamento: ");
                        String department = scanner.nextLine();

                        System.out.print("Ingrese su nombre: ");
                        name = scanner.nextLine();

                        System.out.print("Indique el estado: ");
                        state = scanner.nextLine();

                        Editar(code, department, name, state);
                    }
                        break;

                case 4:
                    System.out.print("Ingrese su documento: ");
                    document = scanner.nextLine();

                    System.out.print("Ingrese su nuevo correo: ");
                    String email = scanner.nextLine();

                    System.out.print("Ingrese su nuevo celular: ");
                    String cellphone = scanner.nextLine();

                    System.out.println("Ingrese su nueva direccion: ");
                    String direction = scanner.nextLine();

                    Editar2(document, email, cellphone, direction);

                    break;

                case 5:
                    System.out.println("Finalizando...");

                    aux = false;

                    break;

                default:
                    System.out.println("Ingrese un numero valido");

            }
        }
    }

    private static String Select_One(String document) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/viajes";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consultaSQL = "SELECT * FROM cliente WHERE documento = ?";

        PreparedStatement statement = connection.prepareStatement(consultaSQL);
        statement.setString(1, document); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet.next()) {
            String codigo = resultSet.getString("codigo");
            String nombre = resultSet.getString("nombre");

            // Cerrar recursos
            resultSet.close();
            statement.close();
            connection.close();

            return document;

        }

        return "";

        }

    private static void Editar2(String document, String email, String cellphone, String direction) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/viajes";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consulta = "UPDATE cliente SET correo = ?, celular = ?, direccion = ? WHERE documento = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);

        preparedStatement.setString(1, email);
        preparedStatement.setString(2, cellphone);
        preparedStatement.setString(3, direction);
        preparedStatement.setString(4, document);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("información actualizada exitosamente");
        } else {
            System.out.println("No se encontró el registro para actualizar");
        }

        preparedStatement.close();
        connection2.close();
    }

    private static void Editar(String code, String department, String name, String state) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/viajes";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consulta = "UPDATE departamento SET departamento = ?, cliente = ?, reservas = ? WHERE codigo = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, department);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, state);
        preparedStatement.setString(4, code);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("reserva registrada exitosamente");
        } else {
            System.out.println("No se encontró el registro para actualizar");
        }

        preparedStatement.close();
        connection2.close();
    }

    private static void Select() throws ClassNotFoundException, SQLException {
        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/viajes";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM departamento");

        while(resultSet2.next()){

            String codigo = resultSet2.getString("codigo");
            String departamento = resultSet2.getString("departamento");

            System.out.println("este es el codigo del viaje "+codigo+  " departameto "+ departamento);
        }
    }

    private static void Insert(String code, String name, String document, String state, String points) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/viajes";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM informacion");


            // Sentencia INSERT
            String sql = "INSERT INTO informacion (codigo, nombre, documento, estado, puntos) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, document);
            preparedStatement.setString(4, state);
            preparedStatement.setString(5, points);


            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("viaje registrado de exitosamente.");
            } else {
                System.out.println("No se pudo registrar su viaje");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}