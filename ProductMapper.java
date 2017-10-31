package Filter;

import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProductMapper  extends Mapper<LongWritable, Text, Text, Text>  {

	public void map(LongWritable key, Text value, Context context)
		      throws IOException, InterruptedException {  
			  //Split value "|"
		 String[] svalue=value.toString().split(Pattern.quote("|"));
   	  if(!svalue[0].contains("NA") && !svalue[1].contains("NA"))  // Checking Company and Product Name not equal "NA"
   	  {
   		  context.write( value,null);
   	  }
	}
}
