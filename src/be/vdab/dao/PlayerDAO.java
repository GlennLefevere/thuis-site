package be.vdab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.vdab.entities.Player;
import be.vdab.entities.TextChar;

public class PlayerDAO extends AbstractDAO{
	private static final String SQL_SELECT = "SELECT [UID], [ID],[PWD]FROM [kal_auth].[dbo].[Login]";
	private List<TextChar> decode = new ArrayList<>();


	public PlayerDAO(){
		decode.add(new TextChar("a", "48"));
		decode.add(new TextChar("b", "DB"));
		decode.add(new TextChar("c", "FC"));
		decode.add(new TextChar("d", "09"));
		decode.add(new TextChar("e", "1F"));
		decode.add(new TextChar("f", "94"));
		decode.add(new TextChar("g", "12"));
		decode.add(new TextChar("h", "73"));
		decode.add(new TextChar("i", "37"));
		decode.add(new TextChar("j", "82"));
		decode.add(new TextChar("k", "81"));
		decode.add(new TextChar("l", "39"));
		decode.add(new TextChar("m", "C2"));
		decode.add(new TextChar("n", "8D"));
		decode.add(new TextChar("o", "7D"));
		decode.add(new TextChar("p", "08"));
		decode.add(new TextChar("q", "4F"));
		decode.add(new TextChar("r", "B0"));
		decode.add(new TextChar("s", "FE"));
		decode.add(new TextChar("t", "79"));
		decode.add(new TextChar("u", "0B"));
		decode.add(new TextChar("v", "D6"));
		decode.add(new TextChar("w", "23"));
		decode.add(new TextChar("x", "7C"));
		decode.add(new TextChar("y", "4B"));
		decode.add(new TextChar("z", "8E"));
		decode.add(new TextChar("A", "FF"));
		decode.add(new TextChar("B", "F3"));
		decode.add(new TextChar("C", "F8"));
		decode.add(new TextChar("D", "9B"));
		decode.add(new TextChar("E", "50"));
		decode.add(new TextChar("F", "51"));
		decode.add(new TextChar("G", "6D"));
		decode.add(new TextChar("H", "E9"));
		decode.add(new TextChar("I", "9A"));
		decode.add(new TextChar("J", "B8"));
		decode.add(new TextChar("K", "84"));
		decode.add(new TextChar("L", "A8"));
		decode.add(new TextChar("M", "14"));
		decode.add(new TextChar("N", "38"));
		decode.add(new TextChar("O", "CE"));
		decode.add(new TextChar("P", "92"));
		decode.add(new TextChar("Q", "5C"));
		decode.add(new TextChar("R", "F5"));
		decode.add(new TextChar("S", "EE"));
		decode.add(new TextChar("T", "B3"));
		decode.add(new TextChar("U", "89"));
		decode.add(new TextChar("V", "7B"));
		decode.add(new TextChar("W", "A2"));
		decode.add(new TextChar("X", "AD"));
		decode.add(new TextChar("Y", "71"));
		decode.add(new TextChar("Z", "E3"));
		decode.add(new TextChar("0", "2C"));
		decode.add(new TextChar("1", "3A"));
		decode.add(new TextChar("2", "4A"));
		decode.add(new TextChar("3", "91"));
		decode.add(new TextChar("4", "5D"));
		decode.add(new TextChar("5", "7A"));
		decode.add(new TextChar("6", "29"));
		decode.add(new TextChar("7", "BC"));
		decode.add(new TextChar("8", "6E"));
		decode.add(new TextChar("9", "D4"));
		decode.add(new TextChar("!", "95"));
		decode.add(new TextChar("\"", "88"));
		decode.add(new TextChar("#", "9D"));
		decode.add(new TextChar("$", "4C"));
		decode.add(new TextChar("%", "F2"));
		decode.add(new TextChar("&", "3E"));
		decode.add(new TextChar("\\", "BB"));
		decode.add(new TextChar("(", "C0"));
		decode.add(new TextChar(")", "7F"));
		decode.add(new TextChar("*", "18"));
		decode.add(new TextChar("+", "70"));
		decode.add(new TextChar(",", "A6"));
		decode.add(new TextChar("-", "E2"));
		decode.add(new TextChar(".", "EC"));
		decode.add(new TextChar("/", "77"));
		decode.add(new TextChar(":", "40"));
		decode.add(new TextChar(";", "17"));
		decode.add(new TextChar("<", "2E"));
		decode.add(new TextChar("=", "CB"));
		decode.add(new TextChar(">", "72"));
		decode.add(new TextChar("?", "9C"));
		decode.add(new TextChar("@", "A1"));
		decode.add(new TextChar("[", "D5"));
		decode.add(new TextChar("\\\\", "BF"));
		decode.add(new TextChar("]", "53"));
		decode.add(new TextChar("^", "28"));
		decode.add(new TextChar("_", "44"));
		decode.add(new TextChar("`", "33"));
		decode.add(new TextChar("{", "06"));
		decode.add(new TextChar("|", "5A"));
		decode.add(new TextChar("}", "CC"));
		decode.add(new TextChar("~", "62"));
	}
	public Iterable<Player> findAll() {
		try (Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_SELECT)) {
		List<Player> players = new ArrayList<>();
		while (resultSet.next()) {
		players.add(resultSetRijNaarPlayers(resultSet));
		}
		return players;
		} catch (SQLException ex) {
			System.out.println(ex);
		throw new DAOException();
		}
		}
	private Player resultSetRijNaarPlayers(ResultSet resultSet) throws SQLException{
		String pwdEncrypted = resultSet.getString("PWD");
		String pwdDecrypted = "";
		if(pwdEncrypted.length()%2 == 0){
			int vorige = 0;
			for(int x = 2; x <= pwdEncrypted.length(); x++, x++){
				String sub = pwdEncrypted.substring(vorige, x);
				pwdDecrypted +=decrypt(sub);
				vorige = x;
			}
		}
		
		return new Player(pwdDecrypted, resultSet.getString("ID"), resultSet.getInt("UID"));
	}
	private String decrypt(String sub) {
		for (TextChar textChar : decode) {
			if(textChar.getHex().equals(sub)){
				sub = textChar.getCharachter();
				break;
			}
		}
		return sub;
		
	}
	public int findPlayer(String id, String pwd){
		int temp = -1;
		List<Player> accounts = (List<Player>) findAll();
		for (Player player : accounts) {
			if(player.getName().equals(id) && player.getPwd().equals(pwd)){
				temp = player.getId();
			}
		}
		return temp;
	}
}
