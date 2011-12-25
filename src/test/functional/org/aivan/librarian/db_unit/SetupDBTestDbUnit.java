package org.aivan.librarian.db_unit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Test;

import com.mysql.jdbc.Connection;

/**
 * "By default, Dbunit performs a CLEAN_INSERT operation before executing each test and performs no cleanup operation afterward."
 * so, we use this as a test that needs to be run before all other tests.
 * 
 * @author aivan
 * 
 */
public class SetupDBTestDbUnit extends DBTestCase {

	public SetupDBTestDbUnit(String name) throws Exception {
		super(name);
		Properties props = new Properties();
		String dbConfiguration = System.getProperty("db.configuration","dev");
		props.load(new FileInputStream("config/"+dbConfiguration+"/db.properties"));

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, props.getProperty("db.driver"));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, props.getProperty("db.base.url")+"/"+props.getProperty("db.name"));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, props.getProperty("db.user"));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, props.getProperty("db.password"));

		String id = "http://www.dbunit.org/properties/datatypeFactory"; 
		this.getConnection().getConfig().setProperty(id, "org.dbunit.ext.mysql.MySqlDataTypeFactory");
		
}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new XmlDataSet(new FileInputStream("resources/db_unit_data/books.xml"));
	}

	@Test
	public void test() {
		assert (true);
	}

}
