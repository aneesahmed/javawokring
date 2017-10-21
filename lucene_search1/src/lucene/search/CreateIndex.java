package lucene.search;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class CreateIndex {
	
   String indexDir = "/working/active/ms/fall2017/IR/English59/Index";
   String dataDir = "/working/active/ms/fall2017/IR/English59";
   Indexer indexer;
   Searcher searcher;

   public static void main(String[] args) {
      CreateIndex index;
      try {
    	  index = new CreateIndex();
    	  index.createIndex();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private void createIndex() throws IOException {
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }

   
   
}