// cc SmallFilesToSequenceFileConverter A MapReduce program for packaging a collection of small files as a single SequenceFile
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

// SmallFilesToSequenceFileConverter
//public class SmallFilesToSequenceFileConverter extends Configured
public class PicTest3 extends Configured
    implements Tool {
  
  static class SequenceFileMapper
      extends Mapper<NullWritable, BytesWritable, Text, BytesWritable> {
    
    private Text filenameKey;
    
    @Override
    protected void setup(Context context) throws IOException,
        InterruptedException {
//      输入key为文件路径.
//      InputSplit split = context.getInputSplit();
//      Path path = ((FileSplit) split).getPath();
//      filenameKey = new Text(path.toString());
//filename --> key
      InputSplit split = context.getInputSplit();
      Path path = ((FileSplit) split).getPath();
      filenameKey = new Text(path.getName());
    }
    
    @Override
    protected void map(NullWritable key, BytesWritable value, Context context)
        throws IOException, InterruptedException {
      context.write(filenameKey, value);
    }
    
  }
  
  static class SequenceFileReducer<Text, BytesWritable> extends
  				Reducer<Text, BytesWritable, Text, BytesWritable> {
	  protected void reduce(Text key, Iterable<BytesWritable> values, Context context) throws IOException, InterruptedException {
		  for(BytesWritable value : values) {
			  context.write(key, value);
		  }
	  }
  }

  @Override
  public int run(String[] args) throws Exception {
	  	Configuration conf = getConf();
	  	//conf.set("mapreduce.input.fileinputformat.input.dir.recursive", "true");
	    Job job = new Job(conf,"PicTest2");
	    job.setJarByClass(PicTest3.class);

	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(BytesWritable.class);

	    job.setMapperClass(SequenceFileMapper.class);
	    job.setInputFormatClass(WholeFileInputFormat.class);
	    job.setOutputFormatClass(SequenceFileOutputFormat.class);
	    //job.setOutputFormatClass(PicTest.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    return job.waitForCompletion(true) ? 0 : 1;
    }
  
  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new PicTest3(), args);
    System.exit(exitCode);
  }
}
// ^^ SmallFilesToSequenceFileConverter