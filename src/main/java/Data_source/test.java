package Data_source;

import java.sql.*;

public class test {
    static String url = "jdbc:mysql://localhost:3306/gym_box";
    static String login = "root";
    static String pwd = "";
    static Connection con;
    static Statement ste;

    public test() {
    }

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie");

            ste = con.createStatement();
            String req = "INSERT INTO `Coach` (`id`, `nom`, `prenom`, `email`, `num`) VALUES (NULL, 'test1', 'tes1', 'email', 1265);";
            ste.executeUpdate(req);
            System.out.println("Coach ajouté");

            ResultSet rs = ste.executeQuery("SELECT * FROM Coach");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int num = rs.getInt("num");
                System.out.println("ID : " + id + " Nom : " + nom + " Prénom : " + prenom + " Numéro : " + num + " Email : " + email);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'accès à la base de données : " + e.getMessage());
        } finally {
            // Fermer les ressources
            try {
                if (ste != null) ste.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }
}
