package connections.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class MYSQL {

	private static DataSource dataSource;
	private static GenericObjectPool connectionPool;

	public synchronized static void init() {
		if (dataSource != null) {
			return;
		}

		try {
			// Driver load
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");

			// jdbc url - ssl / timezone If not set, an error occurs when connecting and
			// added
			String jdbcUrl = "jdbc:mariadb://localhost:3306/kms_316?autoReconnect=true&characterEncoding=euckr&maxReconnects=100&CgonnectionTimeout=30000";
			String username = "root";
			String password = "fpemxkdl";

			// ConnectionFactory produce
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, password);

			// PoolableConnection A Factory that generate
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			// poolableConnFactory.setValidationQuery("select 1");

			// Connection pool configuration information
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// Specifies the execution cycle of the thread for extracting unused
			// connections. It is not executed if it is not positive. The unit is 1/1000
			// second
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// If true, then when extracting an inactive connection, the connection is
			// checked for validity and the invalid connection is removed from the pool.
			poolConfig.setTestWhileIdle(true);
			// Minimum number of connections that can be stored in the pool without being
			// used.
			poolConfig.setMinIdle(0);
			poolConfig.setMaxIdle(50000);
			// Maximum number of pools.
			poolConfig.setMaxTotal(50000);

			// Create and connect to connection pools
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			// Register the connection pool created in the connection pool driver
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("broker", connectionPool);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Connection conn = null;
		String jdbcDriver = "jdbc:apache:commons:dbcp:broker";
		try {
			conn = DriverManager.getConnection(jdbcDriver);
			conn.close();
		} catch (Exception e) {
			System.err.println(
					"[Notification] DB initialization failed. Check if DB server is turned on and DB user setting is correct.\r\n" + e.toString());
			System.exit(1000);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					System.out.println(ex);
				}
			}
		}
	}

	public static synchronized void shutdown() {
		try {
			connectionPool.close();
		} catch (Exception e) {
		}

		dataSource = null;
	}

	public static Connection getConnection() throws SQLException {
		String jdbcDriver = "jdbc:apache:commons:dbcp:broker";
		Connection con = DriverManager.getConnection(jdbcDriver);
		return con;
	}

	public static final int RETURN_GENERATED_KEYS = 1;

}
