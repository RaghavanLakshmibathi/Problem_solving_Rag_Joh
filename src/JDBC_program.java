import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 SQL to create the database and tables before running:

 CREATE DATABASE IF NOT EXISTS studentdb;
 USE studentdb;

 CREATE TABLE team (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100),
     city VARCHAR(100)
 );

 CREATE TABLE player (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100),
     position VARCHAR(50),
     team_id INT,
     FOREIGN KEY (team_id) REFERENCES team(id)
 );
*/

// ---------- Model class for Team ----------
class Team {
    int id;
    String name;
    String city;

    Team(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", city=" + city + "]";
    }
}

// ---------- Model class for Player ----------
class Player {
    int id;
    String name;
    String position;
    int teamId;

    Player(int id, String name, String position, int teamId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.teamId = teamId;
    }

    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", position=" + position + ", teamId=" + teamId + "]";
    }
}

// ---------- Handles the database connection ----------
class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USERNAME = "root";
    static final String PASSWORD = "Ragav@#123";

    static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

// ---------- CRUD operations for Team ----------
class TeamDAO {

    // CREATE
    void addTeam(String name, String city) {
        String sql = "INSERT INTO team (name, city) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, city);
            ps.executeUpdate();
            System.out.println("Team added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                teams.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("city")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teams;
    }

    // RETRIEVE BY ID
    Team getTeamById(int id) {
        String sql = "SELECT * FROM team WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Team(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    void updateTeam(int id, String name, String city) {
        String sql = "UPDATE team SET name = ?, city = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Team updated successfully!" : "Team not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    void deleteTeam(int id) {
        String sql = "DELETE FROM team WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Team deleted successfully!" : "Team not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// ---------- CRUD operations for Player ----------
class PlayerDAO {

    // CREATE
    void addPlayer(String name, String position, int teamId) {
        String sql = "INSERT INTO player (name, position, team_id) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setInt(3, teamId);
            ps.executeUpdate();
            System.out.println("Player added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ ALL with PAGINATION
    List<Player> getAllPlayers(int pageNumber, int pageSize) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM player ORDER BY id LIMIT ? OFFSET ?";
        int offset = (pageNumber - 1) * pageSize;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                players.add(new Player(rs.getInt("id"), rs.getString("name"),
                        rs.getString("position"), rs.getInt("team_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

    // RETRIEVE BY ID
    Player getPlayerById(int id) {
        String sql = "SELECT * FROM player WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Player(rs.getInt("id"), rs.getString("name"),
                        rs.getString("position"), rs.getInt("team_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    void updatePlayer(int id, String name, String position, int teamId) {
        String sql = "UPDATE player SET name = ?, position = ?, team_id = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setInt(3, teamId);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Player updated successfully!" : "Player not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    void deletePlayer(int id) {
        String sql = "DELETE FROM player WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Player deleted successfully!" : "Player not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TRANSACTION: transfer a player to another team only if both updates succeed
    void transferPlayer(int playerId, int newTeamId) {
        String checkTeam = "SELECT id FROM team WHERE id = ?";
        String updatePlayer = "UPDATE player SET team_id = ? WHERE id = ?";
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false); // start transaction

            // Step 1: make sure the new team exists
            try (PreparedStatement ps = con.prepareStatement(checkTeam)) {
                ps.setInt(1, newTeamId);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    throw new Exception("Team " + newTeamId + " does not exist. Rolling back.");
                }
            }

            // Step 2: move the player to the new team
            try (PreparedStatement ps = con.prepareStatement(updatePlayer)) {
                ps.setInt(1, newTeamId);
                ps.setInt(2, playerId);
                int rows = ps.executeUpdate();
                if (rows == 0) {
                    throw new Exception("Player " + playerId + " not found. Rolling back.");
                }
            }

            con.commit(); // all good, save changes
            System.out.println("Player transferred successfully (transaction committed)!");
        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // undo everything on error
                    System.out.println("Transaction rolled back: " + e.getMessage());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

// ---------- Main menu program ----------
public class JDBC_program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDAO teamDAO = new TeamDAO();
        PlayerDAO playerDAO = new PlayerDAO();

        while (true) {
            System.out.println("\n===== Player Management System =====");
            System.out.println("1. Add Team");
            System.out.println("2. View All Teams");
            System.out.println("3. Get Team By Id");
            System.out.println("4. Update Team");
            System.out.println("5. Delete Team");
            System.out.println("6. Add Player");
            System.out.println("7. View All Players (Pagination)");
            System.out.println("8. Get Player By Id");
            System.out.println("9. Update Player");
            System.out.println("10. Delete Player");
            System.out.println("11. Transfer Player (Transaction)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    System.out.print("Enter team name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter city: ");
                    String city = sc.nextLine();
                    teamDAO.addTeam(name, city);
                    break;
                }
                case 2: {
                    for (Team t : teamDAO.getAllTeams()) {
                        System.out.println(t);
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter team id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Team t = teamDAO.getTeamById(id);
                    System.out.println(t != null ? t : "Team not found.");
                    break;
                }
                case 4: {
                    System.out.print("Enter team id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new city: ");
                    String city = sc.nextLine();
                    teamDAO.updateTeam(id, name, city);
                    break;
                }
                case 5: {
                    System.out.print("Enter team id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    teamDAO.deleteTeam(id);
                    break;
                }
                case 6: {
                    System.out.print("Enter player name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter team id: ");
                    int teamId = Integer.parseInt(sc.nextLine());
                    playerDAO.addPlayer(name, position, teamId);
                    break;
                }
                case 7: {
                    System.out.print("Enter page number: ");
                    int page = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter page size: ");
                    int size = Integer.parseInt(sc.nextLine());
                    for (Player p : playerDAO.getAllPlayers(page, size)) {
                        System.out.println(p);
                    }
                    break;
                }
                case 8: {
                    System.out.print("Enter player id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Player p = playerDAO.getPlayerById(id);
                    System.out.println(p != null ? p : "Player not found.");
                    break;
                }
                case 9: {
                    System.out.print("Enter player id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter new team id: ");
                    int teamId = Integer.parseInt(sc.nextLine());
                    playerDAO.updatePlayer(id, name, position, teamId);
                    break;
                }
                case 10: {
                    System.out.print("Enter player id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    playerDAO.deletePlayer(id);
                    break;
                }
                case 11: {
                    System.out.print("Enter player id: ");
                    int playerId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new team id: ");
                    int newTeamId = Integer.parseInt(sc.nextLine());
                    playerDAO.transferPlayer(playerId, newTeamId);
                    break;
                }
                case 0: {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
