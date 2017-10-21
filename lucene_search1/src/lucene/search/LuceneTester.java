package lucene.search;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
   String indexDir = "/working/active/ms/fall2017/IR/English59/Index";
   String dataDir = "/working/active/ms/fall2017/IR/English59";
   Indexer indexer;
   Searcher searcher;

   public static void main(String[] args) {
      LuceneTester tester;
      for (String str: args) {
    	  System.out.println("word to search: " + str);
	      try {
	         tester = new LuceneTester();
	         
	         tester.search(str);
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
      }
      System.out.println("finished");
   }


   private void search(String searchQuery) throws IOException, ParseException {
      searcher = new Searcher(indexDir);
      //long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      //long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +" documents found ,showing top 10");
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "+ doc.get(LuceneConstants.FILE_PATH));
      }
      searcher.close();
   }
}