package be.vdab.dao;

import javax.sql.DataSource;

public class AbstractDAO {
	public final static String JNDI_NAME = "jdbc/mssql";
	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
