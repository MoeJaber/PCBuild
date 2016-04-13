/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
/**
 * Class that is stored in the session and contains a list of Lucene document objects that represent store items used in search queries.
 * @author Kieran Gillibrand, Student: 040-756-866
 * @see org.apache.lucene
 */
public class SearchSet 
{
	/**
	 * Constant path to store the Lucene document cache in: <br /> <br />
	 * <b>Program Directory</b>/PCBuild/lucene-index
	 */
	final static Path INDEX_PATH = Paths.get (Paths.get ("").toAbsolutePath ().toString () + "/PCBuild/lucene-index");
	/**
	 * Max amount of results to display per page
	 */
	final static int PAGE_RESULTS = 30;
	
	Directory items = null;
	
	/**
	 * Private utility method to add Documents to the index
	 * @param writer Writer to add documents to the index
	 * @param url Database url to use
	 * @param driver Database driver to use
	 * @param dbUserName Database username to use
	 * @param dbPassword Database password to use
	 * @throws InstantiationException Issue with instantiating database driver
	 * @throws IllegalAccessException Issue with instantiating database driver
	 * @throws ClassNotFoundException Issue with instantiating database driver
	 * @throws SQLException SQL connection issue
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	private void addItems (final IndexWriter writer, final String url, final String driver, final String dbUserName, final String dbPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		if (writer == null || url == null || driver == null || dbUserName == null || dbPassword == null)
			throw new InvalidParameterException ();
		
		Class.forName (driver).newInstance ();  
        Connection dbConnection = DriverManager.getConnection (url, dbUserName, dbPassword);  
        
        PreparedStatement select = null;
        ResultSet results = null;
        
        //Cases
        select = dbConnection.prepareStatement ("Select * from pc_cases");
        results = select.executeQuery ();
        
        //Add all results as a document
        while (results.next ())
        {
        	//TextField is parsed and tokenized (searchable), StringField is a solid string (exact matches)
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("cases_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("cases_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("cases_name"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("cases_imagepath"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("cases_price")), Field.Store.YES));
        	
        	//Add document
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        select.close ();
        results.close ();
        
        //CPUs
        select = dbConnection.prepareStatement ("Select * from pc_cpu");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("cpu_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("cpu_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("cpu_name"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("cpu_imagepath"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("cpu_price")), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //GPUs
        select = dbConnection.prepareStatement ("Select * from pc_gpu");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("gpu_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("gpu_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("gpu_name"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("gpu_imagepath"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("gpu_price")), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //HDD
        select = dbConnection.prepareStatement ("Select * from pc_harddrive");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("harddrive_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("harddrive_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("harddrive_name"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("harddrive_price")), Field.Store.YES));
        	record.add (new TextField ("brand", results.getString ("harddrive_brand"), Field.Store.YES));
        	record.add (new TextField ("series", results.getString ("harddrive_series"), Field.Store.YES));
        	record.add (new TextField ("modelnum", results.getString ("harddrive_modelnum"), Field.Store.YES));
        	record.add (new TextField ("type", results.getString ("harddrive_type"), Field.Store.YES));
        	record.add (new TextField ("capacity", results.getString ("harddrive_capacity"), Field.Store.YES));
        	record.add (new TextField ("interface", results.getString ("harddrive_interface"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("harddrive_imagepath"), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //Headset
        select = dbConnection.prepareStatement ("Select * from pc_headset");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("headset_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("headset_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("headset_name"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("headset_price")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("headset_imagepath"), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //Memory
        select = dbConnection.prepareStatement ("Select * from pc_memory");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("memory_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("memory_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("memory_name"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("memory_price")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("memory_imagepath"), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //Motherboard
        select = dbConnection.prepareStatement ("Select * from pc_motherboard");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("motherboard_ID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("motherboard_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("motherboard_name"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("motherboard_price")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("motherboard_imagepath"), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //PSU
        select = dbConnection.prepareStatement ("Select * from pc_psu");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("psu_id"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("psu_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("psu_name"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("psu_price")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("psu_imagepath"), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        //SSD
        select = dbConnection.prepareStatement ("Select * from pc_ssd");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("ssd_id"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("ssd_model"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("ssd_name"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("ssd_price")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("ssd_imagepath"), Field.Store.YES));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }

        select.close ();
        results.close ();
        
        dbConnection.close ();
	}
	
	/**
	 * Searches the given fields in the lucene index for the given query
	 * @param fields The document fields to search in
	 * @param searchQuery The query to search with
	 * @return The search results as a list of documents
	 * @throws IOException If things go wrong
	 *  @author Kieran Gillibrand, Student: 040-756-866
	 */
	public ArrayList <Document> search (final String [] fields, final String searchQuery) throws IOException
	{
		if (fields == null || fields.length == 0 || searchQuery == null || searchQuery.length () == 0)
			throw new InvalidParameterException ();
		
		StandardAnalyzer analyzer = new StandardAnalyzer();
		
		Query query = null;
		
		//Parse the query
		try 
		{
			query = new MultiFieldQueryParser (fields, analyzer).parse (searchQuery);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace ();
		}
		
		//Read the index
		IndexReader reader = DirectoryReader.open (items);
		IndexSearcher searcher = new IndexSearcher (reader);
		TopDocs docs = searcher.search (query, PAGE_RESULTS);
		
		//Get the results and get the matching documents
		ScoreDoc [] hits = docs.scoreDocs;
		
		ArrayList <Document> results = new ArrayList <Document> ();
		
		for (ScoreDoc hit : hits)
		{
			int docID = hit.doc;
			results.add (searcher.doc (docID));
		}
		
		reader.close ();
		
		return results;
	}
	
	/**
	 * Constructor that takes a database url, driver, username, and password
	 * @param url The database URL to use
	 * @param driver The database driver to use
	 * @param dbUserName The database username to use
	 * @param dbPassword The database password to use
	 * @throws IOException If things go wrong
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public SearchSet (final String url, final String driver, final String dbUserName, final String dbPassword) throws IOException
	{
		if (url == null || driver == null || dbUserName == null || dbPassword == null)
			throw new InvalidParameterException ();
		
		//Recreate the index if it exists (DB might have changed)
		if (Files.exists (INDEX_PATH))
			FileUtils.deleteDirectory (new File (INDEX_PATH.toString ()));
		
		items = FSDirectory.open (INDEX_PATH);
		
		IndexWriter writer = new IndexWriter (items, new IndexWriterConfig (new StandardAnalyzer ()));

		//Add items to the index
		try 
		{
			addItems (writer, url, driver, dbUserName, dbPassword);
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace ();
		}
		
		writer.close ();
	}
		
	@Override
	public boolean equals (Object obj)
	{
		SearchSet equal = (SearchSet) obj;
		
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
		return items.toString ();
	}
}
