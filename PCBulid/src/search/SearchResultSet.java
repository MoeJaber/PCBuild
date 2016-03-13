package search;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import cart.Item;

public class SearchResultSet 
{
	private IndexWriter writer = null;

	private void addTable (final IndexWriter writer, final String url, final String dbName, final String driver, final String dbUserName, final String dbPassword, final String tableName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName (driver).newInstance ();  
        Connection connection = DriverManager.getConnection (url + dbName, dbUserName, dbPassword);  
        
        
	}
	
	public SearchResultSet (final String url, final String dbName, final String driver, final String dbUserName, final String dbPassword) throws IOException
	{
		StandardAnalyzer analyzer = new StandardAnalyzer ();
		Directory index = new RAMDirectory ();
		IndexWriterConfig config = new IndexWriterConfig (analyzer);
		
		writer = new IndexWriter (index, config);
	}
		
	@Override
	public boolean equals (Object obj)
	{
		SearchResultSet equal = (SearchResultSet) obj;
		
		return (items.equals (equal.items));
	}
	
	@Override
	public int hashCode ()
	{
		return items.hashCode ();
	}
	
	@Override
	public String toString ()
	{
		StringBuilder returnString = new StringBuilder ("Items: \n");
		
		for (Item item : items)
			returnString.append (item.toString () + "\n");
		
		return returnString.toString ();
	}
}
