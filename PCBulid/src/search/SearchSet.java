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
        select = dbConnection.prepareStatement ("Select * from cases");
        results = select.executeQuery ();
        
        //Add all results as a document
        while (results.next ())
        {
        	//TextField is parsed and tokenized (searchable), StringField is a solid string (exact matches)
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("casesID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("casesModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("casesName"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("casesImagePath"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("casesPrice")), Field.Store.YES));
        	record.add (new StringField ("categoryName", "Cases", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from cpu");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("cpuID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("cpuModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("cpuName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("cpuPrice")), Field.Store.YES));
        	record.add (new TextField ("brand", results.getString ("cpuBrand"), Field.Store.YES));
        	record.add (new TextField ("series", results.getString ("cpuSeries"), Field.Store.YES));
        	record.add (new TextField ("modelnum", results.getString ("cpuModelNumber"), Field.Store.YES));
        	record.add (new TextField ("capacity", results.getString ("cpuCapacity"), Field.Store.YES));
        	record.add (new TextField ("interface", results.getString ("cpuInterface"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("cpuImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "CPU", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from gpu");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("gpuID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("gpuModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("gpuName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("gpuPrice")), Field.Store.YES));
        	record.add (new TextField ("brand", results.getString ("gpuBrand"), Field.Store.YES));
        	record.add (new TextField ("series", results.getString ("gpuSeries"), Field.Store.YES));
        	record.add (new TextField ("modelnum", results.getString ("gpuModelNumber"), Field.Store.YES));
        	record.add (new TextField ("capacity", results.getString ("gpuCapacity"), Field.Store.YES));
        	record.add (new TextField ("interface", results.getString ("gpuInterface"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("gpuImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "GPU", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from hdd");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("hddID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("hddModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("hddName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("hddPrice")), Field.Store.YES));
        	record.add (new TextField ("brand", results.getString ("hddBrand"), Field.Store.YES));
        	record.add (new TextField ("series", results.getString ("hddSeries"), Field.Store.YES));
        	record.add (new TextField ("modelnum", results.getString ("hddModelNumber"), Field.Store.YES));
        	record.add (new TextField ("capacity", results.getString ("hddCapacity"), Field.Store.YES));
        	record.add (new TextField ("interface", results.getString ("hddInterface"), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("hddImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "Harddrive", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from headset");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("headsetID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("headsetModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("headsetName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("headsetPrice")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("headsetImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "Headset", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from memory");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("memoryID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("memoryModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("memoryName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("memoryPrice")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("memoryImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "Memory", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from motherboard");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("motherboardID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("motherboardModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("motherboardName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("motherboardPrice")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("motherboardImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "Motherboard", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from psu");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("psuID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("psuModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("psuName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("psuPrice")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("psuImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "PSU", Field.Store.YES));
        	
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
        select = dbConnection.prepareStatement ("Select * from ssd");
        results = select.executeQuery ();
        
        while (results.next ())
        {
        	Document record = new Document ();
        	record.add (new IntField ("id", results.getInt ("ssdID"), Field.Store.YES));
        	record.add (new TextField ("model", results.getString ("ssdModel"), Field.Store.YES));
        	record.add (new TextField ("name", results.getString ("ssdName"), Field.Store.YES));
        	record.add (new TextField ("price", Double.toString (results.getDouble ("ssdPrice")), Field.Store.YES));
        	record.add (new StringField ("imagePath", results.getString ("ssdImagePath"), Field.Store.YES));
        	record.add (new StringField ("categoryName", "SSD", Field.Store.YES));
        	
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
	public SearchSet (final String url, final String driver, final String dbUserName, final String dbPassword, final Path indexPath) throws IOException
	{
		if (url == null || driver == null || dbUserName == null || dbPassword == null)
			throw new InvalidParameterException ();
		
		//Recreate the index if it exists (DB might have changed)
		if (Files.exists (indexPath))
			FileUtils.deleteDirectory (new File (indexPath.toString ()));
		
		items = FSDirectory.open (indexPath);
		
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
