package search;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class SearchSet 
{
	final static int PAGE_HITS = 30;
	
	private Directory items = null;

	private void addItems (final IndexWriter writer, final String url, final String dbName, final String driver, final String dbUserName, final String dbPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		if (writer == null || url == null || dbName == null || driver == null || dbUserName == null || dbPassword == null)
			throw new InvalidParameterException ();
		
		Class.forName (driver).newInstance ();  
        Connection dbConnection = DriverManager.getConnection (url + dbName, dbUserName, dbPassword);  
        
        PreparedStatement selectCases = dbConnection.prepareStatement ("Select * from pc_cases");
        ResultSet casesResults = selectCases.executeQuery ();
        
        while (casesResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", casesResults.getString ("cases_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", casesResults.getString ("cases_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", casesResults.getString ("cases_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectCPU = dbConnection.prepareStatement ("Select * from pc_cpu");
        ResultSet cpuResults = selectCPU.executeQuery ();
        
        while (cpuResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", cpuResults.getString ("cpu_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", cpuResults.getString ("cpu_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", cpuResults.getString ("cpu_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectGPU = dbConnection.prepareStatement ("Select * from pc_gpu");
        ResultSet gpuResults = selectGPU.executeQuery ();
        
        while (gpuResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", gpuResults.getString ("gpu_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", gpuResults.getString ("gpu_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", gpuResults.getString ("gpu_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectHDD = dbConnection.prepareStatement ("Select * from pc_harddrive");
        ResultSet hddResults = selectHDD.executeQuery ();
        
        while (hddResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", hddResults.getString ("harddrive_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", hddResults.getString ("harddrive_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", hddResults.getString ("harddrive_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectHeadset = dbConnection.prepareStatement ("Select * from pc_headset");
        ResultSet headsetResults = selectHeadset.executeQuery ();
        
        while (headsetResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", headsetResults.getString ("headset_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", headsetResults.getString ("headset_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", headsetResults.getString ("headset_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectMemory = dbConnection.prepareStatement ("Select * from pc_memory");
        ResultSet memoryResults = selectMemory.executeQuery ();
        
        while (memoryResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", memoryResults.getString ("memory_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", memoryResults.getString ("memory_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", memoryResults.getString ("memory_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectMotherboard = dbConnection.prepareStatement ("Select * from pc_motherboard");
        ResultSet motherboardResults = selectMotherboard.executeQuery ();
        
        while (motherboardResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", motherboardResults.getString ("motherboard_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", motherboardResults.getString ("motherboard_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", motherboardResults.getString ("motherboard_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectPSU = dbConnection.prepareStatement ("Select * from pc_psu");
        ResultSet psuResults = selectPSU.executeQuery ();
        
        while (psuResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", psuResults.getString ("psu_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", psuResults.getString ("psu_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", psuResults.getString ("psu_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        PreparedStatement selectSSD = dbConnection.prepareStatement ("Select * from pc_ssd");
        ResultSet ssdResults = selectSSD.executeQuery ();
        
        while (ssdResults.next ())
        {
        	Document record = new Document ();
        	record.add (new Field ("id", ssdResults.getString ("ssd_ID"), Field.Store.YES, Index.NO));
        	record.add (new Field ("model", ssdResults.getString ("ssd_model"), Field.Store.YES, Index.ANALYZED));
        	record.add (new Field ("name", ssdResults.getString ("ssd_name"), Field.Store.YES, Index.ANALYZED));
        	
        	try 
        	{
				writer.addDocument (record);
			} 
        	catch (IOException exception) 
        	{
				exception.printStackTrace ();
			}
        }
        
        dbConnection.close ();
	}
	
	public Directory getItems ()
	{
		return items;
	}
	
	public ScoreDoc [] search (final String field, final String searchQuery) throws IOException
	{
		if (field == null || searchQuery == null)
			throw new InvalidParameterException ();
		
		StandardAnalyzer analyzer = new StandardAnalyzer();
		
		Query query = new QueryBuilder (analyzer).createBooleanQuery (field, searchQuery);
		
		IndexReader reader = DirectoryReader.open (items);
		IndexSearcher searcher = new IndexSearcher (reader);
		TopDocs docs = searcher.search (query, PAGE_HITS);
		
		return docs.scoreDocs;
	}
	
	public SearchSet (final String url, final String dbName, final String driver, final String dbUserName, final String dbPassword) throws IOException
	{
		if (url == null || dbName == null || driver == null || dbUserName == null || dbPassword == null)
			throw new InvalidParameterException ();
		
		StandardAnalyzer analyzer = new StandardAnalyzer ();
		items = new RAMDirectory ();
		IndexWriterConfig config = new IndexWriterConfig (analyzer);
		
		IndexWriter writer = new IndexWriter (items, config);
		
		try 
		{
			addItems (writer, url, dbName, driver, dbUserName, dbPassword);
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace ();
		}
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
